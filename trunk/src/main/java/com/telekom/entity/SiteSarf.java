/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.entity;

import com.telekom.enums.EnumEnerjiTipi;
import com.telekom.enums.EnumOnayDurum;
import com.telekom.enums.EnumTransmisyonYontemi;
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
@Table(name = "site_sarf")
@NamedQueries({
    @NamedQuery(name = "SiteSarf.findAll", query = "SELECT s FROM SiteSarf s"),
    @NamedQuery(name = "SiteSarf.findByDbSiteSarfID", query = "SELECT s FROM SiteSarf s WHERE s.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "SiteSarf.findByDbSiteID", query = "SELECT s FROM SiteSarf s WHERE s.dbSiteID = :dbSiteID"),
    @NamedQuery(name = "SiteSarf.findByAdayNo", query = "SELECT s FROM SiteSarf s WHERE s.adayNo = :adayNo"),
    @NamedQuery(name = "SiteSarf.findBySahaKoduAdayNo", query = "SELECT s FROM SiteSarf s WHERE s.sahaKoduAdayNo = :sahaKoduAdayNo"),
    @NamedQuery(name = "SiteSarf.findByHazirlanmaTarihi", query = "SELECT s FROM SiteSarf s WHERE s.hazirlanmaTarihi = :hazirlanmaTarihi"),
    @NamedQuery(name = "SiteSarf.findBySunulmaTarihi", query = "SELECT s FROM SiteSarf s WHERE s.sunulmaTarihi = :sunulmaTarihi"),
    @NamedQuery(name = "SiteSarf.findByOnayDurum", query = "SELECT s FROM SiteSarf s WHERE s.onayDurum = :onayDurum"),
    @NamedQuery(name = "SiteSarf.findByOnayTarihi", query = "SELECT s FROM SiteSarf s WHERE s.onayTarihi = :onayTarihi"),
    @NamedQuery(name = "SiteSarf.findByIsColocated", query = "SELECT s FROM SiteSarf s WHERE s.isColocated = :isColocated"),
    @NamedQuery(name = "SiteSarf.findByColocatedOwner", query = "SELECT s FROM SiteSarf s WHERE s.colocatedOwner = :colocatedOwner"),
    @NamedQuery(name = "SiteSarf.findByMucbirSebepBaslangicTarihi", query = "SELECT s FROM SiteSarf s WHERE s.mucbirSebepBaslangicTarihi = :mucbirSebepBaslangicTarihi"),
    @NamedQuery(name = "SiteSarf.findByMucbirSebepBitisTarihi", query = "SELECT s FROM SiteSarf s WHERE s.mucbirSebepBitisTarihi = :mucbirSebepBitisTarihi"),
    @NamedQuery(name = "SiteSarf.findByKuleYukseklik", query = "SELECT s FROM SiteSarf s WHERE s.kuleYukseklik = :kuleYukseklik"),
    @NamedQuery(name = "SiteSarf.findByEnlem", query = "SELECT s FROM SiteSarf s WHERE s.enlem = :enlem"),
    @NamedQuery(name = "SiteSarf.findByBoylam", query = "SELECT s FROM SiteSarf s WHERE s.boylam = :boylam"),
    @NamedQuery(name = "SiteSarf.findBySahaSonDurumu", query = "SELECT s FROM SiteSarf s WHERE s.sahaSonDurumu = :sahaSonDurumu"),
    @NamedQuery(name = "SiteSarf.findByTransmisyonYolu", query = "SELECT s FROM SiteSarf s WHERE s.transmisyonYolu = :transmisyonYolu"),
    @NamedQuery(name = "SiteSarf.findByTransmisyonYontemi", query = "SELECT s FROM SiteSarf s WHERE s.transmisyonYontemi = :transmisyonYontemi"),
    @NamedQuery(name = "SiteSarf.findByDetayliSahaTipi", query = "SELECT s FROM SiteSarf s WHERE s.detayliSahaTipi = :detayliSahaTipi"),
    @NamedQuery(name = "SiteSarf.findByEnerjiTipi", query = "SELECT s FROM SiteSarf s WHERE s.enerjiTipi = :enerjiTipi"),
    @NamedQuery(name = "SiteSarf.findBySarfDokumanDosyaAdi", query = "SELECT s FROM SiteSarf s WHERE s.sarfDokumanDosyaAdi = :sarfDokumanDosyaAdi"),
    @NamedQuery(name = "SiteSarf.findBySarfDokumanDosyaYolu", query = "SELECT s FROM SiteSarf s WHERE s.sarfDokumanDosyaYolu = :sarfDokumanDosyaYolu")})
public class SiteSarf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbSiteSarfID")
    private Integer dbSiteSarfID;
    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name="dbSiteID")
    private SitePlanlanan dbSiteID;
    @Basic(optional = false)
    @Column(name = "adayNo")
    private int adayNo;
    @Column(name = "sahaKoduAdayNo")
    private String sahaKoduAdayNo;
    @Basic(optional = false)
    @Column(name = "hazirlanmaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar hazirlanmaTarihi;
    @Column(name = "sunulmaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar sunulmaTarihi;
    @Column(name = "onayDurum")
    private EnumOnayDurum onayDurum;
    @Column(name = "onayTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar onayTarihi;
    @Column(name = "isColocated")
    private Boolean isColocated;
    @Column(name = "colocatedOwner")
    private String colocatedOwner;
    @Column(name = "mucbirSebepBaslangicTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar mucbirSebepBaslangicTarihi;
    @Column(name = "mucbirSebepBitisTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar mucbirSebepBitisTarihi;
    @Column(name = "kuleYukseklik")
    private Integer kuleYukseklik;
    @Column(name = "enlem")
    private String enlem;
    @Column(name = "boylam")
    private String boylam;
    @Column(name = "sahaSonDurumu")
    private String sahaSonDurumu;
    @Column(name = "transmisyonYolu")
    private String transmisyonYolu;
    @Column(name = "transmisyonYontemi")
    private EnumTransmisyonYontemi transmisyonYontemi;
    @Column(name = "detayliSahaTipi")
    private String detayliSahaTipi;
    @Column(name = "enerjiTipi")
    private EnumEnerjiTipi enerjiTipi;
    @Column(name = "sarfDokumanDosyaAdi")
    private String sarfDokumanDosyaAdi;
    @Column(name = "sarfDokumanDosyaYolu")
    private String sarfDokumanDosyaYolu;

    public SiteSarf() {
    }

    public SiteSarf(Integer dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public SiteSarf(Integer dbSiteSarfID, SitePlanlanan dbSiteID, int adayNo, Calendar hazirlanmaTarihi) {
        this.dbSiteSarfID = dbSiteSarfID;
        this.dbSiteID = dbSiteID;
        this.adayNo = adayNo;
        this.hazirlanmaTarihi = hazirlanmaTarihi;
    }

    public Integer getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(Integer dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public SitePlanlanan getDbSiteID() {
        return dbSiteID;
    }

    public void setDbSiteID(SitePlanlanan dbSiteID) {
        this.dbSiteID = dbSiteID;
    }

    public int getAdayNo() {
        return adayNo;
    }

    public void setAdayNo(int adayNo) {
        this.adayNo = adayNo;
    }

    public String getSahaKoduAdayNo() {
        return sahaKoduAdayNo;
    }

    public void setSahaKoduAdayNo(String sahaKoduAdayNo) {
        this.sahaKoduAdayNo = sahaKoduAdayNo;
    }

    public Calendar getHazirlanmaTarihi() {
        return hazirlanmaTarihi;
    }

    public void setHazirlanmaTarihi(Calendar hazirlanmaTarihi) {
        this.hazirlanmaTarihi = hazirlanmaTarihi;
    }

    public Calendar getSunulmaTarihi() {
        return sunulmaTarihi;
    }

    public void setSunulmaTarihi(Calendar sunulmaTarihi) {
        this.sunulmaTarihi = sunulmaTarihi;
    }

    public EnumOnayDurum getOnayDurum() {
        return onayDurum;
    }

    public void setOnayDurum(EnumOnayDurum onayDurum) {
        this.onayDurum = onayDurum;
    }

    public Calendar getOnayTarihi() {
        return onayTarihi;
    }

    public void setOnayTarihi(Calendar onayTarihi) {
        this.onayTarihi = onayTarihi;
    }

    public EnumEnerjiTipi getEnerjiTipi() {
        return enerjiTipi;
    }

    public void setEnerjiTipi(EnumEnerjiTipi enerjiTipi) {
        this.enerjiTipi = enerjiTipi;
    }

    public Boolean getIsColocated() {
        return isColocated;
    }

    public void setIsColocated(Boolean isColocated) {
        this.isColocated = isColocated;
    }

    public EnumTransmisyonYontemi getTransmisyonYontemi() {
        return transmisyonYontemi;
    }

    public void setTransmisyonYontemi(EnumTransmisyonYontemi transmisyonYontemi) {
        this.transmisyonYontemi = transmisyonYontemi;
    }

    public String getColocatedOwner() {
        return colocatedOwner;
    }

    public void setColocatedOwner(String colocatedOwner) {
        this.colocatedOwner = colocatedOwner;
    }

    public Calendar getMucbirSebepBaslangicTarihi() {
        return mucbirSebepBaslangicTarihi;
    }

    public void setMucbirSebepBaslangicTarihi(Calendar mucbirSebepBaslangicTarihi) {
        this.mucbirSebepBaslangicTarihi = mucbirSebepBaslangicTarihi;
    }

    public Calendar getMucbirSebepBitisTarihi() {
        return mucbirSebepBitisTarihi;
    }

    public void setMucbirSebepBitisTarihi(Calendar mucbirSebepBitisTarihi) {
        this.mucbirSebepBitisTarihi = mucbirSebepBitisTarihi;
    }

    public Integer getKuleYukseklik() {
        return kuleYukseklik;
    }

    public void setKuleYukseklik(Integer kuleYukseklik) {
        this.kuleYukseklik = kuleYukseklik;
    }

    public String getEnlem() {
        return enlem;
    }

    public void setEnlem(String enlem) {
        this.enlem = enlem;
    }

    public String getBoylam() {
        return boylam;
    }

    public void setBoylam(String boylam) {
        this.boylam = boylam;
    }

    public String getSahaSonDurumu() {
        return sahaSonDurumu;
    }

    public void setSahaSonDurumu(String sahaSonDurumu) {
        this.sahaSonDurumu = sahaSonDurumu;
    }

    public String getTransmisyonYolu() {
        return transmisyonYolu;
    }

    public void setTransmisyonYolu(String transmisyonYolu) {
        this.transmisyonYolu = transmisyonYolu;
    }

    public String getDetayliSahaTipi() {
        return detayliSahaTipi;
    }

    public void setDetayliSahaTipi(String detayliSahaTipi) {
        this.detayliSahaTipi = detayliSahaTipi;
    }

    public String getSarfDokumanDosyaAdi() {
        return sarfDokumanDosyaAdi;
    }

    public void setSarfDokumanDosyaAdi(String sarfDokumanDosyaAdi) {
        this.sarfDokumanDosyaAdi = sarfDokumanDosyaAdi;
    }

    public String getSarfDokumanDosyaYolu() {
        return sarfDokumanDosyaYolu;
    }

    public void setSarfDokumanDosyaYolu(String sarfDokumanDosyaYolu) {
        this.sarfDokumanDosyaYolu = sarfDokumanDosyaYolu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbSiteSarfID != null ? dbSiteSarfID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteSarf)) {
            return false;
        }
        SiteSarf other = (SiteSarf) object;
        if ((this.dbSiteSarfID == null && other.dbSiteSarfID != null) || (this.dbSiteSarfID != null && !this.dbSiteSarfID.equals(other.dbSiteSarfID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.SiteSarf[dbSiteSarfID=" + dbSiteSarfID + "]";
    }

}
