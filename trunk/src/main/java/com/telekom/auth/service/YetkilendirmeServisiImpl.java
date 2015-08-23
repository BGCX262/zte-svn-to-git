/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.service;

import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.dao.YetkiDAO;
import com.telekom.auth.dao.UserTabloDAO;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author esimsek
 */
@Service("yetkilendirmeServis")
public class YetkilendirmeServisiImpl implements YetkilendirmeServis, Serializable {

    @Autowired
    public UserTabloDAO userTabloDAO;
    @Autowired
    public YetkiDAO YetkiDAO;

    @Transactional
    public void kullaniciKaydet(UserTablo kullanici) {
        userTabloDAO.kaydet(kullanici);
    }

    @Transactional
    public void kullaniciGuncelle(UserTablo kullanici) {
        userTabloDAO.guncelle(kullanici);
    }

    @Transactional
    public UserTablo kullaniciBul(Long id) {
        return userTabloDAO.bul(id);
    }

    @Transactional
    public void YetkiKaydet(Yetki Yetki) {
        YetkiDAO.kaydet(Yetki);
    }

    @Transactional
    public Yetki YetkiBul(Long id) {
        return YetkiDAO.bul(id);
    }

    @Transactional
    public void YetkiGuncelle(Yetki Yetki) {
        YetkiDAO.guncelle(Yetki);
    }

    @Transactional
    public Authentication login(String kullaniciAdi, String sifre) {
        UserTablo kullanici = userTabloDAO.getir(kullaniciAdi, sifre);

        Set<GrantedAuthority> yetkiler = new HashSet<GrantedAuthority>();

        //UserTablo yetkileri
        for (Yetki Yetki : kullanici.getYetki()) {
            yetkiler.add(new GrantedAuthorityImpl(Yetki.getAdi()));
        }

        return new UsernamePasswordAuthenticationToken(kullanici.getUserName(), kullanici.getPassword(), yetkiler);
    }

    @Transactional
    public void kullaniciSil(UserTablo kullanici) {
        userTabloDAO.sil(kullanici);
    }

    @Transactional
    public UserTablo kullaniciBul(String kullaniciAd) {
        return userTabloDAO.getir(kullaniciAd);
    }

    @Transactional
    public UserTablo kullaniciGetir(String kullaniciAdi, String sifre) {
        return userTabloDAO.getir(kullaniciAdi, sifre);
    }

    @Transactional
    public List<UserTablo> tumUserTablolariGetir() {
        return this.userTabloDAO.tumUserTablolariGetir();
    }

    @Transactional
    public List<Yetki> findAllYetki() {
        return this.YetkiDAO.tumYetkileriGetir();
    }

    @Transactional
    public List<Yetki> findUserYetki(UserTablo tablo) {
        return this.kullaniciBul(tablo.getDbUserID()).getYetki();
    }
}
