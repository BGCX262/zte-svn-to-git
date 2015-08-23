/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.entity;

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
@Table(name = "kiralama_tablo")
@NamedQueries({
    @NamedQuery(name = "KiralamaTablo.findAll", query = "SELECT k FROM KiralamaTablo k"),
    @NamedQuery(name = "KiralamaTablo.findByDbSAID", query = "SELECT k FROM KiralamaTablo k WHERE k.dbSAID = :dbSAID"),
    @NamedQuery(name = "KiralamaTablo.findByDbSiteSarfID", query = "SELECT k FROM KiralamaTablo k WHERE k.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "KiralamaTablo.findByAlanTuru", query = "SELECT k FROM KiralamaTablo k WHERE k.alanTuru = :alanTuru"),
    @NamedQuery(name = "KiralamaTablo.findByMalSahibi", query = "SELECT k FROM KiralamaTablo k WHERE k.malSahibi = :malSahibi"),
    @NamedQuery(name = "KiralamaTablo.findByContactName", query = "SELECT k FROM KiralamaTablo k WHERE k.contactName = :contactName"),
    @NamedQuery(name = "KiralamaTablo.findByContactTelefon", query = "SELECT k FROM KiralamaTablo k WHERE k.contactTelefon = :contactTelefon"),
    @NamedQuery(name = "KiralamaTablo.findByIletisimAdresi", query = "SELECT k FROM KiralamaTablo k WHERE k.iletisimAdresi = :iletisimAdresi"),
    @NamedQuery(name = "KiralamaTablo.findByKayitTarihi", query = "SELECT k FROM KiralamaTablo k WHERE k.kayitTarihi = :kayitTarihi"),
    @NamedQuery(name = "KiralamaTablo.findByKiralamaDurum", query = "SELECT k FROM KiralamaTablo k WHERE k.kiralamaDurum = :kiralamaDurum"),
    @NamedQuery(name = "KiralamaTablo.findByKontratImzaTarihi", query = "SELECT k FROM KiralamaTablo k WHERE k.kontratImzaTarihi = :kontratImzaTarihi"),
    @NamedQuery(name = "KiralamaTablo.findBySATaseron", query = "SELECT k FROM KiralamaTablo k WHERE k.sATaseron = :sATaseron")})
public class KiralamaTablo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbSA_ID")
    private Integer dbSAID;
    @Basic(optional = false)
    @JoinColumn(name = "dbSiteSarfID")
    @ManyToOne
    private SiteSarf dbSiteSarfID;
    @Column(name = "alanTuru")
    private String alanTuru;
    @Column(name = "malSahibi")
    private String malSahibi;
    @Column(name = "contactName")
    private String contactName;
    @Column(name = "contactTelefon")
    private String contactTelefon;
    @Column(name = "iletisimAdresi")
    private String iletisimAdresi;
    @Column(name = "kayitTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar kayitTarihi;
    @Column(name = "kiralamaDurum")
    private String kiralamaDurum;
    @Column(name = "kontratImzaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar kontratImzaTarihi;
    @Column(name = "SATaseron")
    private String sATaseron;

    public KiralamaTablo() {
    }

    public KiralamaTablo(Integer dbSAID) {
        this.dbSAID = dbSAID;
    }

    public KiralamaTablo(Integer dbSAID, SiteSarf dbSiteSarfID) {
        this.dbSAID = dbSAID;
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Integer getDbSAID() {
        return dbSAID;
    }

    public void setDbSAID(Integer dbSAID) {
        this.dbSAID = dbSAID;
    }

    public SiteSarf getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(SiteSarf dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public String getsATaseron() {
        return sATaseron;
    }

    public void setsATaseron(String sATaseron) {
        this.sATaseron = sATaseron;
    }

    public String getAlanTuru() {
        return alanTuru;
    }

    public void setAlanTuru(String alanTuru) {
        this.alanTuru = alanTuru;
    }

    public String getMalSahibi() {
        return malSahibi;
    }

    public void setMalSahibi(String malSahibi) {
        this.malSahibi = malSahibi;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelefon() {
        return contactTelefon;
    }

    public void setContactTelefon(String contactTelefon) {
        this.contactTelefon = contactTelefon;
    }

    public String getIletisimAdresi() {
        return iletisimAdresi;
    }

    public void setIletisimAdresi(String iletisimAdresi) {
        this.iletisimAdresi = iletisimAdresi;
    }

    public String getKiralamaDurum() {
        return kiralamaDurum;
    }

    public void setKiralamaDurum(String kiralamaDurum) {
        this.kiralamaDurum = kiralamaDurum;
    }

    public String getSATaseron() {
        return sATaseron;
    }

    public void setSATaseron(String sATaseron) {
        this.sATaseron = sATaseron;
    }

    public Calendar getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Calendar kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Calendar getKontratImzaTarihi() {
        return kontratImzaTarihi;
    }

    public void setKontratImzaTarihi(Calendar kontratImzaTarihi) {
        this.kontratImzaTarihi = kontratImzaTarihi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbSAID != null ? dbSAID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KiralamaTablo)) {
            return false;
        }
        KiralamaTablo other = (KiralamaTablo) object;
        if ((this.dbSAID == null && other.dbSAID != null) || (this.dbSAID != null && !this.dbSAID.equals(other.dbSAID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.KiralamaTablo[dbSAID=" + dbSAID + "]";
    }
}
