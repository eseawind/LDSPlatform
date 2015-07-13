/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.fqc;

/**
 *
 * @author chenfeng
 */
public class BugResultLine {
    
    private String bugLevel;
    
    private String standard;
    
    private String accpect;
    
    private String reject;
    
    private String result;
    
    private String amount;
    
    private String group;
    
    private String code;
    
    private String fehlklasse;
    
    private String text;
    
    private String bugCount;
    
    private String bugLineId;
    
    private String bugHeaderId;

    public String getBugLineId() {
        return bugLineId;
    }

    public String getBugHeaderId() {
        return bugHeaderId;
    }

    public void setBugLineId(String bugLineId) {
        this.bugLineId = bugLineId;
    }

    public void setBugHeaderId(String bugHeaderId) {
        this.bugHeaderId = bugHeaderId;
    }
    
    

    public String getBugCount() {
        return bugCount;
    }

    public void setBugCount(String bugCount) {
        this.bugCount = bugCount;
    }
    
    

    public String getBugLevel() {
        return bugLevel;
    }

    public String getStandard() {
        return standard;
    }

    public String getAccpect() {
        return accpect;
    }

    public String getReject() {
        return reject;
    }

    public String getResult() {
        return result;
    }

    public String getAmount() {
        return amount;
    }

    public String getGroup() {
        return group;
    }

    public String getCode() {
        return code;
    }

    public String getFehlklasse() {
        return fehlklasse;
    }

    public String getText() {
        return text;
    }

    public void setBugLevel(String bugLevel) {
        this.bugLevel = bugLevel;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public void setAccpect(String accpect) {
        this.accpect = accpect;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFehlklasse(String fehlklasse) {
        this.fehlklasse = fehlklasse;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
    
}
