/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.oqc;

import com.leedarson.entities.oqc.DroidOqcDocumentHeader;
import com.leedarson.entities.oqc.HeaderSoNumber;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidOqcDocumentHeaderFacadeLocal {

    void create(DroidOqcDocumentHeader droidOqcDocumentHeader);

    void edit(DroidOqcDocumentHeader droidOqcDocumentHeader);

    void remove(DroidOqcDocumentHeader droidOqcDocumentHeader);

    DroidOqcDocumentHeader find(Object id);

    List<DroidOqcDocumentHeader> findAll();

    List<DroidOqcDocumentHeader> findRange(int[] range);

    int count();
    
    String getLastDocumentNum();
    
    List<HeaderSoNumber> getSoNumbers(String innerPoNumber);
    
    List<DroidOqcDocumentHeader> getHomeList(String Status, String documentNumber, String resultCode,
        String outboundNumber, String soNumber, String cabinetNumber, String lockNumber,
        String customer, String inspector, String fromDate, String toDate);
    
}
