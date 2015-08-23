/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.dao;

import com.telekom.auth.entity.UserTablo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esimsek
 */
@Repository
public class UserTabloDAOImpl implements UserTabloDAO {

    @PersistenceContext
    private EntityManager em;

    public UserTablo getir(String UserTabloAdi, String sifre) {
        Query query = em.createQuery("SELECT k FROM UserTablo k WHERE k.userName=:UserTabloAdi AND k.password=:sifre");
        query.setParameter("UserTabloAdi", UserTabloAdi);
        query.setParameter("sifre", sifre);

        List<UserTablo> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public UserTablo getir(String UserTabloAdi) {
        Query query = em.createQuery("SELECT k FROM UserTablo k WHERE k.userName=:UserTabloAdi");
        query.setParameter("UserTabloAdi", UserTabloAdi);

        List<UserTablo> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public void sil(UserTablo UserTablo) {
        em.remove(UserTablo);
    }

    public UserTablo bul(Long id) {
        return em.find(UserTablo.class, id);
    }

    public void guncelle(UserTablo UserTablo) {
        em.merge(UserTablo);
    }

    public void kaydet(UserTablo UserTablo) {
        em.persist(UserTablo);
    }

    public List<UserTablo> tumUserTablolariGetir() {
        Query query = em.createQuery("from UserTablo");
        List<UserTablo> list = query.getResultList();
        return list;
    }
}
