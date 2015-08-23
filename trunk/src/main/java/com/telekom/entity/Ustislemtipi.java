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
@Table(name = "ustislemtipi")
@NamedQueries({
    @NamedQuery(name = "Ustislemtipi.findAll", query = "SELECT u FROM Ustislemtipi u"),
    @NamedQuery(name = "Ustislemtipi.findByDbUstIslemTipiID", query = "SELECT u FROM Ustislemtipi u WHERE u.dbUstIslemTipiID = :dbUstIslemTipiID"),
    @NamedQuery(name = "Ustislemtipi.findByUstIslemAdi", query = "SELECT u FROM Ustislemtipi u WHERE u.ustIslemAdi = :ustIslemAdi")})
public class Ustislemtipi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbUstIslemTipiID")
    private Integer dbUstIslemTipiID;
    @Column(name = "ustIslemAdi")
    private String ustIslemAdi;

    public Ustislemtipi() {
    }

    public Ustislemtipi(Integer dbUstIslemTipiID) {
        this.dbUstIslemTipiID = dbUstIslemTipiID;
    }

    public Integer getDbUstIslemTipiID() {
        return dbUstIslemTipiID;
    }

    public void setDbUstIslemTipiID(Integer dbUstIslemTipiID) {
        this.dbUstIslemTipiID = dbUstIslemTipiID;
    }

    public String getUstIslemAdi() {
        return ustIslemAdi;
    }

    public void setUstIslemAdi(String ustIslemAdi) {
        this.ustIslemAdi = ustIslemAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbUstIslemTipiID != null ? dbUstIslemTipiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ustislemtipi)) {
            return false;
        }
        Ustislemtipi other = (Ustislemtipi) object;
        if ((this.dbUstIslemTipiID == null && other.dbUstIslemTipiID != null) || (this.dbUstIslemTipiID != null && !this.dbUstIslemTipiID.equals(other.dbUstIslemTipiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.Ustislemtipi[dbUstIslemTipiID=" + dbUstIslemTipiID + "]";
    }

}
