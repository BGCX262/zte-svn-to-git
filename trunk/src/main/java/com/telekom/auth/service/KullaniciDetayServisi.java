package com.telekom.auth.service;


import com.telekom.auth.entity.Yetki;
import com.telekom.auth.dao.UserTabloDAO;
import com.telekom.auth.entity.UserTablo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("kullaniciDetayServisi")
public class KullaniciDetayServisi implements UserDetailsService {

    @Autowired
    private UserTabloDAO userTabloDAO;

    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException, DataAccessException {
        UserTablo kullanici = userTabloDAO.getir(value);
        
        if(kullanici == null) {
            throw new UsernameNotFoundException("Gecersiz kullanici adi");
        }
        else {
            List<GrantedAuthority> yetkiler = new ArrayList<GrantedAuthority>();

            //Kullanici yetkileri
            for(Yetki Yetki : kullanici.getYetki()) {
                yetkiler.add(new GrantedAuthorityImpl(Yetki.getAdi()));
            }
        
            return new User(kullanici.getUserName(),
                            kullanici.getPassword(), true, true, true, true,
                            yetkiler);

        }
    }    
}
