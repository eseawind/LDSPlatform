/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.leedarson.entities.oqc;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chenfeng
 */
@Entity
@Table(name = "DROID_OQC_RESOURCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DroidOqcResource.findAll", query = "SELECT d FROM DroidOqcResource d"),
    @NamedQuery(name = "DroidOqcResource.findByResourceId", query = "SELECT d FROM DroidOqcResource d WHERE d.resourceId = :resourceId"),
    @NamedQuery(name = "DroidOqcResource.findByDocumentHeaderId", query = "SELECT d FROM DroidOqcResource d WHERE d.documentHeaderId = :documentHeaderId"),
    @NamedQuery(name = "DroidOqcResource.findByFileName", query = "SELECT d FROM DroidOqcResource d WHERE d.fileName = :fileName"),
    @NamedQuery(name = "DroidOqcResource.findByContentType", query = "SELECT d FROM DroidOqcResource d WHERE d.contentType = :contentType"),
    @NamedQuery(name = "DroidOqcResource.findByFilePath", query = "SELECT d FROM DroidOqcResource d WHERE d.filePath = :filePath"),
    @NamedQuery(name = "DroidOqcResource.findByAttr1", query = "SELECT d FROM DroidOqcResource d WHERE d.attr1 = :attr1"),
    @NamedQuery(name = "DroidOqcResource.findByAttr2", query = "SELECT d FROM DroidOqcResource d WHERE d.attr2 = :attr2"),
    @NamedQuery(name = "DroidOqcResource.findByAttr3", query = "SELECT d FROM DroidOqcResource d WHERE d.attr3 = :attr3"),
    @NamedQuery(name = "DroidOqcResource.findByAttr4", query = "SELECT d FROM DroidOqcResource d WHERE d.attr4 = :attr4"),
    @NamedQuery(name = "DroidOqcResource.findByAttr5", query = "SELECT d FROM DroidOqcResource d WHERE d.attr5 = :attr5"),
    @NamedQuery(name = "DroidOqcResource.findByCreatedBy", query = "SELECT d FROM DroidOqcResource d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DroidOqcResource.findByCreationDate", query = "SELECT d FROM DroidOqcResource d WHERE d.creationDate = :creationDate"),
    @NamedQuery(name = "DroidOqcResource.findByLastUpdatedBy", query = "SELECT d FROM DroidOqcResource d WHERE d.lastUpdatedBy = :lastUpdatedBy"),
    @NamedQuery(name = "DroidOqcResource.findByLastUpdatedDate", query = "SELECT d FROM DroidOqcResource d WHERE d.lastUpdatedDate = :lastUpdatedDate")})
public class DroidOqcResource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "RESOURCE_ID")
    private String resourceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DOCUMENT_HEADER_ID")
    private String documentHeaderId;
    @Size(max = 1000)
    @Column(name = "FILE_NAME")
    private String fileName;
    @Size(max = 1000)
    @Column(name = "CONTENT_TYPE")
    private String contentType;
    @Size(max = 1000)
    @Column(name = "FILE_PATH")
    private String filePath;
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
    @Size(min = 1, max = 1000)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CREATION_DATE")
    private String creationDate;
    @Size(max = 1000)
    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;
    @Size(max = 1000)
    @Column(name = "LAST_UPDATED_DATE")
    private String lastUpdatedDate;

    public DroidOqcResource() {
    }

    public DroidOqcResource(String resourceId) {
        this.resourceId = resourceId;
    }

    public DroidOqcResource(String resourceId, String documentHeaderId, String createdBy, String creationDate) {
        this.resourceId = resourceId;
        this.documentHeaderId = documentHeaderId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getDocumentHeaderId() {
        return documentHeaderId;
    }

    public void setDocumentHeaderId(String documentHeaderId) {
        this.documentHeaderId = documentHeaderId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DroidOqcResource)) {
            return false;
        }
        DroidOqcResource other = (DroidOqcResource) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.leedarson.entities.oqc.DroidOqcResource[ resourceId=" + resourceId + " ]";
    }
    
}
