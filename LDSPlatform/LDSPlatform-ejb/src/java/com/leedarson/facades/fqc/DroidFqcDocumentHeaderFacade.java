/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DroidFqcDocumentHeader;
import com.leedarson.entities.oqc.FqcHeader;
import com.leedarson.entities.pqc.HomeListInfo;
import static com.leedarson.entities.util.EntityUtil.objectToDate;
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
public class DroidFqcDocumentHeaderFacade extends AbstractFacade<DroidFqcDocumentHeader> implements DroidFqcDocumentHeaderFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidFqcDocumentHeaderFacade() {
        super(DroidFqcDocumentHeader.class);
    }

    /**
     * 获取最后一次添加的检验批号
     * @return 
     */
    @Override
    public String getLastDocumentNum() {
        String result = "";
        String sql = "select max(t.DOCUMENT_NUMBER) from DROID_FQC_DOCUMENT_HEADER t";
        javax.persistence.Query query = em.createNativeQuery(sql);
        Object obj = query.getSingleResult();
        if(obj != null)
            result = obj.toString();
        return result;
    }
    
    @Override
    public List<HomeListInfo> getHomeList(String documentStatus, String poNumber, String productionLine, String customer, String fromDate, String toDate,
                                        String workOrderNum, String plantId) {
        
        
        List<HomeListInfo> result = new ArrayList<HomeListInfo>();
        
//        String sql = "SELECT DISTINCT ddh.document_header_id,\n" +
//                    "       ddh.document_number,\n" +
//                    "       v.lookup_code type_code,\n" +
//                    "       v.meaning doc_type,\n" +
//                    "       hwo.work_order_num,\n" +
//                    "       lmo.po_number,\n" +
//                    "       lmo.so_number,\n" +
//                    "       lmo.customer,\n" +
//                    "       hpl.production_line_alt,\n" +
//                    "       '' iqc,\n" +
//                    "       ddh.creation_date,\n" +
//                    "       hiv.LONG_DESCRIPTIONS,\n" +
//                    "       nvl(ddh.prod_line_id, hwo.prod_line_id) prod_line_id,\n" +
//                    "       nvl(ddh.PROD_LINE_GROUP_ID, hpl.PROD_LINE_GROUP_ID) PROD_LINE_GROUP_ID,\n"+
//                    "       ddh.SHIFT_CODE"+
//                    "  FROM droid_fqc_document_header ddh,\n" +
//                    "       hfwk_lookup_types_v   v,\n" +
//                    "       hme_work_order_b      hwo,\n" +
//                    "       ldx_mo_wo_ref         lmr,\n" +
//                    "       ldx_make_order        lmo,\n" +
//                    "       hcm_production_line   hpl,\n" +
//                    "       hcm_item_v            hiv\n"+
//                    "WHERE 1 = 1\n" +
//                    "   AND v.lookup_type_code = 'DROID_DOCUMENT_TYPE'\n" +
//                    "   AND v.lookup_code = ddh.document_type\n" +
//                    "   AND ddh.WORK_ORDER_NUMBER = hwo.work_order_num\n" +
//                    "   AND hwo.work_order_id = lmr.work_order_id\n" +
//                    "   AND lmr.make_order_id = lmo.make_order_id\n" +
//                    "   AND nvl(ddh.prod_line_id, hwo.prod_line_id) = hpl.prod_line_id\n" +
//                    "   AND hiv.item_id = lmo.item_id\n"+
//                    "   AND ddh.document_status = ? \n" +
//                    "   AND ddh.creation_date BETWEEN to_date('"+fromDate+"', 'yyyy-mm-dd hh24:mi:ss') AND\n" +
//                    "       to_date('"+toDate+"', 'yyyy-mm-dd hh24:mi:ss')\n"+
//                    "   AND hwo.WORK_ORDER_NUM in (select hwo.WORK_ORDER_NUM from hme_work_order_b hwo where hwo.PLANT_ID = ?)";
//        
        String sql = "SELECT DISTINCT ddh.document_header_id, \n" +
"               ddh.document_number, \n" +
"               v.lookup_code type_code, \n" +
"               v.meaning doc_type, \n" +
"               hwo.work_order_num, \n" +
"               lmo.po_number, \n" +
"               lmo.so_number, \n" +
"               lmo.customer, \n" +
"               ddh.PROD_LINE_ID_DES,\n" +
"               hiv.LONG_DESCRIPTIONS, \n" +
"               ddh.SHIFT_CODE,\n" +
"               ddh.INSPECTION_AMOUNT,\n" +
"               ddh.SAMPLING_AMOUNT,\n" +
"               ddh.RESULT_CODE,\n" +
"               ddh.INSPECTOR,\n" +
"               ddh.creation_date,\n" +
"               ddh.PROD_LINE_GROUP_DES\n" +
"          FROM droid_fqc_document_header ddh, \n" +
"               hfwk_lookup_types_v   v, \n" +
"               hme_work_order_b      hwo, \n" +
"               ldx_mo_wo_ref         lmr, \n" +
"               ldx_make_order        lmo, \n" +
"               hcm_item_v            hiv\n" +
"        WHERE 1 = 1 \n" +
"           AND v.lookup_type_code = 'DROID_DOCUMENT_TYPE' \n" +
"           AND v.lookup_code = ddh.document_type \n" +
"           AND ddh.WORK_ORDER_NUMBER = hwo.work_order_num \n" +
"           AND hwo.work_order_id = lmr.work_order_id \n" +
"           AND lmr.make_order_id = lmo.make_order_id\n" +
"           AND hiv.item_id = lmo.item_id\n" +
"           AND ddh.document_status = ?  \n" +
"           AND ddh.creation_date BETWEEN to_date('"+fromDate+"', 'yyyy-mm-dd hh24:mi:ss') AND \n" +
"               to_date('"+toDate+"', 'yyyy-mm-dd hh24:mi:ss')\n" +
"           AND hwo.WORK_ORDER_NUM in (select hwo.WORK_ORDER_NUM from hme_work_order_b hwo where hwo.PLANT_ID = ?)";
        if(poNumber != null && !poNumber.isEmpty()) {
            sql += "   AND lmo.po_number LIKE '%"+poNumber+"%'" ;
        }
        if(productionLine != null && !productionLine.isEmpty()) {
            sql += "   AND (ddh.PROD_LINE_ID_DES LIKE '%"+productionLine+"%')";
        }
        if(customer != null && !customer.isEmpty()) {
            sql += "   AND lmo.customer LIKE '%"+customer+"%'";
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
                    homeListInfo.setLongDescriptions(objectToString(fields[9]));
                    homeListInfo.setShiftCode(objectToString(fields[10]));
                    homeListInfo.setInspectAmount(objectToString(fields[11]));
                    homeListInfo.setSamplingAmount(objectToString(fields[12]));
                    homeListInfo.setResultCode(objectToString(fields[13]));
                    homeListInfo.setIqc(objectToString(fields[14]));
                    homeListInfo.setCreationDate(objectToString(fields[15]));
                    homeListInfo.setProLineGroupCode(objectToString(fields[16]));
                    
                    result.add(homeListInfo);
                }
                
            }
        
        
        return result;
    
    
    
    }

    @Override
    public List<FqcHeader> getFqcList(String plantId, String status, String customer, String itemCode, String workOrderNum, String fromDate, String toDate) {
        
        List<FqcHeader> result = new ArrayList<FqcHeader>();
        
        String sql = "select\n" +
        "	hiv.ITEM_CODE,\n" +
        "	lmo.PLANT_CODE,\n" +
        "	lmo.CUSTOMER ,\n" +
        "	lmo.PO_NUMBER ,\n" +
        "	lmo.SO_NUMBER ,\n" +
        "	hiv.DESCRIPTIONS,\n" +
        "	hiv.LONG_DESCRIPTIONS,\n" +
        "	dfdh.* \n" +
        "from \n" +
        "	DROID_FQC_DOCUMENT_HEADER	dfdh,\n" +
        "	LDX_MAKE_ORDER        		lmo,\n" +
        "	HME_WORK_ORDER_B      		hwo,\n" +
        "	LDX_MO_WO_REF 			lmr,\n" +
        "	HCM_ITEM_V			hiv\n" +
        "where 1=1\n" +
        "	and dfdh.WORK_ORDER_NUMBER = hwo.WORK_ORDER_NUM\n" +
        "	and lmo.MAKE_ORDER_ID = lmr.MAKE_ORDER_ID\n" +
        "	and lmr.WORK_ORDER_ID = hwo.WORK_ORDER_ID\n" +
        "	and hiv.ITEM_ID = lmo.ITEM_ID\n" +
        "	and hiv.PLANT_CODE = lmo.PLANT_CODE\n" +
        "	and dfdh.DOCUMENT_STATUS = ? --status\n" +
        "	and dfdh.WORK_ORDER_NUMBER in (select hwo.WORK_ORDER_NUM from hme_work_order_b hwo where hwo.PLANT_ID = ?) --factory\n" +
        "	and dfdh.CREATION_DATE between to_date('"+fromDate+"','yyyy-mm-dd hh24:mi:ss') and to_date('"+toDate+"','yyyy-mm-dd hh24:mi:ss')  --time";
    
        if(itemCode != null && !itemCode.isEmpty()) {
            sql += "   AND lmo.hiv.ITEM_CODE = "+itemCode ;
        }
        if(customer != null && !customer.isEmpty()) {
            sql += "   AND lmo.customer LIKE '%"+customer+"%'";
        }
        if(workOrderNum != null && !workOrderNum.isEmpty()){
            sql += "    AND dfdh.WORK_ORDER_NUMBER = "+workOrderNum;
        }
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, status);
        query.setParameter(2, plantId);
        
         List<Object[]> temp = query.getResultList();
//            System.out.println("temp : " +temp);
            if(temp != null && temp.size() >0){
                
                FqcHeader fqcHeader = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    fqcHeader = new FqcHeader();
                    fqcHeader.setItemCode(objectToString(fields[0]));
                    fqcHeader.setPlantCode(objectToString(fields[1]));
                    fqcHeader.setCustomer(objectToString(fields[2]));
                    fqcHeader.setPoNumber(objectToString(fields[3]));
                    fqcHeader.setSoNumber(objectToString(fields[4]));
                    fqcHeader.setDescription(objectToString(fields[5]));
                    fqcHeader.setLongDescription(objectToString(fields[6]));
                    fqcHeader.setDocumentHeaderId(objectToString(fields[7]));
                    fqcHeader.setDocumentNumber(objectToString(fields[8]));
                    fqcHeader.setCategory(objectToString(fields[9]));
                    fqcHeader.setDocumentType(objectToString(fields[10]));
                    fqcHeader.setDocumentStatus(objectToString(fields[11]));
                    fqcHeader.setWorkOrderNumber(objectToString(fields[12]));
                    fqcHeader.setProdLineGroupDes(objectToString(fields[13]));
                    fqcHeader.setProdLineIdDes(objectToString(fields[14]));
                    fqcHeader.setInspectionAmount(objectToString(fields[15]));
                    fqcHeader.setSamplingAmount(objectToString(fields[16]));
                    fqcHeader.setInspector(objectToString(fields[18]));
                    fqcHeader.setResultCode(objectToString(fields[19]));
                    fqcHeader.setCreationDate(objectToDate(fields[26]));
                    
                    result.add(fqcHeader);
                }
                
            }
        
        return result;
    }
    
    
    
    
}
