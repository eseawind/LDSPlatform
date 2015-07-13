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
@Table(name = "DROID_OQC_DOCUMENT_HEADER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidOqcDocumentHeader.findAll", query = "SELECT d FROM DroidOqcDocumentHeader d"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByDocumentHeaderId", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByDocumentNumber", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.documentNumber = :documentNumber"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByDocumentType", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.documentType = :documentType"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByDocumentStatus", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.documentStatus = :documentStatus"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByInspectionDate", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.inspectionDate = :inspectionDate"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByOutboundDeliveryNumber", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.outboundDeliveryNumber = :outboundDeliveryNumber"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByCabinetNumber", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.cabinetNumber = :cabinetNumber"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByLockNumber", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.lockNumber = :lockNumber"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByActualShipment", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.actualShipment = :actualShipment"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByResultCode", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.resultCode = :resultCode"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByInspectionException", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.inspectionException = :inspectionException"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByInspector", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.inspector = :inspector"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByAttr1", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.attr1 = :attr1"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByAttr2", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.attr2 = :attr2"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByAttr3", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.attr3 = :attr3"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByAttr4", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.attr4 = :attr4"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByAttr5", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.attr5 = :attr5"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByCreatedBy", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByCreationDate", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByLastUpdatedBy", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByLastUpdateDate", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "DroidOqcDocumentHeader.findByLastUpdateLogin", query = "SELECT d FROM DroidOqcDocumentHeader d WHERE d.lastUpdateLogin = :lastUpdateLogin")})
public class DroidOqcDocumentHeader implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(max = 1000)
    @Column(name = "DOCUMENT_HEADER_ID")
    private String documentHeaderId;
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
    @Column(name = "INSPECTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inspectionDate;
    @Size(max = 1000)
    @Column(name = "OUTBOUND_DELIVERY_NUMBER")
    private String outboundDeliveryNumber;
    @Size(max = 250)
    @Column(name = "CABINET_NUMBER")
    private String cabinetNumber;
    @Size(max = 250)
    @Column(name = "LOCK_NUMBER")
    private String lockNumber;
    @Column(name = "ACTUAL_SHIPMENT")
    private BigInteger actualShipment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RESULT_CODE")
    private String resultCode;
    @Size(max = 3000)
    @Column(name = "INSPECTION_EXCEPTION")
    private String inspectionException;
    @Size(max = 1000)
    @Column(name = "INSPECTOR")
    private String inspector;
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

    public DroidOqcDocumentHeader() {
    }

    public DroidOqcDocumentHeader(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public DroidOqcDocumentHeader(String documentHeaderId, String documentNumber, String documentType, String documentStatus, Date inspectionDate, String resultCode, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate) {
        this.documentHeaderId = documentHeaderId;
        this.documentNumber = documentNumber;
        this.documentType = documentType;
        this.documentStatus = documentStatus;
        this.inspectionDate = inspectionDate;
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

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    public String getOutboundDeliveryNumber() {
        return outboundDeliveryNumber;
    }

    public void setOutboundDeliveryNumber(String outboundDeliveryNumber) {
        this.outboundDeliveryNumber = outboundDeliveryNumber;
    }

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    public String getLockNumber() {
        return lockNumber;
    }

    public void setLockNumber(String lockNumber) {
        this.lockNumber = lockNumber;
    }

    public BigInteger getActualShipment() {
        return actualShipment;
    }

    public void setActualShipment(BigInteger actualShipment) {
        this.actualShipment = actualShipment;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getInspectionException() {
        return inspectionException;
    }

    public void setInspectionException(String inspectionException) {
        this.inspectionException = inspectionException;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
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
        hash += (documentHeaderId != null ? documentHeaderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidOqcDocumentHeader)) {
            return false;
        }
        DroidOqcDocumentHeader other = (DroidOqcDocumentHeader) object;
        if ((this.documentHeaderId == null && other.documentHeaderId != null) || (this.documentHeaderId != null && !this.documentHeaderId.equals(other.documentHeaderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.oqc.DroidOqcDocumentHeader[ documentHeaderId=" + documentHeaderId + " ]";
    }
    
}
