/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcDocumentLine;
import com.leedarson.entities.pqc.ResultLine;
import static com.leedarson.entities.util.EntityUtil.objectToBigDecimal;
import static com.leedarson.entities.util.EntityUtil.objectToBigInteger;
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
public class DroidOqcDocumentLineFacade extends AbstractFacade<DroidOqcDocumentLine> implements DroidOqcDocumentLineFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidOqcDocumentLineFacade() {
        super(DroidOqcDocumentLine.class);
    }
    
    @Override
    public List<ResultLine> getResultList(String documentNumber) {
       
        String subsql = "select t.DOCUMENT_HEADER_ID from droid_oqc_document_header t where t.DOCUMENT_NUMBER = ? ";
        javax.persistence.Query subquery = em.createNativeQuery(subsql);
        subquery.setParameter(1, documentNumber);
        Object documentHeaderId = subquery.getSingleResult();
        
        List<ResultLine> result = new ArrayList<ResultLine>();
        
        String sql = "SELECT ddh.document_header_id, \n" +
"       ddh.document_number, \n" +
"       ddh.document_type, \n" +
"       ddh.OUTBOUND_DELIVERY_NUMBER, \n" +
"       dhl.document_line_id, \n" +
"       dqb.QUESTION_ID, \n" +
"       dqb.level_1, \n" +
"       dqb.level_2, \n" +
"       dqb.level_3, \n" +
"       dqb.question_text, \n" +
"       dqb.operation_seq, \n" +
"       dqb.is_key, \n" +
"       dhl.RESULT_TEXT, \n" +
"       dhl.RESULT_CODE \n" +
"FROM droid_oqc_document_header  ddh, \n" +
"       droid_oqc_document_line    dhl, \n" +
"       droid_question_bank    dqb \n" +
"WHERE ddh.document_number = ?\n" +
"   AND dqb.question_type = ddh.document_type \n" +
"   AND dhl.level_1(+) = dqb.level_1 \n" +
"   AND dhl.level_2(+) = dqb.level_2 \n" +
"   AND dhl.level_3(+) = dqb.level_3 \n" +
"   AND dhl.document_header_id(+) = '"+objectToString(documentHeaderId)+"' \n" +
"ORDER BY dqb.level_1, dqb.level_2, dqb.level_3";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, documentNumber);
        
        
        List<Object[]> temp = query.getResultList();
        
        if(temp != null && temp.size() >0){
                
                ResultLine resultLine;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    resultLine = new ResultLine();
                    resultLine.setDocumentOqcHeaderId(objectToString(fields[0]));
                    resultLine.setDocumentNumber(objectToString(fields[1]));
                    resultLine.setDocumentType(objectToString(fields[2]));
                    resultLine.setOutboundDeliveryNumber(objectToString(fields[3]));
                    resultLine.setDocumentOqcLineId(objectToString(fields[4]));
                    resultLine.setQuestionId(objectToBigDecimal(fields[5]));
                    resultLine.setLevel1(objectToBigInteger(fields[6]));
                    resultLine.setLevel2(objectToBigInteger(fields[7]));
                    resultLine.setLevel3(objectToBigInteger(fields[8]));
                    resultLine.setQuestionText(objectToString(fields[9]));
                    resultLine.setOperationSeq(objectToString(fields[10]));
                    resultLine.setIsKey(objectToString(fields[11]));
                    //resultLine.setOptionId(objectToBigInteger(fields[12]));
                    //resultLine.setOptionText(objectToString(fields[13]));
                    resultLine.setResultText(objectToString(fields[12]));
                    resultLine.setResultCode(objectToString(fields[13]));
                    
                    
                    result.add(resultLine);
                }
                
            }
            return result;
        
        
    }
    
    
}
