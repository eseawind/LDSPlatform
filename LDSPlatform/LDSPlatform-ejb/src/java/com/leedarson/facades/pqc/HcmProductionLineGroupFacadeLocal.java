/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HcmProductionLineGroup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface HcmProductionLineGroupFacadeLocal {

    void create(HcmProductionLineGroup hcmProductionLineGroup);

    void edit(HcmProductionLineGroup hcmProductionLineGroup);

    void remove(HcmProductionLineGroup hcmProductionLineGroup);

    HcmProductionLineGroup find(Object id);

    List<HcmProductionLineGroup> findAll();

    List<HcmProductionLineGroup> findRange(int[] range);

    int count();
    
}
