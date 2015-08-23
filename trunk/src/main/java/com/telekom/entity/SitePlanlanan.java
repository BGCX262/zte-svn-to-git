/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.entity;

import com.telekom.enums.EnumBolge;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "site_planlanan")
@NamedQueries({
    @NamedQuery(name = "SitePlanlanan.findAll", query = "SELECT s FROM SitePlanlanan s"),
    @NamedQuery(name = "SitePlanlanan.findByDbSiteID", query = "SELECT s FROM SitePlanlanan s WHERE s.dbSiteID = :dbSiteID"),
    @NamedQuery(name = "SitePlanlanan.findByVendor", query = "SELECT s FROM SitePlanlanan s WHERE s.vendor = :vendor"),
    @NamedQuery(name = "SitePlanlanan.findByBolge", query = "SELECT s FROM SitePlanlanan s WHERE s.bolge = :bolge"),
    @NamedQuery(name = "SitePlanlanan.findByFaz", query = "SELECT s FROM SitePlanlanan s WHERE s.faz = :faz"),
    @NamedQuery(name = "SitePlanlanan.findBySehirID", query = "SELECT s FROM SitePlanlanan s WHERE s.sehirID = :sehirID"),
    @NamedQuery(name = "SitePlanlanan.findByIlceID", query = "SELECT s FROM SitePlanlanan s WHERE s.ilceID = :ilceID"),
    @NamedQuery(name = "SitePlanlanan.findBySahaKodu", query = "SELECT s FROM SitePlanlanan s WHERE s.sahaKodu = :sahaKodu"),
    @NamedQuery(name = "SitePlanlanan.findBySahaAdi", query = "SELECT s FROM SitePlanlanan s WHERE s.sahaAdi = :sahaAdi"),
    @NamedQuery(name = "SitePlanlanan.findBySiparisTarihi", query = "SELECT s FROM SitePlanlanan s WHERE s.siparisTarihi = :siparisTarihi")})
public class SitePlanlanan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbSiteID")
    private Integer dbSiteID;
    @Basic(optional = false)
    @Column(name = "vendor")
    private String vendor;
    @Basic(optional = false)
    @Column(name = "bolge")
    private EnumBolge bolge;
    @Column(name = "faz")
    private String faz;
    @Basic(optional = false)
    @JoinColumn(name = "sehirID")
    @OneToOne
    private SehirlerTablo sehirID;
    @Basic(optional = false)
    @JoinColumn(name = "ilceID")
    @OneToOne
    private IlcelerTablo ilceID;
    @Column(name = "sahaKodu")
    private String sahaKodu;
    @Column(name = "sahaAdi")
    private String sahaAdi;
    @Basic(optional = false)
    @Column(name = "siparisTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar siparisTarihi;

    public SitePlanlanan() {
    }

    public SitePlanlanan(Integer dbSiteID) {
        this.dbSiteID = dbSiteID;
    }

    public SitePlanlanan(Integer dbSiteID, String vendor, EnumBolge bolge, SehirlerTablo sehirID, IlcelerTablo ilceID, Calendar siparisTarihi) {
        this.dbSiteID = dbSiteID;
        this.vendor = vendor;
        this.bolge = bolge;
        this.sehirID = sehirID;
        this.ilceID = ilceID;
        this.siparisTarihi = siparisTarihi;
    }

    public Integer getDbSiteID() {
        return dbSiteID;
    }

    public void setDbSiteID(Integer dbSiteID) {
        this.dbSiteID = dbSiteID;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public EnumBolge getBolge() {
        return bolge;
    }

    public void setBolge(EnumBolge bolge) {
        this.bolge = bolge;
    }

    public String getFaz() {
        return faz;
    }

    public void setFaz(String faz) {
        this.faz = faz;
    }

    public IlcelerTablo getIlceID() {
        return ilceID;
    }

    public void setIlceID(IlcelerTablo ilceID) {
        this.ilceID = ilceID;
    }

    public SehirlerTablo getSehirID() {
        return sehirID;
    }

    public void setSehirID(SehirlerTablo sehirID) {
        this.sehirID = sehirID;
    }


    public String getSahaKodu() {
        return sahaKodu;
    }

    public void setSahaKodu(String sahaKodu) {
        this.sahaKodu = sahaKodu;
    }

    public String getSahaAdi() {
        return sahaAdi;
    }

    public void setSahaAdi(String sahaAdi) {
        this.sahaAdi = sahaAdi;
    }

    public Calendar getSiparisTarihi() {
        return siparisTarihi;
    }

    public void setSiparisTarihi(Calendar siparisTarihi) {
        this.siparisTarihi = siparisTarihi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbSiteID != null ? dbSiteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SitePlanlanan)) {
            return false;
        }
        SitePlanlanan other = (SitePlanlanan) object;
        if ((this.dbSiteID == null && other.dbSiteID != null) || (this.dbSiteID != null && !this.dbSiteID.equals(other.dbSiteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.SitePlanlanan[dbSiteID=" + dbSiteID + "]";
    }

}
