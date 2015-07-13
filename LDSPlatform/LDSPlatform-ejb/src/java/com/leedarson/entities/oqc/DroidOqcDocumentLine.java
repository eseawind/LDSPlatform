/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.oqc;

import java.io.Serializable;
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
@Table(name = "DROID_OQC_DOCUMENT_LINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidOqcDocumentLine.findAll", query = "SELECT d FROM DroidOqcDocumentLine d"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByDocumentHeaderId", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByDocumentLineId", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.documentLineId = :documentLineId"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLevel1", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.level1 = :level1"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLevel2", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.level2 = :level2"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLevel3", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.level3 = :level3"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByResultCode", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.resultCode = :resultCode"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByResultText", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.resultText = :resultText"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByAttr1", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.attr1 = :attr1"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByAttr2", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.attr2 = :attr2"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByAttr3", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.attr3 = :attr3"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByAttr4", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.attr4 = :attr4"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByAttr5", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.attr5 = :attr5"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByCreatedBy", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByCreationDate", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLastUpdatedBy", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLastUpdateDate", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidOqcDocumentLine.findByLastUpdateLogin", query = "SELECT d FROM DroidOqcDocumentLine d WHERE d.lastUpdateLogin = :lastUpdateLogin")})
public class DroidOqcDocumentLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 1000)
    @Column(name = "DOCUMENT_LINE_ID")
    private String documentLineId;
    @Basic(optional = false)
    @NotNull
    @Size(max = 1000)
    @Column(name = "DOCUMENT_HEADER_ID")
    private String documentHeaderId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @Size(min = 1, max = 30)
    @Column(name = "RESULT_CODE")
    private String resultCode;
    @Size(max = 3000)
    @Column(name = "RESULT_TEXT")
    private String resultText;
    @Size(max = 1000)
    @Column(name = "ATTR1")
    private String attr1;
    @Size(max = 1000)
    @Column(name = "ATTR2")
    private String attr2;
    @Size(max = 1000)
    @Column(name = "ATTR3")
    private String attr3;
    @Size(max = 1000)
    @Column(name = "ATTR4")
    private String attr4;
    @Size(max = 1000)
    @Column(name = "ATTR5")
    private String attr5;
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

    public DroidOqcDocumentLine() {
    }

    public DroidOqcDocumentLine(String documentLineId) {
        this.documentLineId = documentLineId;
    }

    public DroidOqcDocumentLine(String documentLineId, String documentHeaderId, BigInteger level1, String resultCode, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentLineId = documentLineId;
        this.documentHeaderId = documentHeaderId;
        this.level1 = level1;
        this.resultCode = resultCode;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDocumentHeaderId() {
        return documentHeaderId;
    }

    public void setDocumentHeaderId(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public String getDocumentLineId() {
        return documentLineId;
    }

    public void setDocumentLineId(String documentLineId) {
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

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    public String getAttr4() {
        return attr4;
    }

    public void setAttr4(String attr4) {
        this.attr4 = attr4;
    }

    public String getAttr5() {
        return attr5;
    }

    public void setAttr5(String attr5) {
        this.attr5 = attr5;
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
        if (!(object instanceof DroidOqcDocumentLine)) {
            return false;
        }
        DroidOqcDocumentLine other = (DroidOqcDocumentLine) object;
        if ((this.documentLineId == null && other.documentLineId != null) || (this.documentLineId != null && !this.documentLineId.equals(other.documentLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.oqc.DroidOqcDocumentLine[ documentLineId=" + documentLineId + " ]";
    }
    
}
