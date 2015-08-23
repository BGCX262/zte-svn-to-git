/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.auth.dao;

import com.telekom.auth.entity.Yetki;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esimsek
 *
 */
@Repository
public class YetkiDAOImpl implements YetkiDAO {

    @PersistenceContext
    private EntityManager em;

    public Yetki bul(Long id) {
        return em.find(Yetki.class, id);
    }

    public void guncelle(Yetki Yetki) {
         em.merge(Yetki);
    }
    
   
    public void kaydet(Yetki Yetki) {
        em.persist(Yetki);
    }

    public List<Yetki> tumYetkileriGetir() {
        Query query = em.createQuery("From Yetki");
        List<Yetki> list = query.getResultList();

        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<Yetki>();
        }
    }
}
