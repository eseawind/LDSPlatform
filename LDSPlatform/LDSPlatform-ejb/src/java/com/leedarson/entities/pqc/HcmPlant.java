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
@Table(name = "HCM_PLANT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcmPlant.findAll", query = "SELECT h FROM HcmPlant h"),
    @NamedQuery(name = "HcmPlant.findByCreatedBy", query = "SELECT h FROM HcmPlant h WHERE h.createdBy = :createdBy"),
    @NamedQuery(name = "HcmPlant.findByCreationDate", query = "SELECT h FROM HcmPlant h WHERE h.creationDate = :creationDate"),
    @NamedQuery(name = "HcmPlant.findByLastUpdatedBy", query = "SELECT h FROM HcmPlant h WHERE h.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "HcmPlant.findByLastUpdateDate", query = "SELECT h FROM HcmPlant h WHERE h.lastUpdateDate = :lastUpdateDate"),
    @NamedQuery(name = "HcmPlant.findByScheduleRegionId", query = "SELECT h FROM HcmPlant h WHERE h.scheduleRegionId = :scheduleRegionId"),
    @NamedQuery(name = "HcmPlant.findByPlantId", query = "SELECT h FROM HcmPlant h WHERE h.plantId = :plantId"),
    @NamedQuery(name = "HcmPlant.findByPlantCode", query = "SELECT h FROM HcmPlant h WHERE h.plantCode = :plantCode"),
    @NamedQuery(name = "HcmPlant.findByDescriptions", query = "SELECT h FROM HcmPlant h WHERE h.descriptions = :descriptions"),
    @NamedQuery(name = "HcmPlant.findByEnableFlag", query = "SELECT h FROM HcmPlant h WHERE h.enableFlag = :enableFlag"),
    @NamedQuery(name = "HcmPlant.findByMainPlantFlag", query = "SELECT h FROM HcmPlant h WHERE h.mainPlantFlag = :mainPlantFlag"),
    @NamedQuery(name = "HcmPlant.findByStoreRegionId", query = "SELECT h FROM HcmPlant h WHERE h.storeRegionId = :storeRegionId"),
    @NamedQuery(name = "HcmPlant.findByOrgId", query = "SELECT h FROM HcmPlant h WHERE h.orgId = :orgId"),
    @NamedQuery(name = "HcmPlant.findByMesFlag", query = "SELECT h FROM HcmPlant h WHERE h.mesFlag = :mesFlag")})
public class HcmPlant implements Serializable {
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
    @Column(name = "PLANT_ID")
    private BigDecimal plantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PLANT_CODE")
    private String plantCode;
    @Size(max = 200)
    @Column(name = "DESCRIPTIONS")
    private String descriptions;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ENABLE_FLAG")
    private String enableFlag;
    @Size(max = 1)
    @Column(name = "MAIN_PLANT_FLAG")
    private String mainPlantFlag;
    @Column(name = "STORE_REGION_ID")
    private BigInteger storeRegionId;
    @Column(name = "ORG_ID")
    private BigInteger orgId;
    @Size(max = 1)
    @Column(name = "MES_FLAG")
    private String mesFlag;

    public HcmPlant() {
    }

    public HcmPlant(BigDecimal plantId) {
        this.plantId = plantId;
    }

    public HcmPlant(BigDecimal plantId, BigInteger createdBy, Date creationDate, BigInteger lastUpdatedBy, Date lastUpdateDate, BigInteger scheduleRegionId, String plantCode, String enableFlag) {
        this.plantId = plantId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdatedBy = lastUpdatedBy;
        this.lastUpdateDate = lastUpdateDate;
        this.scheduleRegionId = scheduleRegionId;
        this.plantCode = plantCode;
        this.enableFlag = enableFlag;
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

    public BigDecimal getPlantId() {
        return plantId;
    }

    public void setPlantId(BigDecimal plantId) {
        this.plantId = plantId;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    public String getMainPlantFlag() {
        return mainPlantFlag;
    }

    public void setMainPlantFlag(String mainPlantFlag) {
        this.mainPlantFlag = mainPlantFlag;
    }

    public BigInteger getStoreRegionId() {
        return storeRegionId;
    }

    public void setStoreRegionId(BigInteger storeRegionId) {
        this.storeRegionId = storeRegionId;
    }

    public BigInteger getOrgId() {
        return orgId;
    }

    public void setOrgId(BigInteger orgId) {
        this.orgId = orgId;
    }

    public String getMesFlag() {
        return mesFlag;
    }

    public void setMesFlag(String mesFlag) {
        this.mesFlag = mesFlag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plantId != null ? plantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcmPlant)) {
            return false;
        }
        HcmPlant other = (HcmPlant) object;
        if ((this.plantId == null && other.plantId != null) || (this.plantId != null && !this.plantId.equals(other.plantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.HcmPlant[ plantId=" + plantId + " ]";
    }
    
}
