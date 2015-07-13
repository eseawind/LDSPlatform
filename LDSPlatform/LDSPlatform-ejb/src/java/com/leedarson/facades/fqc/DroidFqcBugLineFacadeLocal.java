/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DroidFqcBugLine;
import com.leedarson.entities.fqc.BugResultLine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidFqcBugLineFacadeLocal {

    void create(DroidFqcBugLine droidFqcBugLine);

    void edit(DroidFqcBugLine droidFqcBugLine);

    void remove(DroidFqcBugLine droidFqcBugLine);

    DroidFqcBugLine find(Object id);

    List<DroidFqcBugLine> findAll();

    List<DroidFqcBugLine> findRange(int[] range);

    int count();
    
    List<BugResultLine> getResultList(String documentNumber, String bugLevel);
    
}
