/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.fqc;

import com.leedarson.entities.fqc.DroidFqcDocumentHeader;
import com.leedarson.entities.oqc.FqcHeader;
import com.leedarson.entities.pqc.HomeListInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidFqcDocumentHeaderFacadeLocal {

    void create(DroidFqcDocumentHeader droidFqcDocumentHeader);

    void edit(DroidFqcDocumentHeader droidFqcDocumentHeader);

    void remove(DroidFqcDocumentHeader droidFqcDocumentHeader);

    DroidFqcDocumentHeader find(Object id);

    List<DroidFqcDocumentHeader> findAll();

    List<DroidFqcDocumentHeader> findRange(int[] range);

    int count();
    
    String getLastDocumentNum();
    
    List<HomeListInfo> getHomeList(String documentStatus, String poNumber, String productionLine, String customer, String fromDate, String toDate,
                                        String workOrderNum, String plantId);
    
    List<FqcHeader> getFqcList(String plantId, String status, String customer, String itemCode, 
                                            String workOrderNum, String fromDate, String toDate);
    
}
