/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "yorumlar_tablo")
@NamedQueries({
    @NamedQuery(name = "YorumlarTablo.findAll", query = "SELECT y FROM YorumlarTablo y"),
    @NamedQuery(name = "YorumlarTablo.findByDbYorumlarID", query = "SELECT y FROM YorumlarTablo y WHERE y.dbYorumlarID = :dbYorumlarID"),
    @NamedQuery(name = "YorumlarTablo.findByDbSiteSarfID", query = "SELECT y FROM YorumlarTablo y WHERE y.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "YorumlarTablo.findByTelekomYorum", query = "SELECT y FROM YorumlarTablo y WHERE y.telekomYorum = :telekomYorum"),
    @NamedQuery(name = "YorumlarTablo.findByTelekomYorumTarihi", query = "SELECT y FROM YorumlarTablo y WHERE y.telekomYorumTarihi = :telekomYorumTarihi"),
    @NamedQuery(name = "YorumlarTablo.findByVendorYorum", query = "SELECT y FROM YorumlarTablo y WHERE y.vendorYorum = :vendorYorum"),
    @NamedQuery(name = "YorumlarTablo.findByVendorYorumTarihi", query = "SELECT y FROM YorumlarTablo y WHERE y.vendorYorumTarihi = :vendorYorumTarihi")})
public class YorumlarTablo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbYorumlarID")
    private Integer dbYorumlarID;
    @Basic(optional = false)
    @JoinColumn(name = "dbSiteSarfID")
    @ManyToOne
    private SiteSarf dbSiteSarfID;
    @Column(name = "telekomYorum")
    private String telekomYorum;
    @Column(name = "telekomYorumTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar telekomYorumTarihi;
    @Column(name = "vendorYorum")
    private String vendorYorum;
    @Column(name = "vendorYorumTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar vendorYorumTarihi;

    public YorumlarTablo() {
    }

    public YorumlarTablo(Integer dbYorumlarID) {
        this.dbYorumlarID = dbYorumlarID;
    }

    public YorumlarTablo(Integer dbYorumlarID, SiteSarf dbSiteSarfID) {
        this.dbYorumlarID = dbYorumlarID;
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Integer getDbYorumlarID() {
        return dbYorumlarID;
    }

    public void setDbYorumlarID(Integer dbYorumlarID) {
        this.dbYorumlarID = dbYorumlarID;
    }

    public SiteSarf getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(SiteSarf dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public String getTelekomYorum() {
        return telekomYorum;
    }

    public void setTelekomYorum(String telekomYorum) {
        this.telekomYorum = telekomYorum;
    }

    public Calendar getTelekomYorumTarihi() {
        return telekomYorumTarihi;
    }

    public void setTelekomYorumTarihi(Calendar telekomYorumTarihi) {
        this.telekomYorumTarihi = telekomYorumTarihi;
    }

    public String getVendorYorum() {
        return vendorYorum;
    }

    public void setVendorYorum(String vendorYorum) {
        this.vendorYorum = vendorYorum;
    }

    public Calendar getVendorYorumTarihi() {
        return vendorYorumTarihi;
    }

    public void setVendorYorumTarihi(Calendar vendorYorumTarihi) {
        this.vendorYorumTarihi = vendorYorumTarihi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbYorumlarID != null ? dbYorumlarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YorumlarTablo)) {
            return false;
        }
        YorumlarTablo other = (YorumlarTablo) object;
        if ((this.dbYorumlarID == null && other.dbYorumlarID != null) || (this.dbYorumlarID != null && !this.dbYorumlarID.equals(other.dbYorumlarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.YorumlarTablo[dbYorumlarID=" + dbYorumlarID + "]";
    }
}
