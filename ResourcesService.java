/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hand.emp.fnd.services.rest;

import com.hand.emp.fnd.model.entities.FndResources;
import com.hand.emp.fnd.model.facades.FndResourcesFacade;
import com.hand.emp.view.services.rest.base.RestBaseService;
import com.hand.emp.view.services.rest.base.ServiceResponse;
import com.zerowire.ws.PublicMethod;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author snipking
 */
@Path("v1/sec/resources")
@RequestScoped
public class ResourcesService extends RestBaseService<ResourcesService> {

    @Context
    private UriInfo context;
    @EJB
    FndResourcesFacade fndResourcesFacade;

    //private String localBasePath = "/u01/localsavefile/";
    private String localBasePath = "\\\\N:\\handhold\\";
    private String qiniuBasePath = "http://sofia-mobile.qiniudn.com/";

    static final Logger logger = Logger.getLogger(ResourcesService.class.getName());

    public ResourcesService() {
        super();
    }

    @GET
    @Path("{resId}")
    public void getResource(@PathParam("resId") String resId, @Context HttpServletResponse response, @Context HttpServletRequest request) {

        FndResources fndResource = fndResourcesFacade.find(resId);

        if (fndResource != null) {

            if (logger.isLoggable(Level.FINEST)) {
                logger.log(Level.FINEST, "Fetch FndResource from db: {0}", this.getGson().toJson(fndResource));
            }

            try {
                if ("LOCAL".equals(fndResource.getStorageLocCode())) { //file store in local server, return it direct
                    this.returnLocalResource(fndResource, response, request);
                } else if ("QINIU".equals(fndResource.getStorageLocCode())) { //file store in QINIU network storage, forward to file url
                    //process query params
                    response.sendRedirect(qiniuBasePath + fndResource.getFilePath() + "?" + request.getQueryString());
                } else { //unknow file storage info, forward to resource info
                    response.sendRedirect("info/" + resId);
                }
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage(), e);
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                try {
                    response.getWriter().print(new ServiceResponse("ERROR", e, "Unknow Error: " + e.getMessage(), null));
                    response.getWriter().flush();
                    response.getWriter().close();
                } catch (IOException ex) {
                    Logger.getLogger(ResourcesService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else { // resource not found, return 404

            if (logger.isLoggable(Level.FINE)) {
                logger.log(Level.FINE, "FndResource with ID ''{0}'' not found.", resId);
            }
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            try {
                response.getWriter().print(this.getGson().toJson(new ServiceResponse("ERROR", "Resource with ID " + resId + " not found.", "Resource Not Found.", null)));
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException ex) {
                Logger.getLogger(ResourcesService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void returnLocalResource(FndResources fndResource, HttpServletResponse response, HttpServletRequest request) {
        if (fndResource != null) {
            String fileFullPath = localBasePath + fndResource.getFilePath();
            File downloadFile = new File(fileFullPath);
            long fileLength = downloadFile.length();
            long pastLength = 0;
            int rangeSwitch = 0; //0: download from beginning 1: download from given bytes to end like bytes=27000-end 3: download between bytes like bytes=27000-39000 
            long toLength = 0;  //end byte requested
            long contentLength = 0;  //total bytes reqeusted  
            String rangeBytes = "";  //requested download range string from request header  
            RandomAccessFile randomAccessFile = null;  //Random file reader
            OutputStream outputStream = null;
            byte buffer[] = new byte[1024];

            if (request.getHeader("Range") != null) {  // download from requested bytes
                response.setStatus(javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT);
                logger.log(Level.FINE, "request.getHeader(\"Range\")={0}", request.getHeader("Range"));
                rangeBytes = request.getHeader("Range").replaceAll("bytes=", "");
                if (rangeBytes.indexOf('-') == rangeBytes.length() - 1) {
                    rangeSwitch = 1;
                    rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                    pastLength = Long.parseLong(rangeBytes.trim());
                    contentLength = fileLength - pastLength + 1;
                } else {
                    rangeSwitch = 2;
                    pastLength = Long.parseLong(rangeBytes.substring(0, rangeBytes.indexOf('-')).trim());
                    toLength = Long.parseLong(rangeBytes.substring(rangeBytes.indexOf('-') + 1, rangeBytes.length()).trim());
                    contentLength = toLength - pastLength + 1;
                }
            } else {  //download from beginning
                contentLength = fileLength;
            }

            response.reset();
            response.setHeader("Accept-Ranges", "bytes"); // accept download by bytes 
            if (pastLength != 0) {  // if not download from beginning, response 206  
                logger.log(Level.FINE, "detect download start point: download from given bytes");
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                switch (rangeSwitch) {
                    case 1: {
                        String contentRange = new StringBuffer("bytes ").append(Long.toString(pastLength)).append("-").append(Long.toString(fileLength - 1)).append("/").append(Long.toString(fileLength)).toString();
                        response.setHeader("Content-Range", contentRange);
                        break;
                    }
                    case 2: {
                        String contentRange = rangeBytes + "/" + Long.toString(fileLength);
                        response.setHeader("Content-Range", contentRange);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } else {  // download from beginning  
                logger.log(Level.FINE, "detect download start point: download from beginning");
            }

            response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
            response.setContentType(fndResource.getContentType());//set the MIME type
            response.addHeader("Content-Length", String.valueOf(contentLength));

            try {
                outputStream = new BufferedOutputStream(response.getOutputStream());
                randomAccessFile = new RandomAccessFile(downloadFile, "r");

                switch (rangeSwitch) {
                    case 0: { // same as case 1  
                    }
                    case 1: { // download from given bytes to end like bytes=27000-end 
                        randomAccessFile.seek(pastLength);//?? bytes=969998336- ????????? 969998336  ???  
                        int readSize = 0;
                        while ((readSize = randomAccessFile.read(buffer, 0, 1024)) != -1) {
                            outputStream.write(buffer, 0, readSize);
                        }
                        break;
                    }
                    case 2: { // download between bytes like bytes=27000-39000 
                        randomAccessFile.seek(pastLength - 1);
                        int readSize = 0;
                        long readLength = 0; // bytes have read
                        while (readLength <= contentLength - 1024) { // read from file to buffer  
                            readSize = randomAccessFile.read(buffer, 0, 1024);
                            readLength += 1024;
                            outputStream.write(buffer, 0, readSize);
                        }
                        if (readLength <= contentLength) { // read servel parts  
                            readSize = randomAccessFile.read(buffer, 0, (int) (contentLength - readLength));
                            outputStream.write(buffer, 0, readSize);
                        }
                        break;
                    }
                    default: {
                        break;
                    }
                }
                outputStream.flush();
            } catch (IOException ie) {
                logger.log(Level.SEVERE, ie.getMessage(), ie);
                if (ie instanceof SocketException) {
                    logger.log(Level.WARNING, "File download warning, connection may reset by peer: {0}", ie.getMessage());
                } else {
                    ie.printStackTrace();
                }
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, e.getMessage(), e);
                        e.printStackTrace();
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, e.getMessage(), e);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @GET
    @Path("info/{resId}")
    @Produces("applicaton/json; charset=UTF-8")
    public String getResourceInfo(@PathParam("resId") String resId, @Context HttpServletResponse response) {
        String result = null;
        FndResources fndResource = fndResourcesFacade.find(resId);
        if (fndResource != null) {
            result = this.getGson().toJson(fndResource);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return result;
    }

    /**
     * Follow RFC1867 request header:
     *
     * Content-Length: 495 Content-Type: multipart/form-data; boundary=---------------------------7db2d1bcc50e6e
     *
     * request body:
     *
     * -----------------------------7db2d1bcc50e6e Content-Disposition: form-data; name="<UUID>"; filename="<file name>" Content-Type: <content type>
     *
     * <FileDataWithByte> -----------------------------7db2d1bcc50e6e--
     *
     * support multi file upload in one request in each part name means item.FieldName which is uuid; filename means item.name which is file real name Content-Type means item.contentType which is file
     * content type
     *
     * @return
     */
    @POST
    public String postResource(@Context HttpServletRequest request) throws Exception {
        boolean saveResult = false;

        try {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<DiskFileItem> items = upload.parseRequest(request);

            if (logger.isLoggable(Level.FINE)) {
                logger.log(Level.FINE, "request items size: {0}", items.size());
                logger.log(Level.FINE, "request items: {0}", items);
                Enumeration<String> headers = request.getHeaderNames();
                for (String e = headers.nextElement(); headers.hasMoreElements(); e = headers.nextElement()) {
                    logger.log(Level.FINE, "Header Key: {0} Value: {1}", new Object[]{e, request.getHeader(e)});
                }
            }

            if (items != null) {
                for (DiskFileItem item : items) {
                    try {
                        saveResult = this.saveResource(item.getFieldName(), item.getName(), item.getContentType(), item.getInputStream());
                        
                        //调用siebel图片更新接口
                        String fileName = item.getFieldName();
                        fileName = fileName + ".jpg";
                        String filePath = "\\\\192.168.0.70\\siebel_share\\handhold\\"+fileName;
        
                        logger.log(Level.INFO, "ResourceService fileName:"+fileName);
                        logger.log(Level.INFO, "ResourceService filePath:"+filePath);
                        
                        PublicMethod method = new PublicMethod();
                        HashMap<String, String> result = method.updateFile(filePath, fileName);
                        if(result.containsKey("returnStatus") && result.get("returnStatus").equals("OK")){
                            //上传成功
                            String attachId = result.get("attachId");//siebel的附件id
                            logger.log(Level.INFO,"{\"result\":\"0\",\"errorMsg\":\"上传更改的附件信息成功\"}");
                        }else{
                            logger.log(Level.INFO, "'{'\"result\":\"1\",\"errorMsg\":\"{0}\"'}'", result.get("errorMsg"));
                        }
           
                    } catch (IOException ex) {
                        logger.log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (FileUploadException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        ServiceResponse serviceResponse = saveResult ? new ServiceResponse("SUCCESS") : new ServiceResponse("FAILED");
        return this.getGson().toJson(serviceResponse);
    }

    private boolean saveResource(String resId, String resName, String contentType, InputStream is) {

        if (logger.isLoggable(Level.FINE)) {
            logger.log(Level.FINE, "--Resource Uploaded--");
            logger.log(Level.FINE, "resId: {0}", resId);
            logger.log(Level.FINE, "resName: {0}", resName);
            logger.log(Level.FINE, "contentType: {0}", contentType);
            logger.log(Level.FINE, "--------------------");
        }

        if (resId == null || resId.trim().equals("")
                || resName == null || resName.trim().equals("")
                || contentType == null || contentType.trim().equals("")) {
            return false;
        }

        try {
            File outputFile = new File(this.localBasePath + resId + ".jpg");
            FileOutputStream fileStream = new FileOutputStream(outputFile);
            {
                int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                int byteCount = 0;

                while ((byteCount = is.read(buffer, 0, bufferSize)) > 0) {
                    fileStream.write(buffer, 0, byteCount);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }

        FndResources resource = new FndResources(resId, "LOCAL");
        FndResources fndResource = fndResourcesFacade.findByResourceId(resId);
        if (fndResource == null) {
            if("image/jpeg".equals(contentType)){
                resource.setFileName(resName);
                resource.setContentType(contentType);
                resource.setFilePath(resId+".jpg");
                fndResourcesFacade.create(resource);
            }
        } else {
            if("image/jpeg".equals(contentType)){
                fndResource.setFileName(resName);
                fndResource.setContentType(contentType);
                fndResource.setFilePath(resId+".jpg");
                fndResourcesFacade.edit(fndResource);
            }
        }
        return true;
    }
}
