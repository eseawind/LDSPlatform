/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcDocumentLine;
import com.leedarson.entities.pqc.ResultLine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidOqcDocumentLineFacadeLocal {

    void create(DroidOqcDocumentLine droidOqcDocumentLine);

    void edit(DroidOqcDocumentLine droidOqcDocumentLine);

    void remove(DroidOqcDocumentLine droidOqcDocumentLine);

    DroidOqcDocumentLine find(Object id);

    List<DroidOqcDocumentLine> findAll();

    List<DroidOqcDocumentLine> findRange(int[] range);

    int count();
    
    List<ResultLine> getResultList(String documentNumber);
    
}
