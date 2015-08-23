/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zte.auth;

import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.service.YetkilendirmeServis;
import java.util.Calendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 *
 * @author esimsek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations={"classpath:/META-INF/beans.xml"})
public class YetkilendirmeServisiTest {

    @Autowired
    private YetkilendirmeServis servis;

    @Test
    public void kaydedebilmeli() {
//        Yetki Yetki = new Yetki("ROLE_USER", "ROLE_USER");
//        servis.YetkiKaydet(Yetki);
//        assertNotNull("Id almis olmali", Yetki.getId());
////**************************
//        UserTablo kullanici = new UserTablo("vendor", "deneme", "deneme", Calendar.getInstance());
//        servis.kullaniciKaydet(kullanici);
//        assertNotNull("Id almis olmali", kullanici.getDbUserID());
//**************************
    }

}
