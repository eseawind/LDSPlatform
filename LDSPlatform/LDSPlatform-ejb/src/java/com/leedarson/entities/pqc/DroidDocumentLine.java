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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "DROID_DOCUMENT_LINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidDocumentLine.findAll", query = "SELECT d FROM DroidDocumentLine d"),
    @NamedQuery(name = "DroidDocumentLine.findByDocumentHeaderId", query = "SELECT d FROM DroidDocumentLine d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidDocumentLine.findByDocumentLineId", query = "SELECT d FROM DroidDocumentLine d WHERE d.documentLineId = :documentLineId"),
    @NamedQuery(name = "DroidDocumentLine.findByLevel1", query = "SELECT d FROM DroidDocumentLine d WHERE d.level1 = :level1"),
    @NamedQuery(name = "DroidDocumentLine.findByLevel2", query = "SELECT d FROM DroidDocumentLine d WHERE d.level2 = :level2"),
    @NamedQuery(name = "DroidDocumentLine.findByLevel3", query = "SELECT d FROM DroidDocumentLine d WHERE d.level3 = :level3"),
    @NamedQuery(name = "DroidDocumentLine.findByOptionId", query = "SELECT d FROM DroidDocumentLine d WHERE d.optionId = :optionId"),
    @NamedQuery(name = "DroidDocumentLine.findByResultCode", query = "SELECT d FROM DroidDocumentLine d WHERE d.resultCode = :resultCode"),
    @NamedQuery(name = "DroidDocumentLine.findByResultText", query = "SELECT d FROM DroidDocumentLine d WHERE d.resultText = :resultText"),
    @NamedQuery(name = "DroidDocumentLine.findByCreatedBy", query = "SELECT d FROM DroidDocumentLine d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidDocumentLine.findByCreationDate", query = "SELECT d FROM DroidDocumentLine d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidDocumentLine.findByLastUpdatedBy", query = "SELECT d FROM DroidDocumentLine d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidDocumentLine.findByLastUpdateDate", query = "SELECT d FROM DroidDocumentLine d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidDocumentLine.findByLastUpdateLogin", query = "SELECT d FROM DroidDocumentLine d WHERE d.lastUpdateLogin = :lastUpdateLogin")})
public class DroidDocumentLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_HEADER_ID")
    private BigInteger documentHeaderId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_line_seq")
    @SequenceGenerator(name="document_line_seq", sequenceName="DROID_DOCUMENT_LINE_S",allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_LINE_ID")
    private BigDecimal documentLineId;
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
    @Column(name = "OPTION_ID")
    private BigInteger optionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RESULT_CODE")
    private String resultCode;
    @Size(max = 3000)
    @Column(name = "RESULT_TEXT")
    private String resultText;
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


    public DroidDocumentLine() {
    }

    public DroidDocumentLine(BigDecimal documentLineId) {
        this.documentLineId = documentLineId;
    }

    public DroidDocumentLine(BigDecimal documentLineId, BigInteger documentHeaderId, BigInteger level1, BigInteger optionId, String resultCode, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentLineId = documentLineId;
        this.documentHeaderId = documentHeaderId;
        this.level1 = level1;
        this.optionId = optionId;
        this.resultCode = resultCode;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigInteger getDocumentHeaderId() {
        return documentHeaderId;
    }

    public void setDocumentHeaderId(BigInteger documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public BigDecimal getDocumentLineId() {
        return documentLineId;
    }

    public void setDocumentLineId(BigDecimal documentLineId) {
        this.documentLineId = documentLineId;
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

    public BigInteger getOptionId() {
        return optionId;
    }

    public void setOptionId(BigInteger optionId) {
        this.optionId = optionId;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
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
        hash += (documentLineId != null ? documentLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidDocumentLine)) {
            return false;
        }
        DroidDocumentLine other = (DroidDocumentLine) object;
        if ((this.documentLineId == null && other.documentLineId != null) || (this.documentLineId != null && !this.documentLineId.equals(other.documentLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.DroidDocumentLine[ documentLineId=" + documentLineId + " ]";
    }
    
}
