/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidQuestionBank;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidQuestionBankFacadeLocal {

    void create(DroidQuestionBank droidQuestionBank);

    void edit(DroidQuestionBank droidQuestionBank);

    void remove(DroidQuestionBank droidQuestionBank);

    DroidQuestionBank find(Object id);

    List<DroidQuestionBank> findAll();

    List<DroidQuestionBank> findRange(int[] range);

    int count();
    
    List<DroidQuestionBank> getFirstQuestion(String question_type);
    
    List<DroidQuestionBank> getQuestionContents(String question_type);
    
    List<DroidQuestionBank> getQuestionById(int question_id);
    
    List<DroidQuestionBank> getNextQuestion(String question_type, int current_question_level1, int current_question_level2, int current_question_level3);
    
    List<DroidQuestionBank> getQuestionsByType(String question_type);
}
