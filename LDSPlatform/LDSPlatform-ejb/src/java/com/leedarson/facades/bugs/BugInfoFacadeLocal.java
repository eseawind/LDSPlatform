/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.facades.bugs;

import com.leedarson.entities.bugs.BugInfo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author chenfeng
 */
@Local
public interface BugInfoFacadeLocal {
    
    List<BugInfo> getBugInfo(String group, String code);
    
}
