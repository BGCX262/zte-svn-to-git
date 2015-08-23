/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author esimsek
 */
@Entity
@Table(name = "user_tablo")
@NamedQueries({
    @NamedQuery(name = "UserTablo.findAll", query = "SELECT u FROM UserTablo u"),
    @NamedQuery(name = "UserTablo.findByDbUserID", query = "SELECT u FROM UserTablo u WHERE u.dbUserID = :dbUserID"),
    @NamedQuery(name = "UserTablo.findByVendor", query = "SELECT u FROM UserTablo u WHERE u.vendor = :vendor"),
    @NamedQuery(name = "UserTablo.findByUserName", query = "SELECT u FROM UserTablo u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserTablo.findByPassword", query = "SELECT u FROM UserTablo u WHERE u.password = :password"),
    @NamedQuery(name = "UserTablo.findBySonGirisTarihi", query = "SELECT u FROM UserTablo u WHERE u.sonGirisTarihi = :sonGirisTarihi"),
    @NamedQuery(name = "UserTablo.findByIsim", query = "SELECT u FROM UserTablo u WHERE u.isim = :isim"),
    @NamedQuery(name = "UserTablo.findBySoyisim", query = "SELECT u FROM UserTablo u WHERE u.soyisim = :soyisim"),
    @NamedQuery(name = "UserTablo.findByTelefon", query = "SELECT u FROM UserTablo u WHERE u.telefon = :telefon"),
    @NamedQuery(name = "UserTablo.findByEposta", query = "SELECT u FROM UserTablo u WHERE u.eposta = :eposta")})
public class UserTablo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dbUserID")
    private Long dbUserID;
    @Column(name = "vendor")
    private String vendor;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "sonGirisTarihi")
    @Temporal(TemporalType.DATE)
    private Calendar sonGirisTarihi;
    @Column(name = "isim")
    private String isim;
    @Column(name = "soyisim")
    private String soyisim;
    @Column(name = "telefon")
    private String telefon;
    @Column(name = "eposta")
    private String eposta;
    @JoinTable
    @ManyToMany
    private List<Yetki> yetki;

    public UserTablo() {
    }

    public UserTablo(Long dbUserID) {
        this.dbUserID = dbUserID;
    }

    public UserTablo(Long dbUserID, String vendor, String userName, String password, Calendar sonGirisTarihi) {
        this.dbUserID = dbUserID;
        this.vendor = vendor;
        this.userName = userName;
        this.password = password;
        this.sonGirisTarihi = sonGirisTarihi;
    }

    public UserTablo(String vendor, String userName, String password, Calendar sonGirisTarihi) {
        this.vendor = vendor;
        this.userName = userName;
        this.password = password;
        this.sonGirisTarihi = sonGirisTarihi;
    }

    public UserTablo(String userName, String password, String isim, String soyisim) {
        this.userName = userName;
        this.password = password;
        this.isim = isim;
        this.soyisim = soyisim;
    }

    public boolean isKayitlimi() {
        return this.dbUserID == null ? false : true;
    }

    public Long getDbUserID() {
        return dbUserID;
    }

    public void setDbUserID(Long dbUserID) {
        this.dbUserID = dbUserID;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Calendar getSonGirisTarihi() {
        return sonGirisTarihi;
    }

    public void setSonGirisTarihi(Calendar sonGirisTarihi) {
        this.sonGirisTarihi = sonGirisTarihi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getTelefon() {
        return telefon;
    }

    public List<Yetki> getYetki() {
        return yetki;
    }

    public void setYetki(List<Yetki> yetki) {
        this.yetki = yetki;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dbUserID != null ? dbUserID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTablo)) {
            return false;
        }
        UserTablo other = (UserTablo) object;
        if ((this.dbUserID == null && other.dbUserID != null) || (this.dbUserID != null && !this.dbUserID.equals(other.dbUserID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.zte.entity.UserTablo[dbUserID=" + dbUserID + "]";
    }
}
