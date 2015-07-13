/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.oqc;

/**
 *
 * @author chenfeng
 */
public class HeaderSoNumber {
    
    private String soNumber;
    
    private String soNumberLine;
    
    private String customerNameAlt;

    public String getSoNumber() {
        return soNumber;
    }

    public String getCustomerNameAlt() {
        return customerNameAlt;
    }

    public String getSoNumberLine() {
        return soNumberLine;
    }
    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public void setCustomerNameAlt(String customerNameAlt) {
        this.customerNameAlt = customerNameAlt;
    }
    
    public void setSoNumberLine(String soNumberLine) {
        this.soNumberLine = soNumberLine;
    }
    
    
}
