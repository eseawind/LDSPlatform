/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HcmPlant;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface HcmPlantFacadeLocal {

    void create(HcmPlant hcmPlant);

    void edit(HcmPlant hcmPlant);

    void remove(HcmPlant hcmPlant);

    HcmPlant find(Object id);

    List<HcmPlant> findAll();

    List<HcmPlant> findRange(int[] range);

    int count();
    
}
