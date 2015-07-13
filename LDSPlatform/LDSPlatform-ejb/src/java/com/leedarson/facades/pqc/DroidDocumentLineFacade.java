/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidDocumentLine;
import com.leedarson.entities.pqc.ResultLine;
import static com.leedarson.entities.util.EntityUtil.objectToBigDecimal;
import static com.leedarson.entities.util.EntityUtil.objectToBigInteger;
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
public class DroidDocumentLineFacade extends AbstractFacade<DroidDocumentLine> implements DroidDocumentLineFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidDocumentLineFacade() {
        super(DroidDocumentLine.class);
    }

    @Override
    public List<DroidDocumentLine> getResultOfLine(String docHeaderId, int level1, int level2, int level3) {
        
    
        List<DroidDocumentLine> result = new ArrayList<DroidDocumentLine>();
        
        String sql = "select t.DOCUMENT_LINE_ID,t.OPTION_ID,t.RESULT_CODE,t.RESULT_TEXT from DROID_DOCUMENT_LINE t where t.DOCUMENT_HEADER_ID=? and t.LEVEL_1=? and t.LEVEL_2=? and t.LEVEL_3=?";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, docHeaderId);
        query.setParameter(2, level1);
        query.setParameter(3, level2);
        query.setParameter(4, level3);
        
        
            List<Object[]> temp = query.getResultList();
//            System.out.println("temp : " + temp.get(0).toString());
            if(temp != null && temp.size() >0){
                
                DroidDocumentLine documentLine;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    documentLine = new DroidDocumentLine();
                    documentLine.setDocumentLineId(objectToBigDecimal(fields[0]));
                    documentLine.setOptionId(objectToBigInteger(fields[1]));
                    documentLine.setResultCode(objectToString(fields[2]));
                    documentLine.setResultText(objectToString(fields[3]));
                    
                    
                    result.add(documentLine);
                }
                
            }
            return result;
        
        
    }

    @Override
    public List<DroidDocumentLine> getResultBydocumentNumber(String documentNumber) {
        
        List<DroidDocumentLine> result = new ArrayList<DroidDocumentLine>();
        
        String sql = "select * from DROID_DOCUMENT_LINE t\n" +
                " where t.DOCUMENT_HEADER_ID = \n" +
                " (select ddh.DOCUMENT_HEADER_ID from DROID_DOCUMENT_HEADER ddh where ddh.DOCUMENT_NUMBER = ?)";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNumber);
        
        result = query.getResultList();
        
        return result;
    
    }

    @Override
    public List<ResultLine> getResultList(String documentNumber) {
       
        String subsql = "select t.DOCUMENT_HEADER_ID from droid_document_header t where t.DOCUMENT_NUMBER = ? ";
        javax.persistence.Query subquery = em.createNativeQuery(subsql);
        subquery.setParameter(1, documentNumber);
        Object documentHeaderId = subquery.getSingleResult();
        
        List<ResultLine> result = new ArrayList<ResultLine>();
        
        String sql = "SELECT ddh.document_header_id,\n" +
                    "       ddh.document_number,\n" +
                    "       ddh.document_type,\n" +
                    "       ddh.work_order_id,\n" +
                    "       dhl.document_line_id,\n" +
                    "       dqb.QUESTION_ID,\n" +
                    "       dqb.level_1,\n" +
                    "       dqb.level_2,\n" +
                    "       dqb.level_3,\n" +
                    "       dqb.question_text,\n" +
                    "       dqb.operation_seq,\n" +
                    "       dqb.is_key,\n" +
                    "       dqo.OPTION_ID,\n" +
                    "       dqo.option_text,\n" +
                    "       dhl.RESULT_TEXT,\n" +
                    "       dhl.RESULT_CODE\n" +
                    "FROM droid_document_header  ddh,\n" +
                    "       droid_document_line    dhl,\n" +
                    "       droid_question_bank    dqb,\n" +
                    "       droid_question_options dqo\n" +
                    "WHERE ddh.document_number = ? \n" +
                    "   AND dqb.question_type = ddh.document_type\n" +
                    "   AND dhl.level_1(+) = dqb.level_1\n" +
                    "   AND dhl.level_2(+) = dqb.level_2\n" +
                    "   AND dhl.level_3(+) = dqb.level_3\n" +
                    "   AND dhl.option_id = dqo.option_id(+)\n" +
                    "   AND dhl.document_header_id(+) = "+objectToBigDecimal(documentHeaderId)+"\n" +
                    "ORDER BY dqb.level_1, dqb.level_2, dqb.level_3";
        
//        String sql = "select v.DOCUMENT_LINE_ID,v.LEVEL_1,v.LEVEL_2,v.LEVEL_3,v.OPTION_ID, dqo.OPTION_TEXT, v.RESULT_CODE, v.RESULT_TEXT from (\n" +
//                "select t.DOCUMENT_LINE_ID,t.LEVEL_1,t.LEVEL_2,t.LEVEL_3,t.OPTION_ID,t.RESULT_CODE,t.RESULT_TEXT from DROID_DOCUMENT_LINE t\n" +
//                "where t.DOCUMENT_HEADER_ID=(select ddh.DOCUMENT_HEADER_ID from DROID_DOCUMENT_HEADER ddh where ddh.DOCUMENT_NUMBER = ?) \n" +
//                "and t.LEVEL_1=? and t.LEVEL_2=? and t.LEVEL_3=?\n" +
//                ") v , DROID_QUESTION_OPTIONS dqo where dqo.OPTION_ID(+) = v.OPTION_ID";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNumber);
        
        
        List<Object[]> temp = query.getResultList();
        
        if(temp != null && temp.size() >0){
                
                ResultLine resultLine;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    resultLine = new ResultLine();
                    resultLine.setDocumentHeaderId(objectToBigDecimal(fields[0]));
                    resultLine.setDocumentNumber(objectToString(fields[1]));
                    resultLine.setDocumentType(objectToString(fields[2]));
                    resultLine.setWorkOrderId(objectToString(fields[3]));
                    resultLine.setDocumentLineId(objectToBigDecimal(fields[4]));
                    resultLine.setQuestionId(objectToBigDecimal(fields[5]));
                    resultLine.setLevel1(objectToBigInteger(fields[6]));
                    resultLine.setLevel2(objectToBigInteger(fields[7]));
                    resultLine.setLevel3(objectToBigInteger(fields[8]));
                    resultLine.setQuestionText(objectToString(fields[9]));
                    resultLine.setOperationSeq(objectToString(fields[10]));
                    resultLine.setIsKey(objectToString(fields[11]));
                    resultLine.setOptionId(objectToBigInteger(fields[12]));
                    resultLine.setOptionText(objectToString(fields[13]));
                    resultLine.setResultText(objectToString(fields[14]));
                    resultLine.setResultCode(objectToString(fields[15]));
                    
                    
                    result.add(resultLine);
                }
                
            }
            return result;
        
        
    }
    
    
}
