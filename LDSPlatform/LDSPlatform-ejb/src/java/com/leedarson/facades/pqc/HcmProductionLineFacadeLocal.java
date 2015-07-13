/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HcmProductionLine;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface HcmProductionLineFacadeLocal {

    void create(HcmProductionLine hcmProductionLine);

    void edit(HcmProductionLine hcmProductionLine);

    void remove(HcmProductionLine hcmProductionLine);

    HcmProductionLine find(Object id);

    List<HcmProductionLine> findAll();

    List<HcmProductionLine> findRange(int[] range);

    int count();
    
    List<HcmProductionLine> getProductionLineById(BigInteger prodLineGroupId);
    
}
