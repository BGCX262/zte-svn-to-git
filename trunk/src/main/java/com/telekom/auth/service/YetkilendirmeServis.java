/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.service;

import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.Authentication;

/**
 *
 * @author esimsek
 */
public interface YetkilendirmeServis {

    public Authentication login(String kullaniciAdi, String sifre);

    public UserTablo kullaniciGetir(String kullaniciAdi, String sifre);

    public void kullaniciSil(UserTablo kullanici);

    public void kullaniciKaydet(UserTablo kullanici);

    public List<UserTablo> tumUserTablolariGetir();

    public void kullaniciGuncelle(UserTablo kullanici);

    public UserTablo kullaniciBul(Long id);

    public UserTablo kullaniciBul(String kullaniciAd);

    public void YetkiKaydet(Yetki tekYetki);

    public Yetki YetkiBul(Long id);

    public void YetkiGuncelle(Yetki tekYetki);

    public List<Yetki> findAllYetki();

     public List<Yetki> findUserYetki(UserTablo tablo);
}
