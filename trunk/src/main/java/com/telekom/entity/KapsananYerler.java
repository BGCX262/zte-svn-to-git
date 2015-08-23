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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "kapsanan_yerler")
@NamedQueries({
    @NamedQuery(name = "KapsananYerler.findAll", query = "SELECT k FROM KapsananYerler k"),
    @NamedQuery(name = "KapsananYerler.findByDbKapsananYerlerID", query = "SELECT k FROM KapsananYerler k WHERE k.dbKapsananYerlerID = :dbKapsananYerlerID"),
    @NamedQuery(name = "KapsananYerler.findByDbSiteSarfID", query = "SELECT k FROM KapsananYerler k WHERE k.dbSiteSarfID = :dbSiteSarfID"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi1", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi1 = :yerlesimAdi1"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi2", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi2 = :yerlesimAdi2"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi3", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi3 = :yerlesimAdi3"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi4", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi4 = :yerlesimAdi4"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi5", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi5 = :yerlesimAdi5"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi6", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi6 = :yerlesimAdi6"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi7", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi7 = :yerlesimAdi7"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi8", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi8 = :yerlesimAdi8"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi9", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi9 = :yerlesimAdi9"),
    @NamedQuery(name = "KapsananYerler.findByYerlesimAdi10", query = "SELECT k FROM KapsananYerler k WHERE k.yerlesimAdi10 = :yerlesimAdi10")})
public class KapsananYerler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dbKapsananYerlerID")
    private Integer dbKapsananYerlerID;
    @Basic(optional = false)
    @JoinColumn(name = "dbSiteSarfID")
    @OneToOne
    private SiteSarf dbSiteSarfID;
    @Column(name = "yerlesimAdi1")
    private String yerlesimAdi1;
    @Column(name = "yerlesimAdi2")
    private String yerlesimAdi2;
    @Column(name = "yerlesimAdi3")
    private String yerlesimAdi3;
    @Column(name = "yerlesimAdi4")
    private String yerlesimAdi4;
    @Column(name = "yerlesimAdi5")
    private String yerlesimAdi5;
    @Column(name = "yerlesimAdi6")
    private String yerlesimAdi6;
    @Column(name = "yerlesimAdi7")
    private String yerlesimAdi7;
    @Column(name = "yerlesimAdi8")
    private String yerlesimAdi8;
    @Column(name = "yerlesimAdi9")
    private String yerlesimAdi9;
    @Column(name = "yerlesimAdi10")
    private String yerlesimAdi10;

    public KapsananYerler() {
    }

    public KapsananYerler(Integer dbKapsananYerlerID) {
        this.dbKapsananYerlerID = dbKapsananYerlerID;
    }

    public KapsananYerler(Integer dbKapsananYerlerID, SiteSarf dbSiteSarfID) {
        this.dbKapsananYerlerID = dbKapsananYerlerID;
        this.dbSiteSarfID = dbSiteSarfID;
    }

    public Integer getDbKapsananYerlerID() {
        return dbKapsananYerlerID;
    }

    public void setDbKapsananYerlerID(Integer dbKapsananYerlerID) {
        this.dbKapsananYerlerID = dbKapsananYerlerID;
    }

    public SiteSarf getDbSiteSarfID() {
        return dbSiteSarfID;
    }

    public void setDbSiteSarfID(SiteSarf dbSiteSarfID) {
        this.dbSiteSarfID = dbSiteSarfID;
    }


    public String getYerlesimAdi1() {
        return yerlesimAdi1;
    }

    public void setYerlesimAdi1(String yerlesimAdi1) {
        this.yerlesimAdi1 = yerlesimAdi1;
    }

    public String getYerlesimAdi2() {
        return yerlesimAdi2;
    }

    public void setYerlesimAdi2(String yerlesimAdi2) {
        this.yerlesimAdi2 = yerlesimAdi2;
    }

    public String getYerlesimAdi3() {
        return yerlesimAdi3;
    }

    public void setYerlesimAdi3(String yerlesimAdi3) {
        this.yerlesimAdi3 = yerlesimAdi3;
    }

    public String getYerlesimAdi4() {
        return yerlesimAdi4;
    }

    public void setYerlesimAdi4(String yerlesimAdi4) {
        this.yerlesimAdi4 = yerlesimAdi4;
    }

    public String getYerlesimAdi5() {
        return yerlesimAdi5;
    }

    public void setYerlesimAdi5(String yerlesimAdi5) {
        this.yerlesimAdi5 = yerlesimAdi5;
    }

    public String getYerlesimAdi6() {
        return yerlesimAdi6;
    }

    public void setYerlesimAdi6(String yerlesimAdi6) {
        this.yerlesimAdi6 = yerlesimAdi6;
    }

    public String getYerlesimAdi7() {
        return yerlesimAdi7;
    }

    public void setYerlesimAdi7(String yerlesimAdi7) {
        this.yerlesimAdi7 = yerlesimAdi7;
    }

    public String getYerlesimAdi8() {
        return yerlesimAdi8;
    }

    public void setYerlesimAdi8(String yerlesimAdi8) {
        this.yerlesimAdi8 = yerlesimAdi8;
    }

    public String getYerlesimAdi9() {
        return yerlesimAdi9;
    }

    public void setYerlesimAdi9(String yerlesimAdi9) {
        this.yerlesimAdi9 = yerlesimAdi9;
    }

    public String getYerlesimAdi10() {
        return yerlesimAdi10;
    }

    public void setYerlesimAdi10(String yerlesimAdi10) {
        this.yerlesimAdi10 = yerlesimAdi10;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbKapsananYerlerID != null ? dbKapsananYerlerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KapsananYerler)) {
            return false;
        }
        KapsananYerler other = (KapsananYerler) object;
        if ((this.dbKapsananYerlerID == null && other.dbKapsananYerlerID != null) || (this.dbKapsananYerlerID != null && !this.dbKapsananYerlerID.equals(other.dbKapsananYerlerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.KapsananYerler[dbKapsananYerlerID=" + dbKapsananYerlerID + "]";
    }

}
