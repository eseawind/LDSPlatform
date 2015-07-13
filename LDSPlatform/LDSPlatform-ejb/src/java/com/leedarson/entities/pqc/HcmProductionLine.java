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
@Table(name = "HCM_PRODUCTION_LINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcmProductionLine.findAll", query = "SELECT h FROM HcmProductionLine h"),
    @NamedQuery(name = "HcmProductionLine.findByCreatedBy", query = "SELECT h FROM HcmProductionLine h WHERE h.createdBy = :createdBy"),
    @NamedQuery(name = "HcmProductionLine.findByCreationDate", query = "SELECT h FROM HcmProductionLine h WHERE h.creationDate = :creationDate"),
    @NamedQuery(name = "HcmProductionLine.findByLastUpdatedBy", query = "SELECT h FROM HcmProductionLine h WHERE h.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "HcmProductionLine.findByLastUpdateDate", query = "SELECT h FROM HcmProductionLine h WHERE h.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "HcmProductionLine.findByScheduleRegionId", query = "SELECT h FROM HcmProductionLine h WHERE h.scheduleRegionId = :scheduleRegionId"),
    @NamedQuery(name = "HcmProductionLine.findByPlantId", query = "SELECT h FROM HcmProductionLine h WHERE h.plantId = :plantId"),
    @NamedQuery(name = "HcmProductionLine.findByProdLineGroupId", query = "SELECT h FROM HcmProductionLine h WHERE h.prodLineGroupId = :prodLineGroupId"),
    @NamedQuery(name = "HcmProductionLine.findByProdLineId", query = "SELECT h FROM HcmProductionLine h WHERE h.prodLineId = :prodLineId"),
    @NamedQuery(name = "HcmProductionLine.findByProdLineCode", query = "SELECT h FROM HcmProductionLine h WHERE h.prodLineCode = :prodLineCode"),
    @NamedQuery(name = "HcmProductionLine.findByProdLineType", query = "SELECT h FROM HcmProductionLine h WHERE h.prodLineType = :prodLineType"),
    @NamedQuery(name = "HcmProductionLine.findByDescriptions", query = "SELECT h FROM HcmProductionLine h WHERE h.descriptions = :descriptions"),
    @NamedQuery(name = "HcmProductionLine.findByRateType", query = "SELECT h FROM HcmProductionLine h WHERE h.rateType = :rateType"),
    @NamedQuery(name = "HcmProductionLine.findByRate", query = "SELECT h FROM HcmProductionLine h WHERE h.rate = :rate"),
    @NamedQuery(name = "HcmProductionLine.findByProductionVersion", query = "SELECT h FROM HcmProductionLine h WHERE h.productionVersion = :productionVersion"),
    @NamedQuery(name = "HcmProductionLine.findByActivity", query = "SELECT h FROM HcmProductionLine h WHERE h.activity = :activity"),
    @NamedQuery(name = "HcmProductionLine.findByPlanner", query = "SELECT h FROM HcmProductionLine h WHERE h.planner = :planner"),
    @NamedQuery(name = "HcmProductionLine.findByBottleneckFlag", query = "SELECT h FROM HcmProductionLine h WHERE h.bottleneckFlag = :bottleneckFlag"),
    @NamedQuery(name = "HcmProductionLine.findByWarehouseCode", query = "SELECT h FROM HcmProductionLine h WHERE h.warehouseCode = :warehouseCode"),
    @NamedQuery(name = "HcmProductionLine.findByLocatorCode", query = "SELECT h FROM HcmProductionLine h WHERE h.locatorCode = :locatorCode"),
    @NamedQuery(name = "HcmProductionLine.findByErpJobTypeId", query = "SELECT h FROM HcmProductionLine h WHERE h.erpJobTypeId = :erpJobTypeId"),
    @NamedQuery(name = "HcmProductionLine.findByBusinessArea", query = "SELECT h FROM HcmProductionLine h WHERE h.businessArea = :businessArea"),
    @NamedQuery(name = "HcmProductionLine.findByOrderByCode", query = "SELECT h FROM HcmProductionLine h WHERE h.orderByCode = :orderByCode"),
    @NamedQuery(name = "HcmProductionLine.findByEnableFlag", query = "SELECT h FROM HcmProductionLine h WHERE h.enableFlag = :enableFlag"),
    @NamedQuery(name = "HcmProductionLine.findByWipCapacity", query = "SELECT h FROM HcmProductionLine h WHERE h.wipCapacity = :wipCapacity"),
    @NamedQuery(name = "HcmProductionLine.findByIssuedWarehouseCode", query = "SELECT h FROM HcmProductionLine h WHERE h.issuedWarehouseCode = :issuedWarehouseCode"),
    @NamedQuery(name = "HcmProductionLine.findByIssuedLocatorCode", query = "SELECT h FROM HcmProductionLine h WHERE h.issuedLocatorCode = :issuedLocatorCode"),
    @NamedQuery(name = "HcmProductionLine.findByMaxScraped", query = "SELECT h FROM HcmProductionLine h WHERE h.maxScraped = :maxScraped"),
    @NamedQuery(name = "HcmProductionLine.findByMaxIssued", query = "SELECT h FROM HcmProductionLine h WHERE h.maxIssued = :maxIssued"),
    @NamedQuery(name = "HcmProductionLine.findByMaxCompleted", query = "SELECT h FROM HcmProductionLine h WHERE h.maxCompleted = :maxCompleted"),
    @NamedQuery(name = "HcmProductionLine.findByFixTimeFence", query = "SELECT h FROM HcmProductionLine h WHERE h.fixTimeFence = :fixTimeFence"),
    @NamedQuery(name = "HcmProductionLine.findBySupplierId", query = "SELECT h FROM HcmProductionLine h WHERE h.supplierId = :supplierId"),
    @NamedQuery(name = "HcmProductionLine.findBySupplierSiteId", query = "SELECT h FROM HcmProductionLine h WHERE h.supplierSiteId = :supplierSiteId"),
    @NamedQuery(name = "HcmProductionLine.findByForwardPlanningTimeFence", query = "SELECT h FROM HcmProductionLine h WHERE h.forwardPlanningTimeFence = :forwardPlanningTimeFence"),
    @NamedQuery(name = "HcmProductionLine.findByBufferCalendarId", query = "SELECT h FROM HcmProductionLine h WHERE h.bufferCalendarId = :bufferCalendarId"),
    @NamedQuery(name = "HcmProductionLine.findByMoRefreshFlag", query = "SELECT h FROM HcmProductionLine h WHERE h.moRefreshFlag = :moRefreshFlag"),
    @NamedQuery(name = "HcmProductionLine.findByFrozenWarehouseCode", query = "SELECT h FROM HcmProductionLine h WHERE h.frozenWarehouseCode = :frozenWarehouseCode"),
    @NamedQuery(name = "HcmProductionLine.findByFrozenLocatorCode", query = "SELECT h FROM HcmProductionLine h WHERE h.frozenLocatorCode = :frozenLocatorCode"),
    @NamedQuery(name = "HcmProductionLine.findByHzPrimaryOperationSeq", query = "SELECT h FROM HcmProductionLine h WHERE h.hzPrimaryOperationSeq = :hzPrimaryOperationSeq"),
    @NamedQuery(name = "HcmProductionLine.findByProductionLineAlt", query = "SELECT h FROM HcmProductionLine h WHERE h.productionLineAlt = :productionLineAlt"),
    @NamedQuery(name = "HcmProductionLine.findByAutoCompletionFlag", query = "SELECT h FROM HcmProductionLine h WHERE h.autoCompletionFlag = :autoCompletionFlag"),
    @NamedQuery(name = "HcmProductionLine.findByCompletionWarehouseCode", query = "SELECT h FROM HcmProductionLine h WHERE h.completionWarehouseCode = :completionWarehouseCode"),
    @NamedQuery(name = "HcmProductionLine.findByCompletionLocatorCode", query = "SELECT h FROM HcmProductionLine h WHERE h.completionLocatorCode = :completionLocatorCode")})
public class HcmProductionLine implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANT_ID")
    private BigInteger plantId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_LINE_GROUP_ID")
    private BigInteger prodLineGroupId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_LINE_ID")
    private BigDecimal prodLineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROD_LINE_CODE")
    private String prodLineCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROD_LINE_TYPE")
    private String prodLineType;
    @Size(max = 200)
    @Column(name = "DESCRIPTIONS")
    private String descriptions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATE_TYPE")
    private BigInteger rateType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATE")
    private BigInteger rate;
    @Size(max = 30)
    @Column(name = "PRODUCTION_VERSION")
    private String productionVersion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITY")
    private BigInteger activity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLANNER")
    private String planner;
    @Size(max = 1)
    @Column(name = "BOTTLENECK_FLAG")
    private String bottleneckFlag;
    @Size(max = 30)
    @Column(name = "WAREHOUSE_CODE")
    private String warehouseCode;
    @Size(max = 30)
    @Column(name = "LOCATOR_CODE")
    private String locatorCode;
    @Column(name = "ERP_JOB_TYPE_ID")
    private BigInteger erpJobTypeId;
    @Size(max = 30)
    @Column(name = "BUSINESS_AREA")
    private String businessArea;
    @Size(max = 30)
    @Column(name = "ORDER_BY_CODE")
    private String orderByCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ENABLE_FLAG")
    private String enableFlag;
    @Column(name = "WIP_CAPACITY")
    private BigInteger wipCapacity;
    @Size(max = 30)
    @Column(name = "ISSUED_WAREHOUSE_CODE")
    private String issuedWarehouseCode;
    @Size(max = 30)
    @Column(name = "ISSUED_LOCATOR_CODE")
    private String issuedLocatorCode;
    @Column(name = "MAX_SCRAPED")
    private BigInteger maxScraped;
    @Column(name = "MAX_ISSUED")
    private BigInteger maxIssued;
    @Column(name = "MAX_COMPLETED")
    private BigInteger maxCompleted;
    @Column(name = "FIX_TIME_FENCE")
    private BigInteger fixTimeFence;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Column(name = "SUPPLIER_SITE_ID")
    private BigInteger supplierSiteId;
    @Column(name = "FORWARD_PLANNING_TIME_FENCE")
    private BigInteger forwardPlanningTimeFence;
    @Column(name = "BUFFER_CALENDAR_ID")
    private BigInteger bufferCalendarId;
    @Size(max = 1)
    @Column(name = "MO_REFRESH_FLAG")
    private String moRefreshFlag;
    @Size(max = 30)
    @Column(name = "FROZEN_WAREHOUSE_CODE")
    private String frozenWarehouseCode;
    @Size(max = 30)
    @Column(name = "FROZEN_LOCATOR_CODE")
    private String frozenLocatorCode;
    @Size(max = 10)
    @Column(name = "HZ_PRIMARY_OPERATION_SEQ")
    private String hzPrimaryOperationSeq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PRODUCTION_LINE_ALT")
    private String productionLineAlt;
    @Size(max = 1)
    @Column(name = "AUTO_COMPLETION_FLAG")
    private String autoCompletionFlag;
    @Size(max = 30)
    @Column(name = "COMPLETION_WAREHOUSE_CODE")
    private String completionWarehouseCode;
    @Size(max = 30)
    @Column(name = "COMPLETION_LOCATOR_CODE")
    private String completionLocatorCode;

    public HcmProductionLine() {
    }

    public HcmProductionLine(BigDecimal prodLineId) {
        this.prodLineId = prodLineId;
    }

    public HcmProductionLine(BigDecimal prodLineId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate, BigInteger scheduleRegionId, BigInteger plantId, BigInteger prodLineGroupId, String prodLineCode, String prodLineType, BigInteger rateType, BigInteger rate, BigInteger activity, String planner, String enableFlag, String productionLineAlt) {
        this.prodLineId = prodLineId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
        this.scheduleRegionId = scheduleRegionId;
        this.plantId = plantId;
        this.prodLineGroupId = prodLineGroupId;
        this.prodLineCode = prodLineCode;
        this.prodLineType = prodLineType;
        this.rateType = rateType;
        this.rate = rate;
        this.activity = activity;
        this.planner = planner;
        this.enableFlag = enableFlag;
        this.productionLineAlt = productionLineAlt;
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

    public BigInteger getPlantId() {
        return plantId;
    }

    public void setPlantId(BigInteger plantId) {
        this.plantId = plantId;
    }

    public BigInteger getProdLineGroupId() {
        return prodLineGroupId;
    }

    public void setProdLineGroupId(BigInteger prodLineGroupId) {
        this.prodLineGroupId = prodLineGroupId;
    }

    public BigDecimal getProdLineId() {
        return prodLineId;
    }

    public void setProdLineId(BigDecimal prodLineId) {
        this.prodLineId = prodLineId;
    }

    public String getProdLineCode() {
        return prodLineCode;
    }

    public void setProdLineCode(String prodLineCode) {
        this.prodLineCode = prodLineCode;
    }

    public String getProdLineType() {
        return prodLineType;
    }

    public void setProdLineType(String prodLineType) {
        this.prodLineType = prodLineType;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public BigInteger getRateType() {
        return rateType;
    }

    public void setRateType(BigInteger rateType) {
        this.rateType = rateType;
    }

    public BigInteger getRate() {
        return rate;
    }

    public void setRate(BigInteger rate) {
        this.rate = rate;
    }

    public String getProductionVersion() {
        return productionVersion;
    }

    public void setProductionVersion(String productionVersion) {
        this.productionVersion = productionVersion;
    }

    public BigInteger getActivity() {
        return activity;
    }

    public void setActivity(BigInteger activity) {
        this.activity = activity;
    }

    public String getPlanner() {
        return planner;
    }

    public void setPlanner(String planner) {
        this.planner = planner;
    }

    public String getBottleneckFlag() {
        return bottleneckFlag;
    }

    public void setBottleneckFlag(String bottleneckFlag) {
        this.bottleneckFlag = bottleneckFlag;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getLocatorCode() {
        return locatorCode;
    }

    public void setLocatorCode(String locatorCode) {
        this.locatorCode = locatorCode;
    }

    public BigInteger getErpJobTypeId() {
        return erpJobTypeId;
    }

    public void setErpJobTypeId(BigInteger erpJobTypeId) {
        this.erpJobTypeId = erpJobTypeId;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getOrderByCode() {
        return orderByCode;
    }

    public void setOrderByCode(String orderByCode) {
        this.orderByCode = orderByCode;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public BigInteger getWipCapacity() {
        return wipCapacity;
    }

    public void setWipCapacity(BigInteger wipCapacity) {
        this.wipCapacity = wipCapacity;
    }

    public String getIssuedWarehouseCode() {
        return issuedWarehouseCode;
    }

    public void setIssuedWarehouseCode(String issuedWarehouseCode) {
        this.issuedWarehouseCode = issuedWarehouseCode;
    }

    public String getIssuedLocatorCode() {
        return issuedLocatorCode;
    }

    public void setIssuedLocatorCode(String issuedLocatorCode) {
        this.issuedLocatorCode = issuedLocatorCode;
    }

    public BigInteger getMaxScraped() {
        return maxScraped;
    }

    public void setMaxScraped(BigInteger maxScraped) {
        this.maxScraped = maxScraped;
    }

    public BigInteger getMaxIssued() {
        return maxIssued;
    }

    public void setMaxIssued(BigInteger maxIssued) {
        this.maxIssued = maxIssued;
    }

    public BigInteger getMaxCompleted() {
        return maxCompleted;
    }

    public void setMaxCompleted(BigInteger maxCompleted) {
        this.maxCompleted = maxCompleted;
    }

    public BigInteger getFixTimeFence() {
        return fixTimeFence;
    }

    public void setFixTimeFence(BigInteger fixTimeFence) {
        this.fixTimeFence = fixTimeFence;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public BigInteger getSupplierSiteId() {
        return supplierSiteId;
    }

    public void setSupplierSiteId(BigInteger supplierSiteId) {
        this.supplierSiteId = supplierSiteId;
    }

    public BigInteger getForwardPlanningTimeFence() {
        return forwardPlanningTimeFence;
    }

    public void setForwardPlanningTimeFence(BigInteger forwardPlanningTimeFence) {
        this.forwardPlanningTimeFence = forwardPlanningTimeFence;
    }

    public BigInteger getBufferCalendarId() {
        return bufferCalendarId;
    }

    public void setBufferCalendarId(BigInteger bufferCalendarId) {
        this.bufferCalendarId = bufferCalendarId;
    }

    public String getMoRefreshFlag() {
        return moRefreshFlag;
    }

    public void setMoRefreshFlag(String moRefreshFlag) {
        this.moRefreshFlag = moRefreshFlag;
    }

    public String getFrozenWarehouseCode() {
        return frozenWarehouseCode;
    }

    public void setFrozenWarehouseCode(String frozenWarehouseCode) {
        this.frozenWarehouseCode = frozenWarehouseCode;
    }

    public String getFrozenLocatorCode() {
        return frozenLocatorCode;
    }

    public void setFrozenLocatorCode(String frozenLocatorCode) {
        this.frozenLocatorCode = frozenLocatorCode;
    }

    public String getHzPrimaryOperationSeq() {
        return hzPrimaryOperationSeq;
    }

    public void setHzPrimaryOperationSeq(String hzPrimaryOperationSeq) {
        this.hzPrimaryOperationSeq = hzPrimaryOperationSeq;
    }

    public String getProductionLineAlt() {
        return productionLineAlt;
    }

    public void setProductionLineAlt(String productionLineAlt) {
        this.productionLineAlt = productionLineAlt;
    }

    public String getAutoCompletionFlag() {
        return autoCompletionFlag;
    }

    public void setAutoCompletionFlag(String autoCompletionFlag) {
        this.autoCompletionFlag = autoCompletionFlag;
    }

    public String getCompletionWarehouseCode() {
        return completionWarehouseCode;
    }

    public void setCompletionWarehouseCode(String completionWarehouseCode) {
        this.completionWarehouseCode = completionWarehouseCode;
    }

    public String getCompletionLocatorCode() {
        return completionLocatorCode;
    }

    public void setCompletionLocatorCode(String completionLocatorCode) {
        this.completionLocatorCode = completionLocatorCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prodLineId != null ? prodLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcmProductionLine)) {
            return false;
        }
        HcmProductionLine other = (HcmProductionLine) object;
        if ((this.prodLineId == null && other.prodLineId != null) || (this.prodLineId != null && !this.prodLineId.equals(other.prodLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.HcmProductionLine[ prodLineId=" + prodLineId + " ]";
    }
    
}
