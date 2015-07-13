/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidQuestionOptions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidQuestionOptionsFacadeLocal {

    void create(DroidQuestionOptions droidQuestionOptions);

    void edit(DroidQuestionOptions droidQuestionOptions);

    void remove(DroidQuestionOptions droidQuestionOptions);

    DroidQuestionOptions find(Object id);

    List<DroidQuestionOptions> findAll();

    List<DroidQuestionOptions> findRange(int[] range);

    int count();
    
    List<DroidQuestionOptions> getQuestionOptions(int question_id);
    
}
