/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcDocumentHeader;
import com.leedarson.entities.oqc.HeaderSoNumber;
import static com.leedarson.entities.util.EntityUtil.objectToBigInteger;
import static com.leedarson.entities.util.EntityUtil.objectToDate;
import static com.leedarson.entities.util.EntityUtil.objectToString;
import com.leedarson.facades.pqc.AbstractFacade;
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
public class DroidOqcDocumentHeaderFacade extends AbstractFacade<DroidOqcDocumentHeader> implements DroidOqcDocumentHeaderFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidOqcDocumentHeaderFacade() {
        super(DroidOqcDocumentHeader.class);
    }
    
    /**
     * 获取最后一次添加的检验批号
     * @return 
     */
    @Override
    public String getLastDocumentNum() {
        String result = "";
        String sql = "select max(t.DOCUMENT_NUMBER) from DROID_OQC_DOCUMENT_HEADER t";
        javax.persistence.Query query = em.createNativeQuery(sql);
        Object obj = query.getSingleResult();
        if(obj != null)
            result = obj.toString();
        return result;
    }

    @Override
    public List<HeaderSoNumber> getSoNumbers(String innerPoNumber) {
        
        List<HeaderSoNumber> result = new ArrayList<HeaderSoNumber>();
        
        String sql = "select distinct lpv.CUSTOMER_NAME_ALT,\n" +
                    "       lpv.SO_NUMBER, \n" +
                    "       lpv.SO_LINE_NUM \n" +
                    "   from ldx_sap_inner_po_v lpv\n" +
                    "   where 1 = 1\n" +
                    "       and lpv.INNER_PO_NUMBER = ?";

        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, innerPoNumber);
        
        List<Object[]> temp = query.getResultList();
        
            if(temp != null && temp.size() >0){
                
                HeaderSoNumber headerSoNumber = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    headerSoNumber = new HeaderSoNumber();
                    headerSoNumber.setCustomerNameAlt(objectToString(fields[0]));
                    headerSoNumber.setSoNumber(objectToString(fields[1]));
                    headerSoNumber.setSoNumberLine(objectToString(fields[2]));
                    result.add(headerSoNumber);
                }
                
            }
        
        return result;
    }

    @Override
    public List<DroidOqcDocumentHeader> getHomeList(String documentStatus, String documentNumber, String resultCode, String outboundNumber, String soNumber, String cabinetNumber, String lockNumber, String customer, String inspector, String fromDate, String toDate) {
        
        List<DroidOqcDocumentHeader> result = new ArrayList<DroidOqcDocumentHeader>();
        
        String sql = "SELECT * \n" +
                "FROM DROID_OQC_DOCUMENT_HEADER dodh\n" +
                "WHERE dodh.RESULT_CODE = '"+resultCode+"'\n" +
                "       AND dodh.DOCUMENT_STATUS = '"+documentStatus+"'\n" +
                "       AND dodh.INSPECTOR = '"+inspector+"'\n" +
                "	AND dodh.INSPECTION_DATE BETWEEN to_date('"+fromDate+"', 'yyyy-mm-dd hh24:mi:ss') AND \n" +
                "		to_date('"+toDate+"', 'yyyy-mm-dd hh24:mi:ss')";
        if(documentNumber != null && !documentNumber.isEmpty())
            sql += "    AND dodh.DOCUMENT_NUMBER LIKE '%"+documentNumber+"%'\n";
        if(outboundNumber != null && !outboundNumber.isEmpty())
            sql += "	AND dodh.OUTBOUND_DELIVERY_NUMBER LIKE '%"+outboundNumber+"%'\n";
        if(soNumber != null && !soNumber.isEmpty())
            sql += "	AND dodh.ATTR2 LIKE '%"+soNumber+"%'\n" ;//销售订单号
        if(cabinetNumber != null && !cabinetNumber.isEmpty())
            sql += "	AND dodh.CABINET_NUMBER = '"+cabinetNumber+"'\n" ;
        if(lockNumber != null && !lockNumber.isEmpty())
            sql += "	AND dodh.LOCK_NUMBER = '"+lockNumber+"'\n" ;
        if(customer != null && !customer.isEmpty())
            sql += "	AND dodh.ATTR1 LIKE '%"+customer+"%'\n"; //客户
//        if(inspector != null && !inspector.isEmpty())
//            sql += "	AND dodh.INSPECTOR LIKE '%"+inspector+"%'\n" ;
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        
        List<Object[]> temp = query.getResultList();
        
        if(temp != null && temp.size() >0){
                
                DroidOqcDocumentHeader docHeader = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    docHeader = new DroidOqcDocumentHeader();
                    docHeader.setDocumentHeaderId(objectToString(fields[0]));
                    docHeader.setDocumentNumber(objectToString(fields[1]));
                    docHeader.setDocumentType(objectToString(fields[2]));
                    docHeader.setDocumentStatus(objectToString(fields[3]));
                    docHeader.setInspectionDate(objectToDate(fields[4]));
                    docHeader.setOutboundDeliveryNumber(objectToString(fields[5]));
                    docHeader.setCabinetNumber(objectToString(fields[6]));
                    docHeader.setLockNumber(objectToString(fields[7]));
                    docHeader.setActualShipment(objectToBigInteger(fields[8]));
                    docHeader.setResultCode(objectToString(fields[9]));
                    docHeader.setInspectionException(objectToString(fields[10]));
                    docHeader.setInspector(objectToString(fields[11]));
                    docHeader.setAttr1(objectToString(fields[12]));
                    docHeader.setAttr2(objectToString(fields[13]));
                    docHeader.setAttr3(objectToString(fields[14]));
                    docHeader.setAttr4(objectToString(fields[15]));
                    docHeader.setAttr5(objectToString(fields[16]));
                    docHeader.setCreatedBy(objectToBigInteger(fields[17]));
                    docHeader.setCreationDate(objectToDate(fields[18]));
                    docHeader.setLastUpdatedBy(objectToBigInteger(fields[19]));
                    docHeader.setLastUpdateDate(objectToDate(fields[20]));
                    docHeader.setLastUpdateLogin(objectToBigInteger(fields[21]));
                    
                    result.add(docHeader);
                }
                
            }
        
        return result;
    }
    
    
}
