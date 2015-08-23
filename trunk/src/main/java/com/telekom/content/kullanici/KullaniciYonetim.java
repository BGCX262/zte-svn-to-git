
package com.telekom.content.kullanici;

import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.service.YetkilendirmeServis;
import com.telekom.web.bean.SessionBean;
import com.telekom.web.util.ApplicationBean;
import com.telekom.web.util.WebUtil;
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

/**
 *
 * @author esimsek
 */
@ManagedBean
@ViewScoped
public class KullaniciYonetim {

    @ManagedProperty(value = "#{yetkilendirmeServis}")
    private YetkilendirmeServis yetkilendirmeServis;
    @ManagedProperty(value = "#{applicationBean}")
    private ApplicationBean applicationBean;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private List<UserTablo> kullanicilar;
    private UserTablo rowKullanici;
    private DualListModel<Yetki> Yetkiler;
    private WebUtil util = new WebUtil();

    public KullaniciYonetim() {
    }

    @PostConstruct
    public void init() {
        //if (!this.util.isPostBack(FacesContext.getCurrentInstance())) {
            this.kullanicilar = this.yetkilendirmeServis.tumUserTablolariGetir();
            rowKullanici = new UserTablo();
            Yetkiler = new DualListModel<Yetki>();
            Yetkiler.setSource(this.yetkilendirmeServis.findAllYetki());
        //}
    }

    public void kullaniciKaydet() {
        rowKullanici.setYetki(new ArrayList<Yetki>(Yetkiler.getTarget()));
        if (this.rowKullanici.isKayitlimi()) {//kullanici.isKayitlimi()
            this.yetkilendirmeServis.kullaniciGuncelle(rowKullanici);
            util.showFacesMessage(FacesContext.getCurrentInstance(), "Kullanici Basarili Sekilde Eklenmistir", FacesMessage.SEVERITY_INFO);

        } else {
            this.yetkilendirmeServis.kullaniciKaydet(rowKullanici);
            util.showFacesMessage(FacesContext.getCurrentInstance(), "Kullanici Basarili Sekilde Eklenmistir", FacesMessage.SEVERITY_INFO);

            kullanicilar = this.yetkilendirmeServis.tumUserTablolariGetir();
        }


        rowKullanici = new UserTablo();
    }

    public void detayHazirla(SelectEvent event) {
        Yetkiler = new DualListModel<Yetki>();
        Yetkiler.setSource(YetkiFarkGetir());
        Yetkiler.setTarget(new ArrayList(this.yetkilendirmeServis.findUserYetki(rowKullanici)));
    }

    public void yeniHazirla() {
        Yetkiler = new DualListModel<Yetki>();
        Yetkiler.setSource(this.yetkilendirmeServis.findAllYetki());

        rowKullanici = new UserTablo();
    }

    private List<Yetki> YetkiFarkGetir() {
        List<Yetki> tumListe = this.yetkilendirmeServis.findAllYetki();
        List<Yetki> farkListe = new ArrayList<Yetki>();
        List<Yetki> kullaniciYetkileri = new ArrayList(this.yetkilendirmeServis.findUserYetki(rowKullanici));
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

    // <editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">
    public List<UserTablo> getKullanicilar() {
        return kullanicilar;
    }

    public DualListModel<Yetki> getYetkiler() {
        return Yetkiler;
    }

    public void setYetkiler(DualListModel<Yetki> Yetkiler) {
        this.Yetkiler = Yetkiler;
    }

    public void setKullanicilar(List<UserTablo> kullanicilar) {
        this.kullanicilar = kullanicilar;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public UserTablo getRowKullanici() {
        return rowKullanici;
    }

    public void setRowKullanici(UserTablo rowKullanici) {
        this.rowKullanici = rowKullanici;
    }

    public YetkilendirmeServis getYetkilendirmeServis() {
        return yetkilendirmeServis;
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public void setYetkilendirmeServis(YetkilendirmeServis yetkilendirmeServis) {
        this.yetkilendirmeServis = yetkilendirmeServis;
    }
    //</editor-fold>
}
