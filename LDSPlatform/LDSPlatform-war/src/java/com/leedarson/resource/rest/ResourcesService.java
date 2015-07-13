/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leedarson.resource.rest;

import com.leedarson.entities.oqc.DroidOqcResource;
import com.leedarson.facades.oqc.DroidOqcResourceFacadeLocal;
import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Enumeration;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
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
@Path("resources")
@RequestScoped
public class ResourcesService {

    @Context
    private UriInfo context;
    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;
    
    @EJB
    private DroidOqcResourceFacadeLocal resourcesFacade;
//    private String basePath = "/home/oracle/Desktop/LDS_upload_pictures/";
//    private String basePath = "/home/chenfeng/Desktop/LEEDARSON/uploadpicture/";
    private String basePath = "/mntpt/padfile/PDAfile/";
    Logger logger = Logger.getLogger(ResourcesService.class.getName());

    public ResourcesService() {
        super();
    }
    @GET
    public String getTest(){
        return "getTest is called";
    }

    @GET
    @Path("{resId}")
    //    @Produces("application/xml")
    public String getResource(@PathParam("resId") String resId) {
        String fileFullPath = basePath + resId;
        if (resId != null) {
            File downloadFile = new File(fileFullPath);
            long fileLength = downloadFile.length(); 
            long pastLength = 0;
            int rangeSwitch = 0; 
            long toLength = 0; 
            long contentLength = 0; 
            String rangeBytes = ""; 
            RandomAccessFile raf = null;
            OutputStream os = null;
            OutputStream out = null;
            byte b[] = new byte[1024];
            
            if (request.getHeader("Range") != null) {
                response.setStatus(javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT);
                logger.info("request.getHeader(\"Range\")=" + request.getHeader("Range"));
                rangeBytes = request.getHeader("Range").replaceAll("bytes=", "");
                if (rangeBytes.indexOf('-') == rangeBytes.length() - 1) {
                    rangeSwitch = 1;
                    rangeBytes = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                    pastLength = Long.parseLong(rangeBytes.trim());
                    contentLength = fileLength - pastLength + 1;//
                } else {
                    rangeSwitch = 2;
                    String temp0 = rangeBytes.substring(0, rangeBytes.indexOf('-'));
                    String temp2 = rangeBytes.substring(rangeBytes.indexOf('-') + 1, rangeBytes.length());
                    pastLength = Long.parseLong(temp0.trim());//
                    toLength = Long.parseLong(temp2);//
                    contentLength = toLength - pastLength + 1;
                }
            } else {
                contentLength = fileLength;
            }

            
            response.reset();//
            response.setHeader("Accept-Ranges", "bytes");
            if (pastLength != 0) {
               
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                switch (rangeSwitch) {
                    case 1: {
                        String contentRange = new StringBuffer("bytes ").append(new Long(pastLength).toString()).append("-").append(new Long(fileLength - 1).toString()).append("/").append(new Long(fileLength).toString()).toString();
                        response.setHeader("Content-Range", contentRange);
                        break;
                    }
                    case 2: {
                        String contentRange = rangeBytes + "/" + new Long(fileLength).toString();
                        response.setHeader("Content-Range", contentRange);
                        break;
                    }
                    default: {
                        break;
                    }
                }
            } else {
                
            }

            try {
                response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile.getName() + "\"");
                response.setContentType("image/jpeg");//set the MIME type
                response.addHeader("Content-Length", String.valueOf(contentLength));

                os = response.getOutputStream();
                out = new BufferedOutputStream(os);
                raf = new RandomAccessFile(downloadFile, "r");
                try {
                    switch (rangeSwitch) {
                        case 0: {
                            
                        }
                        case 1: {
                            raf.seek(pastLength);
                            int n = 0;
                            while ((n = raf.read(b, 0, 1024)) != -1) {
                                out.write(b, 0, n);
                            }
                            break;
                        }
                        case 2: {
                            raf.seek(pastLength - 1);
                            int n = 0;
                            long readLength = 0;
                            while (readLength <= contentLength - 1024) {
                                n = raf.read(b, 0, 1024);
                                readLength += 1024;
                                out.write(b, 0, n);
                            }
                            if (readLength <= contentLength) {
                                n = raf.read(b, 0, (int) (contentLength - readLength));
                                out.write(b, 0, n);
                            }
                            
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    out.flush();
                } catch (IOException ie) {
                   ie.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.SEVERE, e.getMessage(), e);
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, e.getMessage(), e);
                    }
                }
                if (raf != null) {
                    try {
                        raf.close();
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, e.getMessage(), e);
                    }
                }
            }
        }

        return null;
    }

    /**
     * Follow RFC1867 request header:
     *
     * Content-Length: 495 Content-Type: multipart/form-data;
     * boundary=---------------------------7db2d1bcc50e6e
     *
     * request body:
     *
     * -----------------------------7db2d1bcc50e6e Content-Disposition:
     * form-data; name="resId"
     *
     * <UUID> -----------------------------7db2d1bcc50e6e Content-Disposition:
     * form-data; name="resName" Content-Type: text/plain
     *
     * <FileName> -----------------------------7db2d1bcc50e6e
     * Content-Disposition: form-data; name="upload2"; filename="file2.txt"
     * Content-Type: text/plain
     *
     * <FileDataWithByte> -----------------------------7db2d1bcc50e6e--
     *
     * support multi file upload in one request, just keep "resId, resName,
     * fileData with Content-Type setted" three in order.
     *
     * @return
     */
    @POST
    @Produces("application/json")
    public String postResource() {
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
                    logger.log(Level.INFO, "Header Key: " + e + " Value: " + request.getHeader(e));
                }
            }
            
            if(items != null){
                
                for (DiskFileItem item : items) {
                    
                    try {
                        saveResult = this.saveResource(item.getFieldName(), item.getName(), item.getContentType(), item.getInputStream());
                    } catch (IOException ex) {
                        logger.log(Level.SEVERE, null, ex);
                    }
                }
                
                
            }

//            if (items != null && items.size() % 3 == 0) {
//                for (int index = 0; index < (items.size() / 3); index++) {
//                    try {
//                        saveResult = this.saveResource(items.get(index).getString(), items.get(index + 1).getString(), items.get(index + 2).getContentType(), items.get(index + 2).getInputStream());
//                    } catch (IOException ex) {
//                        logger.log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
        } catch (FileUploadException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return saveResult ? "true" : "false";
    }

    private boolean saveResource(String resId, String resName, String contentType, InputStream is) {
        
        if (logger.isLoggable(Level.FINE) || true) {
            logger.log(Level.INFO, "--Resource Uploaded--");
            logger.log(Level.INFO, "resId: {0}", resId);
            logger.log(Level.INFO, "resName: {0}", resName);
            logger.log(Level.INFO, "contentType: {0}", contentType);
            logger.log(Level.INFO, "--------------------");
        }

        if (resId == null || resId.trim().equals("")
                || resName == null || resName.trim().equals("")
                || contentType == null || contentType.trim().equals("")) {
            return false;
        }

        try {
            File outputFile = new File(this.basePath + resId);
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

        DroidOqcResource resource = new DroidOqcResource(resId,resName,"0",(new Date()).toString());
        resource.setContentType("image/jpeg");
        resource.setLastUpdatedBy("0");
        resource.setLastUpdatedDate((new Date()).toString());
        resourcesFacade.create(resource);

        return true;
    }
    
}
