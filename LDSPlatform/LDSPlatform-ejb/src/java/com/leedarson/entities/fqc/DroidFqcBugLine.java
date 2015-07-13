/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.fqc;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.logging.Logger;
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
@Table(name = "DROID_FQC_BUG_LINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidFqcBugLine.findAll", query = "SELECT d FROM DroidFqcBugLine d"),
    @NamedQuery(name = "DroidFqcBugLine.findByDocumentBugLineId", query = "SELECT d FROM DroidFqcBugLine d WHERE d.documentBugLineId = :documentBugLineId"),
    @NamedQuery(name = "DroidFqcBugLine.findByDocumentBugHeaderId", query = "SELECT d FROM DroidFqcBugLine d WHERE d.documentBugHeaderId = :documentBugHeaderId"),
    @NamedQuery(name = "DroidFqcBugLine.findByBugCode", query = "SELECT d FROM DroidFqcBugLine d WHERE d.bugCode = :bugCode"),
    @NamedQuery(name = "DroidFqcBugLine.findByBugCount", query = "SELECT d FROM DroidFqcBugLine d WHERE d.bugCount = :bugCount"),
    @NamedQuery(name = "DroidFqcBugLine.findByAttr1", query = "SELECT d FROM DroidFqcBugLine d WHERE d.attr1 = :attr1"),
    @NamedQuery(name = "DroidFqcBugLine.findByAttr2", query = "SELECT d FROM DroidFqcBugLine d WHERE d.attr2 = :attr2"),
    @NamedQuery(name = "DroidFqcBugLine.findByAttr3", query = "SELECT d FROM DroidFqcBugLine d WHERE d.attr3 = :attr3"),
    @NamedQuery(name = "DroidFqcBugLine.findByAttr4", query = "SELECT d FROM DroidFqcBugLine d WHERE d.attr4 = :attr4"),
    @NamedQuery(name = "DroidFqcBugLine.findByAttr5", query = "SELECT d FROM DroidFqcBugLine d WHERE d.attr5 = :attr5"),
    @NamedQuery(name = "DroidFqcBugLine.findByCreatedBy", query = "SELECT d FROM DroidFqcBugLine d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidFqcBugLine.findByCreationDate", query = "SELECT d FROM DroidFqcBugLine d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidFqcBugLine.findByLastUpdatedBy", query = "SELECT d FROM DroidFqcBugLine d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidFqcBugLine.findByLastUpdateDate", query = "SELECT d FROM DroidFqcBugLine d WHERE d.lastUpdateDate = :lastUpdateDate")})
public class DroidFqcBugLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DOCUMENT_BUG_LINE_ID")
    private String documentBugLineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DOCUMENT_BUG_HEADER_ID")
    private String documentBugHeaderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "BUG_CODEGRUPPE")
    private String bugCodegruppe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "BUG_CODE")
    private String bugCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "BUG_COUNT")
    private String bugCount;
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

    public DroidFqcBugLine() {
    }

    public DroidFqcBugLine(String documentBugLineId) {
        this.documentBugLineId = documentBugLineId;
    }

    public DroidFqcBugLine(String documentBugLineId, String documentBugHeaderId, String bugCode, String bugCount, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentBugLineId = documentBugLineId;
        this.documentBugHeaderId = documentBugHeaderId;
        this.bugCode = bugCode;
        this.bugCount = bugCount;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getBugCodegruppe() {
        return bugCodegruppe;
    }

    public void setBugCodegruppe(String bugCodegruppe) {
        this.bugCodegruppe = bugCodegruppe;
    }

    public String getDocumentBugLineId() {
        return documentBugLineId;
    }

    public void setDocumentBugLineId(String documentBugLineId) {
        this.documentBugLineId = documentBugLineId;
    }

    public String getDocumentBugHeaderId() {
        return documentBugHeaderId;
    }

    public void setDocumentBugHeaderId(String documentBugHeaderId) {
        this.documentBugHeaderId = documentBugHeaderId;
    }

    public String getBugCode() {
        return bugCode;
    }

    public void setBugCode(String bugCode) {
        this.bugCode = bugCode;
    }

    public String getBugCount() {
        return bugCount;
    }

    public void setBugCount(String bugCount) {
        this.bugCount = bugCount;
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
        hash += (documentBugLineId != null ? documentBugLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidFqcBugLine)) {
            return false;
        }
        DroidFqcBugLine other = (DroidFqcBugLine) object;
        if ((this.documentBugLineId == null && other.documentBugLineId != null) || (this.documentBugLineId != null && !this.documentBugLineId.equals(other.documentBugLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.fqc.DroidFqcBugLine[ documentBugLineId=" + documentBugLineId + " ]";
    }
    
}
