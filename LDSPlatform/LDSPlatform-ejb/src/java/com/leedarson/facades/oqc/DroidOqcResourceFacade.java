/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcResource;
import com.leedarson.facades.pqc.AbstractFacade;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class DroidOqcResourceFacade extends AbstractFacade<DroidOqcResource> implements DroidOqcResourceFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DroidOqcResourceFacade() {
        super(DroidOqcResource.class);
    }
    
}
