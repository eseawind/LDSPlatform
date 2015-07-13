/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.bugs;

/**
 *
 * @author chenfeng
 */
public class BugInfo {
    
    private String mandt;//主机
    private String codeGruppe;//缺陷代码组
    private String code;//缺陷代码
    private String fehlklasse;//缺陷等级
    private String kurzText;//缺陷文本
    
    private String bugCount;//缺陷数量

    public String getMandt() {
        return mandt;
    }

    public String getCodeGruppe() {
        return codeGruppe;
    }

    public String getCode() {
        return code;
    }

    public String getFehlklasse() {
        return fehlklasse;
    }

    public String getKurzText() {
        return kurzText;
    }

    public String getBugCount() {
        return bugCount;
    }

    public void setMandt(String mandt) {
        this.mandt = mandt;
    }

    public void setCodeGruppe(String codeGruppe) {
        this.codeGruppe = codeGruppe;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFehlklasse(String fehlklasse) {
        this.fehlklasse = fehlklasse;
    }

    public void setKurzText(String kurzText) {
        this.kurzText = kurzText;
    }

    public void setBugCount(String bugCount) {
        this.bugCount = bugCount;
    }
    
    
}
