/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.dao;

import com.telekom.auth.entity.UserTablo;
import java.util.List;

/**
 *
 * @author esimsek
 */
public interface UserTabloDAO {

    public UserTablo getir(String UserTabloAdi, String sifre);

    public UserTablo getir(String UserTabloAdi);

    public void sil(UserTablo UserTablo);

    public UserTablo bul(Long id);

    public void guncelle(UserTablo UserTablo);

    public void kaydet(UserTablo UserTablo);

    public List<UserTablo> tumUserTablolariGetir();
}
