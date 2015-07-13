/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.bugs;

import com.leedarson.entities.bugs.BugInfo;
import static com.leedarson.entities.util.EntityUtil.objectToString;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author chenfeng
 */
@Stateless
public class BugInfoFacade implements BugInfoFacadeLocal{
    
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    public List<BugInfo> getBugInfo(String group, String code) {
        
        List<BugInfo> result = new ArrayList<BugInfo>();
        
        String sql = "select v1.MANDT,\n" +
                    "	v1.CODEGRUPPE,\n" +
                    "	v1.CODE,\n" +
                    "	v1.FEHLKLASSE,\n" +
                    "	v2.KURZTEXT\n" +
                    "from QPCD v1,\n" +
                    "	QPCT v2\n" +
                    "where 1 = 1\n" +
                    "and v1.CODE = v2.CODE\n" +
                    "and v1.CODEGRUPPE = v2.CODEGRUPPE\n" +
                    "and v1.MANDT = v2.MANDT\n" +
                    "and v1.CODEGRUPPE = ?\n" +
                    "and v1.CODE = ?\n" +
                    "and v2.MANDT = '600'";
        
        javax.persistence.Query query = em.createNativeQuery(sql);
        query.setParameter(1, group);
        query.setParameter(2, code);
        
        List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                BugInfo bugInfo = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    bugInfo = new BugInfo();
                    bugInfo.setMandt(objectToString(fields[0]));
                    bugInfo.setCodeGruppe(objectToString(fields[1]));
                    bugInfo.setCode(objectToString(fields[2]));
                    bugInfo.setFehlklasse(objectToString(fields[3]));
                    bugInfo.setKurzText(objectToString(fields[4]));
                    
                    result.add(bugInfo);
                }
                
            }
            return result;
    }
    
    
}
