/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidDocumentHeader;
import com.leedarson.entities.pqc.HomeListInfo;
import static com.leedarson.entities.util.EntityUtil.objectToString;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class DroidDocumentHeaderFacade extends AbstractFacade<DroidDocumentHeader> implements DroidDocumentHeaderFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidDocumentHeaderFacade() {
        super(DroidDocumentHeader.class);
    }

    /**
     * 获取最后一次添加的检验批号
     * @return 
     */
    @Override
    public String getLastDocumentNum() {
        String result = "";
        String sql = "select ddh.DOCUMENT_NUMBER from DROID_DOCUMENT_HEADER ddh where ddh.DOCUMENT_HEADER_ID = (select max(t.DOCUMENT_HEADER_ID) from DROID_DOCUMENT_HEADER t)";
        javax.persistence.Query query = em.createNativeQuery(sql);
        Object obj = query.getSingleResult();
        if(obj != null)
            result = obj.toString();
        return result;
    }

    @Override
    public Object getHeaderIdbyDocumentNum(String documentNum) {
        
        Object result = null;
        
        String sql = "select t.DOCUMENT_HEADER_ID from droid_document_header t where t.DOCUMENT_NUMBER = ?";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNum);
        Object obj = query.getSingleResult();
        result = obj;
        
        return result;
    
    }

    @Override
    public Object isExitAlready(String documentNum) {
        
       Object result = null;
       
       String sql = "select t.DOCUMENT_HEADER_ID from DROID_DOCUMENT_HEADER t where t.DOCUMENT_NUMBER = ?";
       javax.persistence.Query query = em.createNativeQuery(sql);
       query.setParameter(1, documentNum);
       try{
            Object obj = query.getSingleResult();
            result = obj;
       }catch(Exception e){
            result = null;
       }
       
       
       return result;
    }

    @Override
    public List<HomeListInfo> getHomeList(String documentStatus, String poNumber, String productionLine, String customer, String fromDate, String toDate,
                                        String workOrderNum, String plantId) {
        
        
        List<HomeListInfo> result = new ArrayList<HomeListInfo>();
        
        String sql = "SELECT DISTINCT ddh.document_header_id,\n" +
                    "       ddh.document_number,\n" +
                    "       v.lookup_code type_code,\n" +
                    "       v.meaning doc_type,\n" +
                    "       hwo.work_order_num,\n" +
                    "       lmo.po_number,\n" +
                    "       lmo.so_number,\n" +
                    "       lmo.customer,\n" +
                    "       hpl.production_line_alt,\n" +
                    "       '' iqc,\n" +
                    "       ddh.creation_date,\n" +
                    "       hiv.LONG_DESCRIPTIONS,\n" +
                    "       nvl(ddh.prod_line_id, hwo.prod_line_id) prod_line_id,\n" +
                    "       nvl(ddh.PROD_LINE_GROUP_ID, hpl.PROD_LINE_GROUP_ID) PROD_LINE_GROUP_ID,\n"+
                    "       ddh.SHIFT_CODE"+
                    "  FROM droid_document_header ddh,\n" +
                    "       hfwk_lookup_types_v   v,\n" +
                    "       hme_work_order_b      hwo,\n" +
                    "       ldx_mo_wo_ref         lmr,\n" +
                    "       ldx_make_order        lmo,\n" +
                    "       hcm_production_line   hpl,\n" +
                    "       hcm_item_v            hiv\n"+
                    "WHERE 1 = 1\n" +
                    "   AND v.lookup_type_code = 'DROID_DOCUMENT_TYPE'\n" +
                    "   AND v.lookup_code = ddh.document_type\n" +
                    "   AND ddh.work_order_id = hwo.work_order_num\n" +
                    "   AND hwo.work_order_id = lmr.work_order_id\n" +
                    "   AND lmr.make_order_id = lmo.make_order_id\n" +
                    "   AND nvl(ddh.prod_line_id, hwo.prod_line_id) = hpl.prod_line_id\n" +
                    "   AND hiv.item_id = lmo.item_id\n"+
                    "   AND hiv.PLANT_ID = hwo.PLANT_ID\n"+
                    "   AND ddh.document_status = ? \n" +
                    "   AND ddh.creation_date BETWEEN to_date('"+fromDate+"', 'yyyy-mm-dd hh24:mi:ss') AND\n" +
                    "       to_date('"+toDate+"', 'yyyy-mm-dd hh24:mi:ss')\n"+
                    "   AND hwo.WORK_ORDER_NUM in (select hwo.WORK_ORDER_NUM from hme_work_order_b hwo where hwo.PLANT_ID = ?)\n";
        
        if(poNumber != null && !poNumber.isEmpty()) {
            sql += "   AND lmo.po_number LIKE '%"+poNumber+"%'\n" ;
        }
        if(productionLine != null && !productionLine.isEmpty()) {
            sql += "   AND (hpl.production_line_alt LIKE '%"+productionLine+"%' OR hpl.descriptions LIKE '%"+productionLine+"%')\n";
        }
        if(customer != null && !customer.isEmpty()) {
            sql += "   AND lmo.customer LIKE '%"+customer+"%'\n";
        }
        if(workOrderNum != null && !workOrderNum.isEmpty()){
            sql += "    AND hwo.WORK_ORDER_NUM = "+workOrderNum;
        }
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentStatus);
        query.setParameter(2, plantId);
        
            List<Object[]> temp = query.getResultList();
//            System.out.println("temp : " + temp.get(0).toString());
            if(temp != null && temp.size() >0){
                
                HomeListInfo homeListInfo = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    homeListInfo = new HomeListInfo();
                    homeListInfo.setDocumentHeaderId(objectToString(fields[0]));
                    homeListInfo.setDocumentNum(objectToString(fields[1]));
                    homeListInfo.setTypeCode(objectToString(fields[2]));
                    homeListInfo.setDocType(objectToString(fields[3]));
                    homeListInfo.setWorkOrderNum(objectToString(fields[4]));
                    homeListInfo.setPoNumber(objectToString(fields[5]));
                    homeListInfo.setSoNumber(objectToString(fields[6]));
                    homeListInfo.setCustomer(objectToString(fields[7]));
                    homeListInfo.setProdLineCode(objectToString(fields[8]));
                    homeListInfo.setIqc(objectToString(fields[9]));
                    homeListInfo.setCreationDate(objectToString(fields[10]));
                    homeListInfo.setLongDescriptions(objectToString(fields[11]));
                    homeListInfo.setProdLineId(objectToString(fields[12]));
                    homeListInfo.setProdLineGroupId(objectToString(fields[13]));
                    homeListInfo.setShiftCode(objectToString(fields[14]));
                    result.add(homeListInfo);
                }
                
            }
        
        
        return result;
    
    
    
    }
    
    

    @Override
    public String newRecord(DroidDocumentHeader docHeader) {
        
    
        String result = "";
        
        
        return result;
    
    }
    
    
    
    
    
}
