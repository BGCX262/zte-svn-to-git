/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.entity;

import com.telekom.enums.EnumIsDurum;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "yapilanisler")
@NamedQueries({
    @NamedQuery(name = "Yapilanisler.findAll", query = "SELECT y FROM Yapilanisler y"),
    @NamedQuery(name = "Yapilanisler.findByDbYapilanIslerID", query = "SELECT y FROM Yapilanisler y WHERE y.dbYapilanIslerID = :dbYapilanIslerID"),
    @NamedQuery(name = "Yapilanisler.findByDbSiteSarfID", query = "SELECT y FROM Yapilanisler y WHERE y.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "Yapilanisler.findByDbUstIslemTipiID", query = "SELECT y FROM Yapilanisler y WHERE y.dbUstIslemTipiID = :dbUstIslemTipiID"),
    @NamedQuery(name = "Yapilanisler.findByDbAltIslemTipiID", query = "SELECT y FROM Yapilanisler y WHERE y.dbAltIslemTipiID = :dbAltIslemTipiID"),
    @NamedQuery(name = "Yapilanisler.findByPlanlananBaslamaTarihi", query = "SELECT y FROM Yapilanisler y WHERE y.planlananBaslamaTarihi = :planlananBaslamaTarihi"),
    @NamedQuery(name = "Yapilanisler.findByPlanlananBitisTarihi", query = "SELECT y FROM Yapilanisler y WHERE y.planlananBitisTarihi = :planlananBitisTarihi"),
    @NamedQuery(name = "Yapilanisler.findByGerceklesenBaslamaTarihi", query = "SELECT y FROM Yapilanisler y WHERE y.gerceklesenBaslamaTarihi = :gerceklesenBaslamaTarihi"),
    @NamedQuery(name = "Yapilanisler.findByGerceklesenBitisTarihi", query = "SELECT y FROM Yapilanisler y WHERE y.gerceklesenBitisTarihi = :gerceklesenBitisTarihi"),
    @NamedQuery(name = "Yapilanisler.findByIsDurum", query = "SELECT y FROM Yapilanisler y WHERE y.isDurum = :isDurum"),
    @NamedQuery(name = "Yapilanisler.findByTaseronBilgileri", query = "SELECT y FROM Yapilanisler y WHERE y.taseronBilgileri = :taseronBilgileri"),
    @NamedQuery(name = "Yapilanisler.findByTaseronIletisimBilgileri", query = "SELECT y FROM Yapilanisler y WHERE y.taseronIletisimBilgileri = :taseronIletisimBilgileri"),
    @NamedQuery(name = "Yapilanisler.findByAciklama", query = "SELECT y FROM Yapilanisler y WHERE y.aciklama = :aciklama")})
public class Yapilanisler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbYapilanIslerID")
    private Integer dbYapilanIslerID;
    @Basic(optional = false)
    @JoinColumn(name = "dbSiteSarfID")
    @ManyToOne
    private SiteSarf dbSiteSarfID;
    @Basic(optional = false)
    @JoinColumn(name = "dbUstIslemTipiID")
    @OneToOne
    private Ustislemtipi dbUstIslemTipiID;
    @Basic(optional = false)
    @JoinColumn(name = "dbAltIslemTipiID")
    @OneToOne
    private Altislemtipi dbAltIslemTipiID;
    @Column(name = "planlananBaslamaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar planlananBaslamaTarihi;
    @Column(name = "planlananBitisTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar planlananBitisTarihi;
    @Column(name = "gerceklesenBaslamaTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar gerceklesenBaslamaTarihi;
    @Column(name = "gerceklesenBitisTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar gerceklesenBitisTarihi;
    @Column(name = "isDurum")
    private String isDurum;
    @Column(name = "taseronBilgileri")
    private String taseronBilgileri;
    @Column(name = "taseronIletisimBilgileri")
    private String taseronIletisimBilgileri;
    @Column(name = "aciklama")
    private String aciklama;

    public Yapilanisler() {
    }

    public Yapilanisler(Integer dbYapilanIslerID) {
        this.dbYapilanIslerID = dbYapilanIslerID;
    }

    public Yapilanisler(Integer dbYapilanIslerID, SiteSarf dbSiteSarfID, Ustislemtipi dbUstIslemTipiID, Altislemtipi dbAltIslemTipiID) {
        this.dbYapilanIslerID = dbYapilanIslerID;
        this.dbSiteSarfID = dbSiteSarfID;
        this.dbUstIslemTipiID = dbUstIslemTipiID;
        this.dbAltIslemTipiID = dbAltIslemTipiID;
    }

    public Integer getDbYapilanIslerID() {
        return dbYapilanIslerID;
    }

    public void setDbYapilanIslerID(Integer dbYapilanIslerID) {
        this.dbYapilanIslerID = dbYapilanIslerID;
    }

    public Altislemtipi getDbAltIslemTipiID() {
        return dbAltIslemTipiID;
    }

    public void setDbAltIslemTipiID(Altislemtipi dbAltIslemTipiID) {
        this.dbAltIslemTipiID = dbAltIslemTipiID;
    }

    public SiteSarf getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(SiteSarf dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Ustislemtipi getDbUstIslemTipiID() {
        return dbUstIslemTipiID;
    }

    public void setDbUstIslemTipiID(Ustislemtipi dbUstIslemTipiID) {
        this.dbUstIslemTipiID = dbUstIslemTipiID;
    }

    public Calendar getPlanlananBaslamaTarihi() {
        return planlananBaslamaTarihi;
    }

    public void setPlanlananBaslamaTarihi(Calendar planlananBaslamaTarihi) {
        this.planlananBaslamaTarihi = planlananBaslamaTarihi;
    }

    public String getIsDurum() {
        return isDurum;
    }

    public void setIsDurum(String isDurum) {
        this.isDurum = isDurum;
    }

    public Calendar getPlanlananBitisTarihi() {
        return planlananBitisTarihi;
    }

    public void setPlanlananBitisTarihi(Calendar planlananBitisTarihi) {
        this.planlananBitisTarihi = planlananBitisTarihi;
    }

    public Calendar getGerceklesenBaslamaTarihi() {
        return gerceklesenBaslamaTarihi;
    }

    public void setGerceklesenBaslamaTarihi(Calendar gerceklesenBaslamaTarihi) {
        this.gerceklesenBaslamaTarihi = gerceklesenBaslamaTarihi;
    }

    public Calendar getGerceklesenBitisTarihi() {
        return gerceklesenBitisTarihi;
    }

    public void setGerceklesenBitisTarihi(Calendar gerceklesenBitisTarihi) {
        this.gerceklesenBitisTarihi = gerceklesenBitisTarihi;
    }

    public String getTaseronBilgileri() {
        return taseronBilgileri;
    }

    public void setTaseronBilgileri(String taseronBilgileri) {
        this.taseronBilgileri = taseronBilgileri;
    }

    public String getTaseronIletisimBilgileri() {
        return taseronIletisimBilgileri;
    }

    public void setTaseronIletisimBilgileri(String taseronIletisimBilgileri) {
        this.taseronIletisimBilgileri = taseronIletisimBilgileri;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbYapilanIslerID != null ? dbYapilanIslerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yapilanisler)) {
            return false;
        }
        Yapilanisler other = (Yapilanisler) object;
        if ((this.dbYapilanIslerID == null && other.dbYapilanIslerID != null) || (this.dbYapilanIslerID != null && !this.dbYapilanIslerID.equals(other.dbYapilanIslerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.Yapilanisler[dbYapilanIslerID=" + dbYapilanIslerID + "]";
    }

}
