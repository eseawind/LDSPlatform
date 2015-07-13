/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.pqc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chenfeng
 */
@Entity
@Table(name = "DROID_QUESTION_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidQuestionBank.findAll", query = "SELECT d FROM DroidQuestionBank d"),
    @NamedQuery(name = "DroidQuestionBank.findByQuestionId", query = "SELECT d FROM DroidQuestionBank d WHERE d.questionId = :questionId"),
    @NamedQuery(name = "DroidQuestionBank.findByLevel1", query = "SELECT d FROM DroidQuestionBank d WHERE d.level1 = :level1"),
    @NamedQuery(name = "DroidQuestionBank.findByLevel2", query = "SELECT d FROM DroidQuestionBank d WHERE d.level2 = :level2"),
    @NamedQuery(name = "DroidQuestionBank.findByLevel3", query = "SELECT d FROM DroidQuestionBank d WHERE d.level3 = :level3"),
    @NamedQuery(name = "DroidQuestionBank.findByQuestionText", query = "SELECT d FROM DroidQuestionBank d WHERE d.questionText = :questionText"),
    @NamedQuery(name = "DroidQuestionBank.findByCreatedBy", query = "SELECT d FROM DroidQuestionBank d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidQuestionBank.findByCreationDate", query = "SELECT d FROM DroidQuestionBank d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidQuestionBank.findByLastUpdatedBy", query = "SELECT d FROM DroidQuestionBank d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidQuestionBank.findByLastUpdateDate", query = "SELECT d FROM DroidQuestionBank d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidQuestionBank.findByLastUpdateLogin", query = "SELECT d FROM DroidQuestionBank d WHERE d.lastUpdateLogin = :lastUpdateLogin"),
    @NamedQuery(name = "DroidQuestionBank.findByQuestionType", query = "SELECT d FROM DroidQuestionBank d WHERE d.questionType = :questionType")})
public class DroidQuestionBank implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_ID")
    private BigDecimal questionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LEVEL_1")
    private BigInteger level1;
    @Column(name = "LEVEL_2")
    private BigInteger level2;
    @Column(name = "LEVEL_3")
    private BigInteger level3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "QUESTION_TEXT")
    private String questionText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATED_BY")
    private BigInteger createdBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATED_BY")
    private BigInteger lastUpdatedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDate;
    @Column(name = "LAST_UPDATE_LOGIN")
    private BigInteger lastUpdateLogin;
    @Size(max = 30)
    @Column(name = "QUESTION_TYPE")
    private String questionType;
    
    @Size(min = 1, max = 30)
    @Column(name = "OPERATION_SEQ")
    private String operationSeq;
    
    @Size(min = 1, max = 30)
    @Column(name = "IS_KEY")
    private String isKey;

    public DroidQuestionBank() {
    }

    public DroidQuestionBank(BigDecimal questionId) {
        this.questionId = questionId;
    }

    public DroidQuestionBank(BigDecimal questionId, BigInteger level1, String questionText, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.questionId = questionId;
        this.level1 = level1;
        this.questionText = questionText;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigDecimal questionId) {
        this.questionId = questionId;
    }

    public BigInteger getLevel1() {
        return level1;
    }

    public void setLevel1(BigInteger level1) {
        this.level1 = level1;
    }

    public BigInteger getLevel2() {
        return level2;
    }

    public void setLevel2(BigInteger level2) {
        this.level2 = level2;
    }

    public BigInteger getLevel3() {
        return level3;
    }

    public void setLevel3(BigInteger level3) {
        this.level3 = level3;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public BigInteger getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(BigInteger createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BigInteger getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(BigInteger lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigInteger getLastUpdateLogin() {
        return lastUpdateLogin;
    }

    public void setLastUpdateLogin(BigInteger lastUpdateLogin) {
        this.lastUpdateLogin = lastUpdateLogin;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getOperationSeq() {
        return operationSeq;
    }

    public String getIsKey() {
        return isKey;
    }

    public void setOperationSeq(String operationSeq) {
        this.operationSeq = operationSeq;
    }

    public void setIsKey(String isKey) {
        this.isKey = isKey;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidQuestionBank)) {
            return false;
        }
        DroidQuestionBank other = (DroidQuestionBank) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.DroidQuestionBank[ questionId=" + questionId + " ]";
    }
    
}
