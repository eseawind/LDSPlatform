/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.pqc;

/**
 *
 * @author chenfeng
 */
public class HeaderInfo {
    
    private String makeOrderNum;        //生产订单
    
    private String poNumber;            //销售订单号
    
    private String soNumber;            //销售订单项目号
    
    private String poQty;               //销售数量
    
    private String itemCode;            //ID
    
    private String descriptions;        //ID短描述

    private String longDescriptions;    //ID长描述
            
    private String oneItemGroup;        //一阶物料组
    
    private String customer;            //客户简称
    
    private String prodLineGroupCode;   //生产课别
    
    private String prodLineCode;        //生产线别
    
    private String plantCode;           //生产工厂
    
    //下面两个字段未添加 2014-09-20；
    private String productionLine;      //产品线
    
    private String prodDep;             //生产部门

    public String getMakeOrderNum() {
        return makeOrderNum;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public String getPoQty() {
        return poQty;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getLongDescriptions() {
        return longDescriptions;
    }

    public String getOneItemGroup() {
        return oneItemGroup;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProdLineGroupCode() {
        return prodLineGroupCode;
    }

    public String getProdLineCode() {
        return prodLineCode;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public String getProductionLine() {
        return productionLine;
    }

    public String getProdDep() {
        return prodDep;
    }

    public void setMakeOrderNum(String makeOrderNum) {
        this.makeOrderNum = makeOrderNum;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }

    public void setPoQty(String poQty) {
        this.poQty = poQty;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setLongDescriptions(String longDescriptions) {
        this.longDescriptions = longDescriptions;
    }

    public void setOneItemGroup(String oneItemGroup) {
        this.oneItemGroup = oneItemGroup;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setProdLineGroupCode(String prodLineGroupCode) {
        this.prodLineGroupCode = prodLineGroupCode;
    }

    public void setProdLineCode(String prodLineCode) {
        this.prodLineCode = prodLineCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public void setProductionLine(String productionLine) {
        this.productionLine = productionLine;
    }

    public void setProdDep(String prodDep) {
        this.prodDep = prodDep;
    }
            
    
}
