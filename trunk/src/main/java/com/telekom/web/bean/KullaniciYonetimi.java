package com.telekom.web.bean;


import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.service.YetkilendirmeServis;
import com.telekom.web.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean
@ViewScoped
public class KullaniciYonetimi implements Serializable {

    @ManagedProperty("#{yetkilendirmeServis}")
    private YetkilendirmeServis yetkilendirmeServisi;
    public List<UserTablo> kullanicilar;
    private UserTablo kullanici;
    private DualListModel<Yetki> Yetkiler;
    private WebUtil util=new WebUtil();

    @PostConstruct
    public void hazirla() {
        kullanicilar = yetkilendirmeServisi.tumUserTablolariGetir();
        kullanici = new UserTablo();

        Yetkiler = new DualListModel<Yetki>();
        Yetkiler.setSource(yetkilendirmeServisi.findAllYetki());
    }


    public DualListModel<Yetki> getYetkiler() {
        return Yetkiler;
    }

    public void setYetkiler(DualListModel<Yetki> Yetkiler) {
        this.Yetkiler = Yetkiler;
    }

    public UserTablo getKullanici() {
        return kullanici;
    }

    public void setKullanici(UserTablo kullanici) {
        this.kullanici = kullanici;
    }

    public List<UserTablo> getKullanicilar() {
        return kullanicilar;
    }

    public void setKullanicilar(List<UserTablo> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }


    public YetkilendirmeServis getYetkilendirmeServisi() {
        return yetkilendirmeServisi;
    }

    public void setYetkilendirmeServisi(YetkilendirmeServis yetkilendirmeServisi) {
        this.yetkilendirmeServisi = yetkilendirmeServisi;
    }

    public void kullaniciKaydet() {
        kullanici.setYetki(new ArrayList<Yetki>(Yetkiler.getTarget()));
        
        if (kullanici.isKayitlimi()) {
            yetkilendirmeServisi.kullaniciGuncelle(kullanici);
            util.showFacesMessage(FacesContext.getCurrentInstance(),"Güncelleme işlemi başarılı.", FacesMessage.SEVERITY_INFO);


        } else {
            yetkilendirmeServisi.kullaniciKaydet(kullanici);
            util.showFacesMessage(FacesContext.getCurrentInstance(),"Kayıt işlemi başarılı", FacesMessage.SEVERITY_INFO);

            kullanicilar = yetkilendirmeServisi.tumUserTablolariGetir();
        }
        
        kullanici = new UserTablo();
    }

    public void detayHazirla(SelectEvent event) {
        Yetkiler = new DualListModel<Yetki>();
        Yetkiler.setSource(YetkiFarkGetir());
        Yetkiler.setTarget(new ArrayList(kullanici.getYetki()));

    }

    public void yeniHazirla() {
        Yetkiler = new DualListModel<Yetki>();
        Yetkiler.setSource(yetkilendirmeServisi.findAllYetki());
        kullanici = new UserTablo();
    }

    private List<Yetki> YetkiFarkGetir() {
        List<Yetki> tumListe = yetkilendirmeServisi.findAllYetki();
        List<Yetki> farkListe = new ArrayList<Yetki>();
        List<Yetki> kullaniciYetkileri = new ArrayList(kullanici.getYetki());
        for (int i = 0; i < tumListe.size(); i++) {
            int flag = 0;
            for (int j = 0; j < kullaniciYetkileri.size(); j++) {
                if (tumListe.get(i).getId().equals(kullaniciYetkileri.get(j).getId())) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                farkListe.add(tumListe.get(i));
            }
        }
        return farkListe;
    }

}
