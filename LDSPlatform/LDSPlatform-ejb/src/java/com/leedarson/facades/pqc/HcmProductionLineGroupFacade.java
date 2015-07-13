/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HcmProductionLineGroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class HcmProductionLineGroupFacade extends AbstractFacade<HcmProductionLineGroup> implements HcmProductionLineGroupFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HcmProductionLineGroupFacade() {
        super(HcmProductionLineGroup.class);
    }
    
}
