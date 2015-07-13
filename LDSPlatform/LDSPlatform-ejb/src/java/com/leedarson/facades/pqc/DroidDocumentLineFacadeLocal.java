/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidDocumentLine;
import com.leedarson.entities.pqc.ResultLine;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidDocumentLineFacadeLocal {

    void create(DroidDocumentLine droidDocumentLine);

    void edit(DroidDocumentLine droidDocumentLine);

    void remove(DroidDocumentLine droidDocumentLine);

    DroidDocumentLine find(Object id);

    List<DroidDocumentLine> findAll();

    List<DroidDocumentLine> findRange(int[] range);

    int count();
    
    List<DroidDocumentLine> getResultOfLine(String docHeaderId, int level1, int level2, int level3);
    
    List<DroidDocumentLine> getResultBydocumentNumber(String documentNumber);
    
    List<ResultLine> getResultList(String documentNumber);
    
}
