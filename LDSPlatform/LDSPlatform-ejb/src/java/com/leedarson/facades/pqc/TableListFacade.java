/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.TableList;
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
public class TableListFacade implements TableListFacadeLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "LDSPlatform-ejbPU")
    private EntityManager em;

    @Override
    public List<TableList> getTableList(String string1, String string2) {
        
        List<TableList> result = new ArrayList<TableList>();
        
//        String sql = "select v.LOOKUP_CODE, v.MEANING from hfwk_lookup_types_v v where v.lookup_type_code = 'DROID_DOCUMENT_TYPE'";
        String sql = "select v.LOOKUP_CODE, v.MEANING from hfwk_lookup_types_v v where v.lookup_type_code = 'DROID_DOCUMENT_TYPE' and (v.LOOKUP_CODE like '"+string1+"%' or v.LOOKUP_CODE like '"+string2+"%')";
        javax.persistence.Query query = em.createNativeQuery(sql);
        
        
            List<Object[]> temp = query.getResultList();
            if(temp != null && temp.size() >0){
                
                TableList tableList = null;
                
                for (int i=0;i<temp.size();i++){
                    Object[] fields = temp.get(i);
                    tableList = new TableList();
                    tableList.setQuestionType(objectToString(fields[0]));
                    tableList.setTableName(objectToString(fields[1]));
                    
                    result.add(tableList);
                }
                
            }
            return result;
        
        
    }

   
}
