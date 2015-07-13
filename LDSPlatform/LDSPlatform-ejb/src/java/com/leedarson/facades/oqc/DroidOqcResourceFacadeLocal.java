/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcResource;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidOqcResourceFacadeLocal {

    void create(DroidOqcResource droidOqcResource);

    void edit(DroidOqcResource droidOqcResource);

    void remove(DroidOqcResource droidOqcResource);

    DroidOqcResource find(Object id);

    List<DroidOqcResource> findAll();

    List<DroidOqcResource> findRange(int[] range);

    int count();
    
}
