/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DroidFqcBugHeader;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidFqcBugHeaderFacadeLocal {

    void create(DroidFqcBugHeader droidFqcBugHeader);

    void edit(DroidFqcBugHeader droidFqcBugHeader);

    void remove(DroidFqcBugHeader droidFqcBugHeader);

    DroidFqcBugHeader find(Object id);

    List<DroidFqcBugHeader> findAll();

    List<DroidFqcBugHeader> findRange(int[] range);

    int count();
    
}
