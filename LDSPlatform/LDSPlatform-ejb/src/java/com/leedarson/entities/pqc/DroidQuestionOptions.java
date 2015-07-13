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
@Table(name = "DROID_QUESTION_OPTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidQuestionOptions.findAll", query = "SELECT d FROM DroidQuestionOptions d"),
    @NamedQuery(name = "DroidQuestionOptions.findByQuestionId", query = "SELECT d FROM DroidQuestionOptions d WHERE d.questionId = :questionId"),
    @NamedQuery(name = "DroidQuestionOptions.findByOptionId", query = "SELECT d FROM DroidQuestionOptions d WHERE d.optionId = :optionId"),
    @NamedQuery(name = "DroidQuestionOptions.findByOptionText", query = "SELECT d FROM DroidQuestionOptions d WHERE d.optionText = :optionText"),
    @NamedQuery(name = "DroidQuestionOptions.findByCreatedBy", query = "SELECT d FROM DroidQuestionOptions d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidQuestionOptions.findByCreationDate", query = "SELECT d FROM DroidQuestionOptions d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidQuestionOptions.findByLastUpdatedBy", query = "SELECT d FROM DroidQuestionOptions d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidQuestionOptions.findByLastUpdateDate", query = "SELECT d FROM DroidQuestionOptions d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidQuestionOptions.findByLastUpdateLogin", query = "SELECT d FROM DroidQuestionOptions d WHERE d.lastUpdateLogin = :lastUpdateLogin")})
public class DroidQuestionOptions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUESTION_ID")
    private BigInteger questionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPTION_ID")
    private BigDecimal optionId;
    @Size(max = 400)
    @Column(name = "OPTION_TEXT")
    private String optionText;
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

    public DroidQuestionOptions() {
    }

    public DroidQuestionOptions(BigDecimal optionId) {
        this.optionId = optionId;
    }

    public DroidQuestionOptions(BigDecimal optionId, BigInteger questionId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.optionId = optionId;
        this.questionId = questionId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigInteger getQuestionId() {
        return questionId;
    }

    public void setQuestionId(BigInteger questionId) {
        this.questionId = questionId;
    }

    public BigDecimal getOptionId() {
        return optionId;
    }

    public void setOptionId(BigDecimal optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionId != null ? optionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidQuestionOptions)) {
            return false;
        }
        DroidQuestionOptions other = (DroidQuestionOptions) object;
        if ((this.optionId == null && other.optionId != null) || (this.optionId != null && !this.optionId.equals(other.optionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.DroidQuestionOptions[ optionId=" + optionId + " ]";
    }
    
}
