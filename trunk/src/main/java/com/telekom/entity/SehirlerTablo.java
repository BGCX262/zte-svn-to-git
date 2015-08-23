/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.telekom.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "sehirler_tablo")
@NamedQueries({
    @NamedQuery(name = "SehirlerTablo.findAll", query = "SELECT s FROM SehirlerTablo s"),
    @NamedQuery(name = "SehirlerTablo.findByDbSehirID", query = "SELECT s FROM SehirlerTablo s WHERE s.dbSehirID = :dbSehirID"),
    @NamedQuery(name = "SehirlerTablo.findBySehir", query = "SELECT s FROM SehirlerTablo s WHERE s.sehir = :sehir")})
public class SehirlerTablo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbSehirID")
    private Integer dbSehirID;
    @Basic(optional = false)
    @Column(name = "Sehir")
    private String sehir;

    public SehirlerTablo() {
    }

    public SehirlerTablo(Integer dbSehirID) {
        this.dbSehirID = dbSehirID;
    }

    public SehirlerTablo(Integer dbSehirID, String sehir) {
        this.dbSehirID = dbSehirID;
        this.sehir = sehir;
    }

    public Integer getDbSehirID() {
        return dbSehirID;
    }

    public void setDbSehirID(Integer dbSehirID) {
        this.dbSehirID = dbSehirID;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbSehirID != null ? dbSehirID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SehirlerTablo)) {
            return false;
        }
        SehirlerTablo other = (SehirlerTablo) object;
        if ((this.dbSehirID == null && other.dbSehirID != null) || (this.dbSehirID != null && !this.dbSehirID.equals(other.dbSehirID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.SehirlerTablo[dbSehirID=" + dbSehirID + "]";
    }

}
