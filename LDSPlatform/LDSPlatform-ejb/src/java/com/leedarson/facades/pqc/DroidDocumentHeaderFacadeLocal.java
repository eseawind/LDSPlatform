/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.pqc;

import com.leedarson.entities.pqc.DroidDocumentHeader;
import com.leedarson.entities.pqc.HomeListInfo;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface DroidDocumentHeaderFacadeLocal {

    void create(DroidDocumentHeader droidDocumentHeader);

    void edit(DroidDocumentHeader droidDocumentHeader);

    void remove(DroidDocumentHeader droidDocumentHeader);

    DroidDocumentHeader find(Object id);

    List<DroidDocumentHeader> findAll();

    List<DroidDocumentHeader> findRange(int[] range);

    int count();
    
    String getLastDocumentNum();
    
    Object getHeaderIdbyDocumentNum(String documentNum);
    
    List<HomeListInfo> getHomeList(String documentStatus, String poNumber, String productionLine, String customer, String fromDate, String toDate,String workOrderNum, String plantId);
    
    Object isExitAlready(String documentNum);
    
    String newRecord(DroidDocumentHeader docHeader);
    
}
