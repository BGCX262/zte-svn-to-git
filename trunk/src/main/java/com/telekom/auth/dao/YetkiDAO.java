/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.dao;

import com.telekom.auth.entity.Yetki;
import java.util.List;

/**
 *
 * @author esimsek
 */
public interface YetkiDAO {

  
    public Yetki bul(Long id);

   
    public void guncelle(Yetki Yetki);

  
    public void kaydet(Yetki Yetki);

    
    public List<Yetki> tumYetkileriGetir();

}
