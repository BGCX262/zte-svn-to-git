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
@Table(name = "tss_form")
@NamedQueries({
    @NamedQuery(name = "TssForm.findAll", query = "SELECT t FROM TssForm t"),
    @NamedQuery(name = "TssForm.findByDbTSSRID", query = "SELECT t FROM TssForm t WHERE t.dbTSSRID = :dbTSSRID"),
    @NamedQuery(name = "TssForm.findByDbSiteSarfID", query = "SELECT t FROM TssForm t WHERE t.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "TssForm.findByTssTarihi", query = "SELECT t FROM TssForm t WHERE t.tssTarihi = :tssTarihi"),
    @NamedQuery(name = "TssForm.findByTssTeslimTarihi", query = "SELECT t FROM TssForm t WHERE t.tssTeslimTarihi = :tssTeslimTarihi"),
    @NamedQuery(name = "TssForm.findByTssDokumanDosyaAdi", query = "SELECT t FROM TssForm t WHERE t.tssDokumanDosyaAdi = :tssDokumanDosyaAdi"),
    @NamedQuery(name = "TssForm.findByTssDokumanDosyaYolu", query = "SELECT t FROM TssForm t WHERE t.tssDokumanDosyaYolu = :tssDokumanDosyaYolu"),
    @NamedQuery(name = "TssForm.findByTssOnayDurumu", query = "SELECT t FROM TssForm t WHERE t.tssOnayDurumu = :tssOnayDurumu"),
    @NamedQuery(name = "TssForm.findByTssOnayYorum", query = "SELECT t FROM TssForm t WHERE t.tssOnayYorum = :tssOnayYorum"),
    @NamedQuery(name = "TssForm.findByTssTelekomOnayTarihi", query = "SELECT t FROM TssForm t WHERE t.tssTelekomOnayTarihi = :tssTelekomOnayTarihi"),
    @NamedQuery(name = "TssForm.findByBtkBasvuruTarihi", query = "SELECT t FROM TssForm t WHERE t.btkBasvuruTarihi = :btkBasvuruTarihi"),
    @NamedQuery(name = "TssForm.findByBtkSertifikaTarihi", query = "SELECT t FROM TssForm t WHERE t.btkSertifikaTarihi = :btkSertifikaTarihi")})
public class TssForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbTSSR_ID")
    private Integer dbTSSRID;
    @Basic(optional = false)
    @JoinColumn(name="dbSiteSarfID")
    @ManyToOne
    private SiteSarf dbSiteSarfID;
    @Column(name = "tssTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar tssTarihi;
    @Column(name = "tssTeslimTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar tssTeslimTarihi;
    @Column(name = "tssDokumanDosyaAdi")
    private String tssDokumanDosyaAdi;
    @Column(name = "tssDokumanDosyaYolu")
    private String tssDokumanDosyaYolu;
    @Column(name = "tssOnayDurumu")
    private String tssOnayDurumu;
    @Column(name = "tssOnayYorum")
    private String tssOnayYorum;
    @Column(name = "tssTelekomOnayTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar tssTelekomOnayTarihi;
    @Column(name = "btkBasvuruTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar btkBasvuruTarihi;
    @Column(name = "btkSertifikaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar btkSertifikaTarihi;

    public TssForm() {
    }

    public TssForm(Integer dbTSSRID) {
        this.dbTSSRID = dbTSSRID;
    }

    public TssForm(Integer dbTSSRID, SiteSarf dbSiteSarfID) {
        this.dbTSSRID = dbTSSRID;
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Integer getDbTSSRID() {
        return dbTSSRID;
    }

    public void setDbTSSRID(Integer dbTSSRID) {
        this.dbTSSRID = dbTSSRID;
    }

    public SiteSarf getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(SiteSarf dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Calendar getTssTarihi() {
        return tssTarihi;
    }

    public void setTssTarihi(Calendar tssTarihi) {
        this.tssTarihi = tssTarihi;
    }

    public Calendar getTssTeslimTarihi() {
        return tssTeslimTarihi;
    }

    public void setTssTeslimTarihi(Calendar tssTeslimTarihi) {
        this.tssTeslimTarihi = tssTeslimTarihi;
    }

    public String getTssDokumanDosyaAdi() {
        return tssDokumanDosyaAdi;
    }

    public void setTssDokumanDosyaAdi(String tssDokumanDosyaAdi) {
        this.tssDokumanDosyaAdi = tssDokumanDosyaAdi;
    }

    public String getTssDokumanDosyaYolu() {
        return tssDokumanDosyaYolu;
    }

    public void setTssDokumanDosyaYolu(String tssDokumanDosyaYolu) {
        this.tssDokumanDosyaYolu = tssDokumanDosyaYolu;
    }

    public String getTssOnayDurumu() {
        return tssOnayDurumu;
    }

    public void setTssOnayDurumu(String tssOnayDurumu) {
        this.tssOnayDurumu = tssOnayDurumu;
    }
  
    public String getTssOnayYorum() {
        return tssOnayYorum;
    }

    public void setTssOnayYorum(String tssOnayYorum) {
        this.tssOnayYorum = tssOnayYorum;
    }

    public Calendar getTssTelekomOnayTarihi() {
        return tssTelekomOnayTarihi;
    }

    public void setTssTelekomOnayTarihi(Calendar tssTelekomOnayTarihi) {
        this.tssTelekomOnayTarihi = tssTelekomOnayTarihi;
    }

    public Calendar getBtkBasvuruTarihi() {
        return btkBasvuruTarihi;
    }

    public void setBtkBasvuruTarihi(Calendar btkBasvuruTarihi) {
        this.btkBasvuruTarihi = btkBasvuruTarihi;
    }

    public Calendar getBtkSertifikaTarihi() {
        return btkSertifikaTarihi;
    }

    public void setBtkSertifikaTarihi(Calendar btkSertifikaTarihi) {
        this.btkSertifikaTarihi = btkSertifikaTarihi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbTSSRID != null ? dbTSSRID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TssForm)) {
            return false;
        }
        TssForm other = (TssForm) object;
        if ((this.dbTSSRID == null && other.dbTSSRID != null) || (this.dbTSSRID != null && !this.dbTSSRID.equals(other.dbTSSRID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.TssForm[dbTSSRID=" + dbTSSRID + "]";
    }

}
