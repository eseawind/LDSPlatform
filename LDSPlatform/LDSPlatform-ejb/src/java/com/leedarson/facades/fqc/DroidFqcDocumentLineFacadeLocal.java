/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DocResultLine;
import com.leedarson.entities.fqc.DroidFqcDocumentLine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidFqcDocumentLineFacadeLocal {

    void create(DroidFqcDocumentLine droidFqcDocumentLine);

    void edit(DroidFqcDocumentLine droidFqcDocumentLine);

    void remove(DroidFqcDocumentLine droidFqcDocumentLine);

    DroidFqcDocumentLine find(Object id);

    List<DroidFqcDocumentLine> findAll();

    List<DroidFqcDocumentLine> findRange(int[] range);

    int count();
    
    List<DocResultLine> getResultList(String documentNumber);
    
}
