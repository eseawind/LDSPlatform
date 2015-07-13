/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.fqc;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author chenfeng
 */
public class DocResultLine {
    
    private String documentHeaderId;
    
    private String documentOqcHeaderId;
    
    private String documentNumber;
    
    private String documentType;
    
    private String workOrderId;
    
    private String outboundDeliveryNumber;
    
    private String documentLineId;
    
    private String documentOqcLineId;
    
    private BigDecimal questionId;
    
    private BigInteger level1;
    
    private BigInteger level2;
    
    private BigInteger level3;
    
    private String questionText;
    
    private String operationSeq;
    
    private String isKey;
    
    private BigInteger optionId;
    
    private String optionText;
    
    private String resultText;
    
    private String resultCode;

    public String getDocumentOqcLineId() {
        return documentOqcLineId;
    }

    public void setDocumentOqcLineId(String documentOqcLineId) {
        this.documentOqcLineId = documentOqcLineId;
    }
    
    
    

    public String getDocumentOqcHeaderId() {
        return documentOqcHeaderId;
    }

    public void setDocumentOqcHeaderId(String documentOqcHeaderId) {
        this.documentOqcHeaderId = documentOqcHeaderId;
    }
    
    

    public BigDecimal getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigDecimal questionId) {
        this.questionId = questionId;
    }
    
    

    public String getDocumentHeaderId() {
        return documentHeaderId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public String getOutboundDeliveryNumber() {
        return outboundDeliveryNumber;
    }
    
    public String getQuestionText() {
        return questionText;
    }

    public String getOperationSeq() {
        return operationSeq;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setDocumentHeaderId(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setOutboundDeliveryNumber(String outboundDeliveryNumber) {
        this.outboundDeliveryNumber = outboundDeliveryNumber;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setOperationSeq(String operationSeq) {
        this.operationSeq = operationSeq;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }

    public String getDocumentLineId() {
        return documentLineId;
    }

    public BigInteger getLevel1() {
        return level1;
    }

    public BigInteger getLevel2() {
        return level2;
    }

    public BigInteger getLevel3() {
        return level3;
    }

    public BigInteger getOptionId() {
        return optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setDocumentLineId(String documentLineId) {
        this.documentLineId = documentLineId;
    }

    public void setLevel1(BigInteger level1) {
        this.level1 = level1;
    }

    public void setLevel2(BigInteger level2) {
        this.level2 = level2;
    }

    public void setLevel3(BigInteger level3) {
        this.level3 = level3;
    }

    public void setOptionId(BigInteger optionId) {
        this.optionId = optionId;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
    
    
    
    
    
    
}
