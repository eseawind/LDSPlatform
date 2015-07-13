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
@Table(name = "HCM_PRODUCTION_LINE_GROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcmProductionLineGroup.findAll", query = "SELECT h FROM HcmProductionLineGroup h"),
    @NamedQuery(name = "HcmProductionLineGroup.findByCreatedBy", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.createdBy = :createdBy"),
    @NamedQuery(name = "HcmProductionLineGroup.findByCreationDate", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.creationDate = :creationDate"),
    @NamedQuery(name = "HcmProductionLineGroup.findByLastUpdatedBy", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "HcmProductionLineGroup.findByLastUpdateDate", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "HcmProductionLineGroup.findByScheduleRegionId", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.scheduleRegionId = :scheduleRegionId"),
    @NamedQuery(name = "HcmProductionLineGroup.findByProdLineGroupId", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.prodLineGroupId = :prodLineGroupId"),
    @NamedQuery(name = "HcmProductionLineGroup.findByProdLineGroupCode", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.prodLineGroupCode = :prodLineGroupCode"),
    @NamedQuery(name = "HcmProductionLineGroup.findByDescriptions", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.descriptions = :descriptions"),
    @NamedQuery(name = "HcmProductionLineGroup.findByOrderByCode", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.orderByCode = :orderByCode"),
    @NamedQuery(name = "HcmProductionLineGroup.findByKeyPathFlag", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.keyPathFlag = :keyPathFlag"),
    @NamedQuery(name = "HcmProductionLineGroup.findByPlanStartTime", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.planStartTime = :planStartTime"),
    @NamedQuery(name = "HcmProductionLineGroup.findByWipCapacity", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.wipCapacity = :wipCapacity"),
    @NamedQuery(name = "HcmProductionLineGroup.findByEnableFlag", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.enableFlag = :enableFlag"),
    @NamedQuery(name = "HcmProductionLineGroup.findByAutoDeriveMo", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.autoDeriveMo = :autoDeriveMo"),
    @NamedQuery(name = "HcmProductionLineGroup.findByProcessSequence", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.processSequence = :processSequence"),
    @NamedQuery(name = "HcmProductionLineGroup.findByPeriodicTime", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.periodicTime = :periodicTime"),
    @NamedQuery(name = "HcmProductionLineGroup.findByBasicAlgorithm", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.basicAlgorithm = :basicAlgorithm"),
    @NamedQuery(name = "HcmProductionLineGroup.findByExtendedAlgorithm", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.extendedAlgorithm = :extendedAlgorithm"),
    @NamedQuery(name = "HcmProductionLineGroup.findByFixTimeFence", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.fixTimeFence = :fixTimeFence"),
    @NamedQuery(name = "HcmProductionLineGroup.findByForwardPlanningTimeFence", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.forwardPlanningTimeFence = :forwardPlanningTimeFence"),
    @NamedQuery(name = "HcmProductionLineGroup.findByMesFlag", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.mesFlag = :mesFlag"),
    @NamedQuery(name = "HcmProductionLineGroup.findByPlanningPhaseTime", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.planningPhaseTime = :planningPhaseTime"),
    @NamedQuery(name = "HcmProductionLineGroup.findByMoRefreshFlag", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.moRefreshFlag = :moRefreshFlag"),
    @NamedQuery(name = "HcmProductionLineGroup.findByOrderTimeFence", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.orderTimeFence = :orderTimeFence"),
    @NamedQuery(name = "HcmProductionLineGroup.findByFileCode", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.fileCode = :fileCode"),
    @NamedQuery(name = "HcmProductionLineGroup.findByComponentFollowFlag", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.componentFollowFlag = :componentFollowFlag"),
    @NamedQuery(name = "HcmProductionLineGroup.findByBusinessArea", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.businessArea = :businessArea"),
    @NamedQuery(name = "HcmProductionLineGroup.findByLockUserId", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.lockUserId = :lockUserId"),
    @NamedQuery(name = "HcmProductionLineGroup.findByLockTime", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.lockTime = :lockTime"),
    @NamedQuery(name = "HcmProductionLineGroup.findByAutoProdLineGroup", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.autoProdLineGroup = :autoProdLineGroup"),
    @NamedQuery(name = "HcmProductionLineGroup.findByReleaseTimeFence", query = "SELECT h FROM HcmProductionLineGroup h WHERE h.releaseTimeFence = :releaseTimeFence")})
public class HcmProductionLineGroup implements Serializable {
    private static final long serialVersionUID = 1L;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "SCHEDULE_REGION_ID")
    private BigInteger scheduleRegionId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_LINE_GROUP_ID")
    private BigDecimal prodLineGroupId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROD_LINE_GROUP_CODE")
    private String prodLineGroupCode;
    @Size(max = 200)
    @Column(name = "DESCRIPTIONS")
    private String descriptions;
    @Size(max = 30)
    @Column(name = "ORDER_BY_CODE")
    private String orderByCode;
    @Size(max = 1)
    @Column(name = "KEY_PATH_FLAG")
    private String keyPathFlag;
    @Column(name = "PLAN_START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date planStartTime;
    @Column(name = "WIP_CAPACITY")
    private BigInteger wipCapacity;
    @Size(max = 1)
    @Column(name = "ENABLE_FLAG")
    private String enableFlag;
    @Size(max = 1)
    @Column(name = "AUTO_DERIVE_MO")
    private String autoDeriveMo;
    @Size(max = 30)
    @Column(name = "PROCESS_SEQUENCE")
    private String processSequence;
    @Size(max = 10)
    @Column(name = "PERIODIC_TIME")
    private String periodicTime;
    @Size(max = 60)
    @Column(name = "BASIC_ALGORITHM")
    private String basicAlgorithm;
    @Size(max = 60)
    @Column(name = "EXTENDED_ALGORITHM")
    private String extendedAlgorithm;
    @Column(name = "FIX_TIME_FENCE")
    private BigInteger fixTimeFence;
    @Column(name = "FORWARD_PLANNING_TIME_FENCE")
    private BigInteger forwardPlanningTimeFence;
    @Size(max = 1)
    @Column(name = "MES_FLAG")
    private String mesFlag;
    @Size(max = 30)
    @Column(name = "PLANNING_PHASE_TIME")
    private String planningPhaseTime;
    @Size(max = 1)
    @Column(name = "MO_REFRESH_FLAG")
    private String moRefreshFlag;
    @Column(name = "ORDER_TIME_FENCE")
    private BigInteger orderTimeFence;
    @Size(max = 30)
    @Column(name = "FILE_CODE")
    private String fileCode;
    @Size(max = 1)
    @Column(name = "COMPONENT_FOLLOW_FLAG")
    private String componentFollowFlag;
    @Size(max = 30)
    @Column(name = "BUSINESS_AREA")
    private String businessArea;
    @Column(name = "LOCK_USER_ID")
    private BigInteger lockUserId;
    @Column(name = "LOCK_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockTime;
    @Column(name = "AUTO_PROD_LINE_GROUP")
    private BigInteger autoProdLineGroup;
    @Column(name = "RELEASE_TIME_FENCE")
    private BigInteger releaseTimeFence;

    public HcmProductionLineGroup() {
    }

    public HcmProductionLineGroup(BigDecimal prodLineGroupId) {
        this.prodLineGroupId = prodLineGroupId;
    }

    public HcmProductionLineGroup(BigDecimal prodLineGroupId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate, BigInteger scheduleRegionId, String prodLineGroupCode) {
        this.prodLineGroupId = prodLineGroupId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
        this.scheduleRegionId = scheduleRegionId;
        this.prodLineGroupCode = prodLineGroupCode;
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

    public BigInteger getScheduleRegionId() {
        return scheduleRegionId;
    }

    public void setScheduleRegionId(BigInteger scheduleRegionId) {
        this.scheduleRegionId = scheduleRegionId;
    }

    public BigDecimal getProdLineGroupId() {
        return prodLineGroupId;
    }

    public void setProdLineGroupId(BigDecimal prodLineGroupId) {
        this.prodLineGroupId = prodLineGroupId;
    }

    public String getProdLineGroupCode() {
        return prodLineGroupCode;
    }

    public void setProdLineGroupCode(String prodLineGroupCode) {
        this.prodLineGroupCode = prodLineGroupCode;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getOrderByCode() {
        return orderByCode;
    }

    public void setOrderByCode(String orderByCode) {
        this.orderByCode = orderByCode;
    }

    public String getKeyPathFlag() {
        return keyPathFlag;
    }

    public void setKeyPathFlag(String keyPathFlag) {
        this.keyPathFlag = keyPathFlag;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public BigInteger getWipCapacity() {
        return wipCapacity;
    }

    public void setWipCapacity(BigInteger wipCapacity) {
        this.wipCapacity = wipCapacity;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getAutoDeriveMo() {
        return autoDeriveMo;
    }

    public void setAutoDeriveMo(String autoDeriveMo) {
        this.autoDeriveMo = autoDeriveMo;
    }

    public String getProcessSequence() {
        return processSequence;
    }

    public void setProcessSequence(String processSequence) {
        this.processSequence = processSequence;
    }

    public String getPeriodicTime() {
        return periodicTime;
    }

    public void setPeriodicTime(String periodicTime) {
        this.periodicTime = periodicTime;
    }

    public String getBasicAlgorithm() {
        return basicAlgorithm;
    }

    public void setBasicAlgorithm(String basicAlgorithm) {
        this.basicAlgorithm = basicAlgorithm;
    }

    public String getExtendedAlgorithm() {
        return extendedAlgorithm;
    }

    public void setExtendedAlgorithm(String extendedAlgorithm) {
        this.extendedAlgorithm = extendedAlgorithm;
    }

    public BigInteger getFixTimeFence() {
        return fixTimeFence;
    }

    public void setFixTimeFence(BigInteger fixTimeFence) {
        this.fixTimeFence = fixTimeFence;
    }

    public BigInteger getForwardPlanningTimeFence() {
        return forwardPlanningTimeFence;
    }

    public void setForwardPlanningTimeFence(BigInteger forwardPlanningTimeFence) {
        this.forwardPlanningTimeFence = forwardPlanningTimeFence;
    }

    public String getMesFlag() {
        return mesFlag;
    }

    public void setMesFlag(String mesFlag) {
        this.mesFlag = mesFlag;
    }

    public String getPlanningPhaseTime() {
        return planningPhaseTime;
    }

    public void setPlanningPhaseTime(String planningPhaseTime) {
        this.planningPhaseTime = planningPhaseTime;
    }

    public String getMoRefreshFlag() {
        return moRefreshFlag;
    }

    public void setMoRefreshFlag(String moRefreshFlag) {
        this.moRefreshFlag = moRefreshFlag;
    }

    public BigInteger getOrderTimeFence() {
        return orderTimeFence;
    }

    public void setOrderTimeFence(BigInteger orderTimeFence) {
        this.orderTimeFence = orderTimeFence;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    public String getComponentFollowFlag() {
        return componentFollowFlag;
    }

    public void setComponentFollowFlag(String componentFollowFlag) {
        this.componentFollowFlag = componentFollowFlag;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public BigInteger getLockUserId() {
        return lockUserId;
    }

    public void setLockUserId(BigInteger lockUserId) {
        this.lockUserId = lockUserId;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public void setLockTime(Date lockTime) {
        this.lockTime = lockTime;
    }

    public BigInteger getAutoProdLineGroup() {
        return autoProdLineGroup;
    }

    public void setAutoProdLineGroup(BigInteger autoProdLineGroup) {
        this.autoProdLineGroup = autoProdLineGroup;
    }

    public BigInteger getReleaseTimeFence() {
        return releaseTimeFence;
    }

    public void setReleaseTimeFence(BigInteger releaseTimeFence) {
        this.releaseTimeFence = releaseTimeFence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodLineGroupId != null ? prodLineGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcmProductionLineGroup)) {
            return false;
        }
        HcmProductionLineGroup other = (HcmProductionLineGroup) object;
        if ((this.prodLineGroupId == null && other.prodLineGroupId != null) || (this.prodLineGroupId != null && !this.prodLineGroupId.equals(other.prodLineGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.HcmProductionLineGroup[ prodLineGroupId=" + prodLineGroupId + " ]";
    }
    
}
