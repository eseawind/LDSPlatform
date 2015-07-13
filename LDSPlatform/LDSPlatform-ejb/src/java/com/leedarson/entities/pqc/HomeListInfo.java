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
public class HomeListInfo {
    
    private String documentHeaderId;    //头ID
    
    private String documentNum;         //检验批号
    
    private String typeCode;           //类型代码
    
    private String docType;             //类型
    
    private String workOrderNum;        //生产工单号
    
    private String poNumber;            //销售订单号
    
    private String soNumber;            //销售订单项目号
    
    private String customer;            //客户
    
    private String prodLineCode;        //生产线别
    
    private String iqc;                 //检验员
    
    private String creationDate;        //创建时间
    
    private String longDescriptions;    //ID长描述
    
    private String prodLineId;          //线别ID
    
    private String prodLineGroupId;     //课别ID
    
    private String shiftCode;           //班次
    
    private String inspectAmount;       //检验批数量
    
    private String samplingAmount;      //抽检数量
    
    private String resultCode;          //检验结果
    
    private String proLineGroupCode;    //课别

    public String getProLineGroupCode() {
        return proLineGroupCode;
    }

    public void setProLineGroupCode(String proLineGroupCode) {
        this.proLineGroupCode = proLineGroupCode;
    }
    
    

    public String getInspectAmount() {
        return inspectAmount;
    }

    public String getSamplingAmount() {
        return samplingAmount;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setInspectAmount(String inspectAmount) {
        this.inspectAmount = inspectAmount;
    }

    public void setSamplingAmount(String samplingAmount) {
        this.samplingAmount = samplingAmount;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }
    
    

    public String getShiftCode() {
        return shiftCode;
    }

    public void setShiftCode(String shiftCode) {
        this.shiftCode = shiftCode;
    }
    
    

    public String getProdLineId() {
        return prodLineId;
    }

    public String getProdLineGroupId() {
        return prodLineGroupId;
    }

    public void setProdLineId(String prodLineId) {
        this.prodLineId = prodLineId;
    }

    public void setProdLineGroupId(String prodLineGroupId) {
        this.prodLineGroupId = prodLineGroupId;
    }
    
    

    public String getLongDescriptions() {
        return longDescriptions;
    }

    public void setLongDescriptions(String longDescriptions) {
        this.longDescriptions = longDescriptions;
    }
    
    

    public String getDocumentHeaderId() {
        return documentHeaderId;
    }

    public String getDocumentNum() {
        return documentNum;
    }

    public String getTypeCode() {
        return typeCode;
    }
    
    

    public String getDocType() {
        return docType;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public String getProdLineCode() {
        return prodLineCode;
    }

    public String getIqc() {
        return iqc;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setDocumentHeaderId(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    
    
    public void setDocType(String docType) {
        this.docType = docType;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setProdLineCode(String prodLineCode) {
        this.prodLineCode = prodLineCode;
    }

    public void setIqc(String iqc) {
        this.iqc = iqc;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getSoNumber() {
        return soNumber;
    }

    public void setSoNumber(String soNumber) {
        this.soNumber = soNumber;
    }
         
    
    
    
}
