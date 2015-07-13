/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DroidFqcBugLine;
import com.leedarson.entities.fqc.BugResultLine;
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
public class DroidFqcBugLineFacade extends AbstractFacade<DroidFqcBugLine> implements DroidFqcBugLineFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidFqcBugLineFacade() {
        super(DroidFqcBugLine.class);
    }

    @Override
    public List<BugResultLine> getResultList(String documentNumber, String bugLevel) {
        
        String sql = "select dfbh.BUG_LEVEL,\n" +
                "	dfbh.SAMPLING_STANDARD,\n" +
                "	dfbh.ACCPECT_VALUE,\n" +
                "	dfbh.REJECT_VALUE,\n" +
                "	dfbh.RESULT_CODE,\n" +
                "	dfbh.BUGS_AMOUNT,\n" +
                "	v1.CODEGRUPPE,\n" +
                "	v1.CODE,\n" +
                "	v1.FEHLKLASSE,\n" +
                "	v2.KURZTEXT,\n" +
                "       dfbl.BUG_COUNT,\n"+
                "	dfbl.DOCUMENT_BUG_LINE_ID,\n" +
                "	dfbl.DOCUMENT_BUG_HEADER_ID\n" +
                "from QPCD v1,\n" +
                "	QPCT v2,\n" +
                "	DROID_FQC_DOCUMENT_HEADER dfdh,\n" +
                "	DROID_FQC_BUG_HEADER dfbh,\n" +
                "	DROID_FQC_BUG_LINE dfbl\n" +
                "where 1 = 1\n" +
                "and v1.CODE = v2.CODE\n" +
                "and v1.CODEGRUPPE = v2.CODEGRUPPE\n" +
                "and v1.MANDT = v2.MANDT\n" +
                "and dfbl.BUG_CODEGRUPPE = v1.CODEGRUPPE\n" +
                "and dfbl.BUG_CODEGRUPPE = v2.CODEGRUPPE\n" +
                "and dfbl.BUG_CODE = v1.CODE\n" +
                "and dfbl.BUG_CODE = v2.CODE\n" +
                "and dfdh.DOCUMENT_HEADER_ID = dfbh.DOCUMENT_HEADER_ID\n" +
                "and dfbh.DOCUMENT_BUG_HEADER_ID = dfbl.DOCUMENT_BUG_HEADER_ID\n" +
                "and v2.MANDT = '600'\n" +
                "and dfdh.DOCUMENT_NUMBER = ?\n" +
                "and dfbh.BUG_LEVEL = ?\n" +
                "and dfbl.ATTR1 = 'VALID'";
        
        String sql2 = "select dfbh.BUG_LEVEL,\n" +
                "	dfbh.SAMPLING_STANDARD,\n" +
                "	dfbh.ACCPECT_VALUE,\n" +
                "	dfbh.REJECT_VALUE,\n" +
                "	dfbh.RESULT_CODE,\n" +
                "	dfbh.BUGS_AMOUNT\n" +
                "from DROID_FQC_DOCUMENT_HEADER dfdh,\n" +
                "	DROID_FQC_BUG_HEADER dfbh\n" +
                "where 1 = 1\n" +
                "and dfdh.DOCUMENT_HEADER_ID = dfbh.DOCUMENT_HEADER_ID\n" +
                "and dfdh.DOCUMENT_NUMBER = ?\n" +
                "and dfbh.BUG_LEVEL = ?";
        
        List<BugResultLine> result = new ArrayList<BugResultLine>();
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNumber);
        query.setParameter(2, bugLevel);
        
        List<Object[]> temp = query.getResultList();
        
        if(temp != null && temp.size() >0){
                
                BugResultLine resultLine;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    resultLine = new BugResultLine();
                    resultLine.setBugLevel(objectToString(fields[0]));
                    resultLine.setStandard(objectToString(fields[1]));
                    resultLine.setAccpect(objectToString(fields[2]));
                    resultLine.setReject(objectToString(fields[3]));
                    resultLine.setResult(objectToString(fields[4]));
                    resultLine.setAmount(objectToString(fields[5]));
                    resultLine.setGroup(objectToString(fields[6]));
                    resultLine.setCode(objectToString(fields[7]));
                    resultLine.setFehlklasse(objectToString(fields[8]));
                    resultLine.setText(objectToString(fields[9]));
                    resultLine.setBugCount(objectToString(fields[10]));
                    resultLine.setBugLineId(objectToString(fields[11]));
                    resultLine.setBugHeaderId(objectToString(fields[12]));
                    
                    result.add(resultLine);
                }
                
            }else{
//                javax.persistence.Query query2 = em.createNativeQuery(sql2);
//                query2.setParameter(1, documentNumber);
//                query2.setParameter(2, bugLevel);
//
//                List<Object[]> temp2 = query2.getResultList();
//
//                if(temp2 != null && temp2.size() >0){
//
//                    ResultLine resultLine;
//
//                    for (int i=0;i<temp2.size();i++){
//                        Object[] fields = temp2.get(i);
//                        resultLine = new ResultLine();
//                        resultLine.setBugLevel(objectToString(fields[0]));
//                        resultLine.setStandard(objectToString(fields[1]));
//                        resultLine.setAccpect(objectToString(fields[2]));
//                        resultLine.setReject(objectToString(fields[3]));
////                        resultLine.setResult(objectToString(fields[4]));
//                        resultLine.setBugCount(objectToString(fields[4]));
//
//                        result.add(resultLine);
//                    }
//
//                }
            
        }
            return result;
    }
    
    
    
}
