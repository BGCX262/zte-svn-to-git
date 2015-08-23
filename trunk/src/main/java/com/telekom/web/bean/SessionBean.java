package com.telekom.web.bean;

import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.service.YetkilendirmeServis;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author esimsek
 */
@ManagedBean
@SessionScoped
public class SessionBean {

    private UserTablo userTablo;
    @ManagedProperty(value = "#{yetkilendirmeServis}")
    private YetkilendirmeServis yetkilendirmeServis;
    private Long kullaniciId;

    public SessionBean() {
    }

    @PostConstruct
    public void init() {
        User u = this.getContextUser();
        if (this.userTablo == null && u instanceof User) {
            this.setUserTablo(this.yetkilendirmeServis.kullaniciBul(u.getUsername()));
            this.kullaniciId = this.userTablo.getDbUserID();
        }

    }

    @PreDestroy
    public void oturumKapat() {
        if (this.kullaniciId != null) {
            UserTablo k = yetkilendirmeServis.kullaniciBul(kullaniciId);
            k.setSonGirisTarihi(Calendar.getInstance());
            yetkilendirmeServis.kullaniciGuncelle(k);
        }
    }

    public User getContextUser() {
        return (User) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">
    public UserTablo getUserTablo() {
        return userTablo;
    }

    public Long getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Long kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public YetkilendirmeServis getYetkilendirmeServis() {
        return yetkilendirmeServis;
    }

    public void setYetkilendirmeServis(YetkilendirmeServis yetkilendirmeServis) {
        this.yetkilendirmeServis = yetkilendirmeServis;
    }

    public void setUserTablo(UserTablo userTablo) {
        this.userTablo = userTablo;
    }
    //</editor-fold>
}
