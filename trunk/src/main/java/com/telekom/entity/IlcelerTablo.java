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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "ilceler_tablo")
@NamedQueries({
    @NamedQuery(name = "IlcelerTablo.findAll", query = "SELECT i FROM IlcelerTablo i"),
    @NamedQuery(name = "IlcelerTablo.findByDbIlceId", query = "SELECT i FROM IlcelerTablo i WHERE i.dbIlceId = :dbIlceId"),
    @NamedQuery(name = "IlcelerTablo.findByDbSehirID", query = "SELECT i FROM IlcelerTablo i WHERE i.dbSehirID = :dbSehirID"),
    @NamedQuery(name = "IlcelerTablo.findByIlceAdi", query = "SELECT i FROM IlcelerTablo i WHERE i.ilceAdi = :ilceAdi")})
public class IlcelerTablo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dbIlceId")
    private Integer dbIlceId;
    @Basic(optional = false)
    @JoinColumn(name = "dbSehirID")
    @ManyToOne
    private SehirlerTablo dbSehirID;
    @Basic(optional = false)
    @Column(name = "ilceAdi")
    private String ilceAdi;

    public IlcelerTablo() {
    }

    public IlcelerTablo(Integer dbIlceId) {
        this.dbIlceId = dbIlceId;
    }

    public IlcelerTablo(Integer dbIlceId, SehirlerTablo dbSehirID, String ilceAdi) {
        this.dbIlceId = dbIlceId;
        this.dbSehirID = dbSehirID;
        this.ilceAdi = ilceAdi;
    }

    public Integer getDbIlceId() {
        return dbIlceId;
    }

    public void setDbIlceId(Integer dbIlceId) {
        this.dbIlceId = dbIlceId;
    }

    public SehirlerTablo getDbSehirID() {
        return dbSehirID;
    }

    public void setDbSehirID(SehirlerTablo dbSehirID) {
        this.dbSehirID = dbSehirID;
    }

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbIlceId != null ? dbIlceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IlcelerTablo)) {
            return false;
        }
        IlcelerTablo other = (IlcelerTablo) object;
        if ((this.dbIlceId == null && other.dbIlceId != null) || (this.dbIlceId != null && !this.dbIlceId.equals(other.dbIlceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.telekom.entity.IlcelerTablo[dbIlceId=" + dbIlceId + "]";
    }

}
