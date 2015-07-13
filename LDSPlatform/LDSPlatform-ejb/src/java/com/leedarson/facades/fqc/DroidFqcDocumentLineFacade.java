/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DocResultLine;
import com.leedarson.entities.fqc.DroidFqcDocumentLine;
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
public class DroidFqcDocumentLineFacade extends AbstractFacade<DroidFqcDocumentLine> implements DroidFqcDocumentLineFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidFqcDocumentLineFacade() {
        super(DroidFqcDocumentLine.class);
    }

    @Override
    public List<DocResultLine> getResultList(String documentNumber) {
        
        String subsql = "select dfdh.DOCUMENT_HEADER_ID from DROID_FQC_DOCUMENT_HEADER dfdh where dfdh.DOCUMENT_NUMBER =? ";
        javax.persistence.Query subquery = em.createNativeQuery(subsql);
        subquery.setParameter(1, documentNumber);
        Object documentHeaderId = subquery.getSingleResult();
        
        List<DocResultLine> result = new ArrayList<DocResultLine>();
        
        String sql = "SELECT ddh.document_header_id,\n" +
                    "       ddh.document_number,\n" +
                    "       ddh.document_type,\n" +
                    "       ddh.work_order_number,\n" +
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
                    "FROM droid_fqc_document_header  ddh,\n" +
                    "       droid_fqc_document_line    dhl,\n" +
                    "       droid_question_bank    dqb,\n" +
                    "       droid_question_options dqo\n" +
                    "WHERE ddh.document_number = ? \n" +
                    "   AND dqb.question_type = ddh.document_type\n" +
                    "   AND dhl.level_1(+) = dqb.level_1\n" +
                    "   AND dhl.level_2(+) = dqb.level_2\n" +
                    "   AND dhl.level_3(+) = dqb.level_3\n" +
                    "   AND dhl.option_id = dqo.option_id(+)\n" +
                    "   AND dhl.document_header_id(+) = '"+documentHeaderId+"'\n" +
                    "ORDER BY dqb.level_1, dqb.level_2, dqb.level_3";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNumber);
        
        
        List<Object[]> temp = query.getResultList();
        
        if(temp != null && temp.size() >0){
                
                DocResultLine resultLine;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    resultLine = new DocResultLine();
                    resultLine.setDocumentHeaderId(objectToString(fields[0]));
                    resultLine.setDocumentNumber(objectToString(fields[1]));
                    resultLine.setDocumentType(objectToString(fields[2]));
                    resultLine.setWorkOrderId(objectToString(fields[3]));
                    resultLine.setDocumentLineId(objectToString(fields[4]));
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
