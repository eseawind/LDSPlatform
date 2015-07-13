/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidQuestionOptions;
import static com.leedarson.entities.util.EntityUtil.objectToBigDecimal;
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
public class DroidQuestionOptionsFacade extends AbstractFacade<DroidQuestionOptions> implements DroidQuestionOptionsFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidQuestionOptionsFacade() {
        super(DroidQuestionOptions.class);
    }
    
    @Override
    public List<DroidQuestionOptions> getQuestionOptions(int question_id) {
        
//        System.out.println("question_id : " + question_id);
        
        List<DroidQuestionOptions> result = new ArrayList<DroidQuestionOptions>();
        
        String sql = "select t.OPTION_ID, t.OPTION_TEXT from DROID_QUESTION_OPTIONS t where t.QUESTION_ID = ? ";
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, question_id);
        
            List<Object[]> temp = query.getResultList();
            
            if(temp != null && temp.size() >0){
                
                DroidQuestionOptions questionOptions = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    questionOptions = new DroidQuestionOptions();
                    questionOptions.setOptionId(objectToBigDecimal(fields[0]));
                    questionOptions.setOptionText(objectToString(fields[1]));
                    
                    result.add(questionOptions);
                }
                
            }
            return result;
    
    }
    
}
