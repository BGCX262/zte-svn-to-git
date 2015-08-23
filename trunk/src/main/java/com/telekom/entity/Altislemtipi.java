/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "altislemtipi")
@NamedQueries({
    @NamedQuery(name = "Altislemtipi.findAll", query = "SELECT a FROM Altislemtipi a"),
    @NamedQuery(name = "Altislemtipi.findByDbAltIslemTipiID", query = "SELECT a FROM Altislemtipi a WHERE a.dbAltIslemTipiID = :dbAltIslemTipiID"),
    @NamedQuery(name = "Altislemtipi.findByDbUstIslemTipiID", query = "SELECT a FROM Altislemtipi a WHERE a.dbUstIslemTipiID = :dbUstIslemTipiID"),
    @NamedQuery(name = "Altislemtipi.findByAltIslemAdi", query = "SELECT a FROM Altislemtipi a WHERE a.altIslemAdi = :altIslemAdi"),
    @NamedQuery(name = "Altislemtipi.findByAciklama", query = "SELECT a FROM Altislemtipi a WHERE a.aciklama = :aciklama")})
public class Altislemtipi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbAltIslemTipiID")
    private Integer dbAltIslemTipiID;
    @Basic(optional = false)
    @Column(name = "dbUstIslemTipiID")
    private int dbUstIslemTipiID;
    @Basic(optional = false)
    @Column(name = "altIslemAdi")
    private String altIslemAdi;
    @Column(name = "aciklama")
    private String aciklama;

    public Altislemtipi() {
    }

    public Altislemtipi(Integer dbAltIslemTipiID) {
        this.dbAltIslemTipiID = dbAltIslemTipiID;
    }

    public Altislemtipi(Integer dbAltIslemTipiID, int dbUstIslemTipiID, String altIslemAdi) {
        this.dbAltIslemTipiID = dbAltIslemTipiID;
        this.dbUstIslemTipiID = dbUstIslemTipiID;
        this.altIslemAdi = altIslemAdi;
    }

    public Integer getDbAltIslemTipiID() {
        return dbAltIslemTipiID;
    }

    public void setDbAltIslemTipiID(Integer dbAltIslemTipiID) {
        this.dbAltIslemTipiID = dbAltIslemTipiID;
    }

    public int getDbUstIslemTipiID() {
        return dbUstIslemTipiID;
    }

    public void setDbUstIslemTipiID(int dbUstIslemTipiID) {
        this.dbUstIslemTipiID = dbUstIslemTipiID;
    }

    public String getAltIslemAdi() {
        return altIslemAdi;
    }

    public void setAltIslemAdi(String altIslemAdi) {
        this.altIslemAdi = altIslemAdi;
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
        hash += (dbAltIslemTipiID != null ? dbAltIslemTipiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Altislemtipi)) {
            return false;
        }
        Altislemtipi other = (Altislemtipi) object;
        if ((this.dbAltIslemTipiID == null && other.dbAltIslemTipiID != null) || (this.dbAltIslemTipiID != null && !this.dbAltIslemTipiID.equals(other.dbAltIslemTipiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.Altislemtipi[dbAltIslemTipiID=" + dbAltIslemTipiID + "]";
    }

}
