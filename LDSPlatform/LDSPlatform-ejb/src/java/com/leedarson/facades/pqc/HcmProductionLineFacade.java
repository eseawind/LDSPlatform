/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.HcmProductionLine;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class HcmProductionLineFacade extends AbstractFacade<HcmProductionLine> implements HcmProductionLineFacadeLocal {
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HcmProductionLineFacade() {
        super(HcmProductionLine.class);
    }
    
    public List<HcmProductionLine> getProductionLineById(BigInteger prodLineGroupId){
        
        javax.persistence.Query query = em.createNamedQuery("HcmProductionLine.findByProdLineGroupId");
        query.setParameter("prodLineGroupId", prodLineGroupId);
        List<HcmProductionLine> resultList = query.getResultList();
        if(resultList != null && resultList.size() > 0) {
            return resultList;
        }
        return null;
    }
    
}
