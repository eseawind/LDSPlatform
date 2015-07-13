/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.fqc;

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
@Table(name = "DROID_FQC_BUG_HEADER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidFqcBugHeader.findAll", query = "SELECT d FROM DroidFqcBugHeader d"),
    @NamedQuery(name = "DroidFqcBugHeader.findByDocumentBugHeaderId", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.documentBugHeaderId = :documentBugHeaderId"),
    @NamedQuery(name = "DroidFqcBugHeader.findByDocumentHeaderId", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidFqcBugHeader.findByBugLevel", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.bugLevel = :bugLevel"),
    @NamedQuery(name = "DroidFqcBugHeader.findBySamplingStandard", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.samplingStandard = :samplingStandard"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAccpectValue", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.accpectValue = :accpectValue"),
    @NamedQuery(name = "DroidFqcBugHeader.findByRejectValue", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.rejectValue = :rejectValue"),
    @NamedQuery(name = "DroidFqcBugHeader.findByBugsAmount", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.bugsAmount = :bugsAmount"),
    @NamedQuery(name = "DroidFqcBugHeader.findByResultCode", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.resultCode = :resultCode"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAttr1", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.attr1 = :attr1"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAttr2", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.attr2 = :attr2"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAttr3", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.attr3 = :attr3"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAttr4", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.attr4 = :attr4"),
    @NamedQuery(name = "DroidFqcBugHeader.findByAttr5", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.attr5 = :attr5"),
    @NamedQuery(name = "DroidFqcBugHeader.findByCreatedBy", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidFqcBugHeader.findByCreationDate", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidFqcBugHeader.findByLastUpdatedBy", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidFqcBugHeader.findByLastUpdateDate", query = "SELECT d FROM DroidFqcBugHeader d WHERE d.lastUpdateDate = :lastUpdateDate")})
public class DroidFqcBugHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DOCUMENT_BUG_HEADER_ID")
    private String documentBugHeaderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DOCUMENT_HEADER_ID")
    private String documentHeaderId;
    @Size(max = 30)
    @Column(name = "BUG_LEVEL")
    private String bugLevel;
    @Size(max = 100)
    @Column(name = "SAMPLING_STANDARD")
    private String samplingStandard;
    @Size(max = 30)
    @Column(name = "ACCPECT_VALUE")
    private String accpectValue;
    @Size(max = 30)
    @Column(name = "REJECT_VALUE")
    private String rejectValue;
    @Size(max = 30)
    @Column(name = "BUGS_AMOUNT")
    private String bugsAmount;
    @Size(max = 30)
    @Column(name = "RESULT_CODE")
    private String resultCode;
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

    public DroidFqcBugHeader() {
    }

    public DroidFqcBugHeader(String documentBugHeaderId) {
        this.documentBugHeaderId = documentBugHeaderId;
    }

    public DroidFqcBugHeader(String documentBugHeaderId, String documentHeaderId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentBugHeaderId = documentBugHeaderId;
        this.documentHeaderId = documentHeaderId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDocumentBugHeaderId() {
        return documentBugHeaderId;
    }

    public void setDocumentBugHeaderId(String documentBugHeaderId) {
        this.documentBugHeaderId = documentBugHeaderId;
    }

    public String getDocumentHeaderId() {
        return documentHeaderId;
    }

    public void setDocumentHeaderId(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public String getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(String bugLevel) {
        this.bugLevel = bugLevel;
    }

    public String getSamplingStandard() {
        return samplingStandard;
    }

    public void setSamplingStandard(String samplingStandard) {
        this.samplingStandard = samplingStandard;
    }

    public String getAccpectValue() {
        return accpectValue;
    }

    public void setAccpectValue(String accpectValue) {
        this.accpectValue = accpectValue;
    }

    public String getRejectValue() {
        return rejectValue;
    }

    public void setRejectValue(String rejectValue) {
        this.rejectValue = rejectValue;
    }

    public String getBugsAmount() {
        return bugsAmount;
    }

    public void setBugsAmount(String bugsAmount) {
        this.bugsAmount = bugsAmount;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentBugHeaderId != null ? documentBugHeaderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidFqcBugHeader)) {
            return false;
        }
        DroidFqcBugHeader other = (DroidFqcBugHeader) object;
        if ((this.documentBugHeaderId == null && other.documentBugHeaderId != null) || (this.documentBugHeaderId != null && !this.documentBugHeaderId.equals(other.documentBugHeaderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.fqc.DroidFqcBugHeader[ documentBugHeaderId=" + documentBugHeaderId + " ]";
    }
    
}
