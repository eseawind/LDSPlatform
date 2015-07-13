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
@Table(name = "DROID_DOCUMENT_HEADER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidDocumentHeader.findAll", query = "SELECT d FROM DroidDocumentHeader d"),
    @NamedQuery(name = "DroidDocumentHeader.findByDocumentHeaderId", query = "SELECT d FROM DroidDocumentHeader d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidDocumentHeader.findByDocumentNumber", query = "SELECT d FROM DroidDocumentHeader d WHERE d.documentNumber = :documentNumber"),
    @NamedQuery(name = "DroidDocumentHeader.findByDocumentType", query = "SELECT d FROM DroidDocumentHeader d WHERE d.documentType = :documentType"),
    @NamedQuery(name = "DroidDocumentHeader.findByDocumentStatus", query = "SELECT d FROM DroidDocumentHeader d WHERE d.documentStatus = :documentStatus"),
    @NamedQuery(name = "DroidDocumentHeader.findByWorkOrderId", query = "SELECT d FROM DroidDocumentHeader d WHERE d.workOrderId = :workOrderId"),
    @NamedQuery(name = "DroidDocumentHeader.findByCreatedBy", query = "SELECT d FROM DroidDocumentHeader d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidDocumentHeader.findByCreationDate", query = "SELECT d FROM DroidDocumentHeader d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidDocumentHeader.findByLastUpdatedBy", query = "SELECT d FROM DroidDocumentHeader d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidDocumentHeader.findByLastUpdateDate", query = "SELECT d FROM DroidDocumentHeader d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidDocumentHeader.findByLastUpdateLogin", query = "SELECT d FROM DroidDocumentHeader d WHERE d.lastUpdateLogin = :lastUpdateLogin")})
public class DroidDocumentHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="document_header_seq")
    @SequenceGenerator(name="document_header_seq", sequenceName="DROID_DOCUMENT_HEADER_S",allocationSize=1)
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOCUMENT_HEADER_ID")
    private BigDecimal documentHeaderId;

//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "DOCUMENT_HEADER_ID")
//    private BigDecimal documentHeaderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOCUMENT_TYPE")
    private String documentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DOCUMENT_STATUS")
    private String documentStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORK_ORDER_ID")
    private BigInteger workOrderId;
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
    
    @Size(min = 1, max = 1)
    @Column(name = "SHIFT_CODE")
    private String shiftCode;
    
    @Column(name = "PROD_LINE_GROUP_ID")
    private BigInteger prodLineGroupId;
    
    @Column(name = "PROD_LINE_ID")
    private BigInteger prodLineId;

    public BigInteger getProdLineGroupId() {
        return prodLineGroupId;
    }

    public BigInteger getProdLineId() {
        return prodLineId;
    }

    public void setProdLineGroupId(BigInteger prodLineGroupId) {
        this.prodLineGroupId = prodLineGroupId;
    }

    public void setProdLineId(BigInteger prodLineId) {
        this.prodLineId = prodLineId;
    }
    
    

    public String getShiftCode() {
        return shiftCode;
    }

    public void setShiftCode(String shiftCode) {
        this.shiftCode = shiftCode;
    }
    

    public DroidDocumentHeader() {
    }

    public DroidDocumentHeader(BigDecimal documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public DroidDocumentHeader(BigDecimal documentHeaderId, String documentNumber, String documentType, String documentStatus, BigInteger workOrderId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentHeaderId = documentHeaderId;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.documentStatus = documentStatus;
        this.workOrderId = workOrderId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
    }

    public BigDecimal getDocumentHeaderId() {
        return documentHeaderId;
    }

    public void setDocumentHeaderId(BigDecimal documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public BigInteger getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(BigInteger workOrderId) {
        this.workOrderId = workOrderId;
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
        hash += (documentHeaderId != null ? documentHeaderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidDocumentHeader)) {
            return false;
        }
        DroidDocumentHeader other = (DroidDocumentHeader) object;
        if ((this.documentHeaderId == null && other.documentHeaderId != null) || (this.documentHeaderId != null && !this.documentHeaderId.equals(other.documentHeaderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.DroidDocumentHeader[ documentHeaderId=" + documentHeaderId + " ]";
    }
    
}
