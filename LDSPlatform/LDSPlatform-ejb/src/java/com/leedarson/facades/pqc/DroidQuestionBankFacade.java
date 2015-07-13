/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidQuestionBank;
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
public class DroidQuestionBankFacade extends AbstractFacade<DroidQuestionBank> implements DroidQuestionBankFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidQuestionBankFacade() {
        super(DroidQuestionBank.class);
    }
    
    @Override
    public List<DroidQuestionBank> getFirstQuestion(String question_type){
        
        List<DroidQuestionBank> result = new ArrayList<DroidQuestionBank>();
        
        String sql = "select * from DROID_QUESTION_BANK t where t.QUESTION_TYPE= ? and t.LEVEL_1=1 and t.LEVEL_2=0 and t.LEVEL_3=0";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, question_type);
        
            List<Object[]> temp = query.getResultList();
//            System.out.println("temp : " + temp.get(0).toString());
            if(temp != null && temp.size() >0){
                
                DroidQuestionBank questionBank = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionBank = new DroidQuestionBank();
                    questionBank.setQuestionId(objectToBigDecimal(fields[0]));
                    questionBank.setLevel1(objectToBigInteger(fields[1]));
                    questionBank.setLevel2(objectToBigInteger(fields[2]));
                    questionBank.setLevel3(objectToBigInteger(fields[3]));
                    questionBank.setQuestionText(objectToString(fields[4]));
                    questionBank.setOperationSeq(objectToString(fields[11]));
                    questionBank.setIsKey(objectToString(fields[12]));
                    
                    result.add(questionBank);
                }
                
            }
            return result;
            
       
        
    }

    @Override
    public List<DroidQuestionBank> getQuestionContents(String question_type) {
        
        List<DroidQuestionBank> result = new ArrayList<DroidQuestionBank>();
        
        String sql = "select t.QUESTION_ID, t.LEVEL_1,t.LEVEL_2,t.LEVEL_3 from DROID_QUESTION_BANK t where t.QUESTION_TYPE= ? ORDER BY t.level_1, t.level_2, t.level_3";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, question_type);
        
            List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                DroidQuestionBank questionBank = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionBank = new DroidQuestionBank();
                    questionBank.setQuestionId(objectToBigDecimal(fields[0]));
                    questionBank.setLevel1(objectToBigInteger(fields[1]));
                    questionBank.setLevel2(objectToBigInteger(fields[2]));
                    questionBank.setLevel3(objectToBigInteger(fields[3]));
                    
                    
                    result.add(questionBank);
                }
                
            }
            return result;
    
    }

    @Override
    public List<DroidQuestionBank> getNextQuestion(String question_type, int current_question_level1, int current_question_level2, int current_question_level3) {
        
        List<DroidQuestionBank> result = new ArrayList<DroidQuestionBank>();
        
        String sql = "SELECT question_id, level_1, level_2, level_3, question_text FROM (SELECT hb.question_id, hb.level_1, hb.level_2, hb.level_3, hb.question_text FROM droid_question_bank hb WHERE hb.question_type = ? AND to_number(hb.level_1 || '.' || hb.level_2) > to_number(? || '.' || ?) ORDER BY hb.level_1, hb.level_2, hb.level_3) WHERE rownum = 1";
//        String sql = "SELECT question_id, level_1, level_2, level_3, question_text\n" +
//"        INTO x_question_id, x_lev_1, x_lev_2, x_lev_3, x_question_text\n" +
//"        FROM (SELECT hb.question_id, hb.level_1, hb.level_2, hb.level_3, hb.question_text\n" +
//"                FROM droid_question_bank hb\n" +
//"               WHERE hb.question_type = p_document_type\n" +
//"                 AND to_number(hb.level_1 || '.' || hb.level_2) >\n" +
//"                     to_number(p_lev_1 || '.' || p_lev_2)\n" +
//"               ORDER BY hb.level_1, hb.level_2, hb.level_3)\n" +
//"       WHERE rownum = 1";
        javax.persistence.Query query = em.createNativeQuery(sql);
//        javax.persistence.Query query = em.createNativeQuery("BEGIN ADM_MES.DROID_DOCUMENT_PCK.GET_NEXT_QUESTION();END;");
        query.setParameter(1, question_type);
        query.setParameter(2, current_question_level1);
        query.setParameter(3, current_question_level2);
//        query.setParameter(4, current_question_level3);
        
            List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                DroidQuestionBank questionBank = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionBank = new DroidQuestionBank();
                    questionBank.setQuestionId(objectToBigDecimal(fields[0]));
                    questionBank.setLevel1(objectToBigInteger(fields[1]));
                    questionBank.setLevel2(objectToBigInteger(fields[2]));
                    questionBank.setLevel3(objectToBigInteger(fields[3]));
                    questionBank.setQuestionText(objectToString(fields[4]));                    
                    
                    result.add(questionBank);
                }
                
            }
            return result;
        
    }

    @Override
    public List<DroidQuestionBank> getQuestionById(int question_id) {
        
    
        List<DroidQuestionBank> result = new ArrayList<DroidQuestionBank>();
        
        String sql = "select * from DROID_QUESTION_BANK t where t.QUESTION_ID = ?";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, question_id);
        
        
            List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                DroidQuestionBank questionBank = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionBank = new DroidQuestionBank();
                    questionBank.setQuestionId(objectToBigDecimal(fields[0]));
                    questionBank.setLevel1(objectToBigInteger(fields[1]));
                    questionBank.setLevel2(objectToBigInteger(fields[2]));
                    questionBank.setLevel3(objectToBigInteger(fields[3]));
                    questionBank.setQuestionText(objectToString(fields[4]));
                    questionBank.setOperationSeq(objectToString(fields[11]));
                    questionBank.setIsKey(objectToString(fields[12]));
                    
                    result.add(questionBank);
                }
                
            }
            return result;
    }
    
    @Override
    public List<DroidQuestionBank> getQuestionsByType(String question_type){
        
        List<DroidQuestionBank> result = new ArrayList<DroidQuestionBank>();
        
        String sql = "select * from DROID_QUESTION_BANK t where t.QUESTION_TYPE= ? ORDER BY t.level_1, t.level_2, t.level_3";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, question_type);
        
            List<Object[]> temp = query.getResultList();
//            System.out.println("temp : " + temp.get(0).toString());
            if(temp != null && temp.size() >0){
                
                DroidQuestionBank questionBank = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionBank = new DroidQuestionBank();
                    questionBank.setQuestionId(objectToBigDecimal(fields[0]));
                    questionBank.setLevel1(objectToBigInteger(fields[1]));
                    questionBank.setLevel2(objectToBigInteger(fields[2]));
                    questionBank.setLevel3(objectToBigInteger(fields[3]));
                    questionBank.setQuestionText(objectToString(fields[4]));
                    questionBank.setOperationSeq(objectToString(fields[11]));
                    questionBank.setIsKey(objectToString(fields[12]));
                    
                    result.add(questionBank);
                }
                
            }
            return result;
            
       
        
    }
   
}
