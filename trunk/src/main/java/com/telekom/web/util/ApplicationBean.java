package com.telekom.web.util;

import com.telekom.auth.entity.Yetki;
import com.telekom.auth.entity.UserTablo;
import com.telekom.auth.service.YetkilendirmeServis;
import com.telekom.entity.Altislemtipi;
import com.telekom.entity.IlcelerTablo;
import com.telekom.entity.SehirlerTablo;
import com.telekom.entity.Ustislemtipi;
import com.telekom.enums.EnumBolge;
import com.telekom.enums.EnumEnerjiTipi;
import com.telekom.enums.EnumIsDurum;
import com.telekom.enums.EnumKiralamaDurum;
import com.telekom.enums.EnumKiralananAlanTur;
import com.telekom.enums.EnumOnayDurum;
import com.telekom.enums.EnumSivilIslerDurum;
import com.telekom.enums.EnumTransmisyonYontemi;
import com.telekom.enums.EnumVendor;
import com.telekom.service.TelekomService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

/**
 *
 * @author esimsek
 */
@ManagedBean
@ApplicationScoped
public class ApplicationBean implements Serializable {

    @ManagedProperty("#{yetkilendirmeServis}")
    private YetkilendirmeServis yetkilendirmeServis;
    @ManagedProperty(value = "#{TelekomService}")
    private TelekomService telekomService;
    private List<SelectItem> bolge = new ArrayList<SelectItem>();
    private List<SelectItem> enerjiTip = new ArrayList<SelectItem>();
    private List<SelectItem> kiralamaDurum = new ArrayList<SelectItem>();
    private List<SelectItem> kiralananAlanTur = new ArrayList<SelectItem>();
    private List<SelectItem> sivilIslerDurum = new ArrayList<SelectItem>();
    private List<SelectItem> transmisyonYontemi = new ArrayList<SelectItem>();
    private List<SelectItem> onayDurum = new ArrayList<SelectItem>();
    private List<SelectItem> isDurum = new ArrayList<SelectItem>();
    private List<SelectItem> vendor = new ArrayList<SelectItem>();
    private List<SelectItem> sehir = new ArrayList<SelectItem>();
    private List<SelectItem> ilce = new ArrayList<SelectItem>();
    private List<SelectItem> altIslem = new ArrayList<SelectItem>();
    private List<SelectItem> ustIslem = new ArrayList<SelectItem>();
    private SelectItem[] asehir;
    private SelectItem[] abolge;
    private WebUtil util = new WebUtil();

    public ApplicationBean() {
    }

    public void initAllProperties() {
        bolge = new ArrayList<SelectItem>();
        enerjiTip = new ArrayList<SelectItem>();
        kiralamaDurum = new ArrayList<SelectItem>();
        sivilIslerDurum = new ArrayList<SelectItem>();
        transmisyonYontemi = new ArrayList<SelectItem>();
        onayDurum = new ArrayList<SelectItem>();
        isDurum = new ArrayList<SelectItem>();
        vendor = new ArrayList<SelectItem>();
        sehir = new ArrayList<SelectItem>();
        altIslem = new ArrayList<SelectItem>();
        ustIslem = new ArrayList<SelectItem>();
        kiralananAlanTur = new ArrayList<SelectItem>();
    }

    @PostConstruct
    public void init() {
        this.initAllProperties();
        this.kullaniciOlustur();
        this.dropdownDoldur();
    }

    public void kullaniciOlustur() {
        List<Yetki> Yetkis = this.yetkilendirmeServis.findAllYetki();
        if (Yetkis == null || Yetkis.isEmpty()) {
            this.yetkilendirmeServis.YetkiKaydet(new Yetki("ROLE_USER", "Genel Kullanici"));
            this.yetkilendirmeServis.YetkiKaydet(new Yetki("ROLE_TT", "TT"));
            this.yetkilendirmeServis.YetkiKaydet(new Yetki("ROLE_ZTE", "ZTE Rol"));
            this.yetkilendirmeServis.YetkiKaydet(new Yetki("ROLE_HUAWEI", "HUAWEI Rol"));
        }
        List<UserTablo> users = this.yetkilendirmeServis.tumUserTablolariGetir();
        if (users == null || users.isEmpty()) {
            UserTablo ut = new UserTablo();
            ut.setIsim("zte");
            ut.setPassword("zte");
            ut.setSoyisim("zte");
            ut.setUserName("zte");
            ut.setVendor("ZTE");

            UserTablo ut3 = new UserTablo();
            ut3.setIsim("tt");
            ut3.setPassword("tt");
            ut3.setSoyisim("tt");
            ut3.setUserName("tt");
            ut3.setVendor("TT");

            UserTablo ut2 = new UserTablo();
            ut2.setIsim("huawei");
            ut2.setPassword("huawei");
            ut2.setSoyisim("huawei");
            ut2.setUserName("huawei");
            ut2.setVendor("HUAWEI");
            ut.setYetki(new ArrayList<Yetki>(this.yetkilendirmeServis.findAllYetki()));
            ut2.setYetki(new ArrayList<Yetki>(this.yetkilendirmeServis.findAllYetki()));
            ut3.setYetki(new ArrayList<Yetki>(this.yetkilendirmeServis.findAllYetki()));
            this.yetkilendirmeServis.kullaniciKaydet(ut);
            this.yetkilendirmeServis.kullaniciKaydet(ut2);
            this.yetkilendirmeServis.kullaniciKaydet(ut3);
        }

    }

    public void dropdownDoldur() {
        try {
            EnumBolge[] enumBolge = EnumBolge.values();
            EnumEnerjiTipi[] enumEnerji = EnumEnerjiTipi.values();
            EnumKiralamaDurum[] enumKiralama = EnumKiralamaDurum.values();
            EnumSivilIslerDurum[] enumSivil = EnumSivilIslerDurum.values();
            EnumTransmisyonYontemi[] enumTrans = EnumTransmisyonYontemi.values();
            EnumVendor[] enumVendor = EnumVendor.values();
            EnumOnayDurum[] enumOnayDurum = EnumOnayDurum.values();
            EnumIsDurum[] enumIsDurum = EnumIsDurum.values();
            EnumKiralananAlanTur[] enumKiralamaDurum = EnumKiralananAlanTur.values();

            List<SehirlerTablo> sehirler = this.telekomService.findAllSehirler();

            if (sehirler != null && sehirler.isEmpty()) {
                SehirlerTablo st = new SehirlerTablo(1, "ADANA");
                SehirlerTablo st1 = new SehirlerTablo(6, "ANKARA");
                SehirlerTablo st2 = new SehirlerTablo(34, "ISTANBUL");
                this.telekomService.kaydet(st);
                this.telekomService.kaydet(st1);
                this.telekomService.kaydet(st2);

                this.telekomService.kaydet(new IlcelerTablo(1, st, "SEYHAN"));
                this.telekomService.kaydet(new IlcelerTablo(2, st, "CEYHAN"));
                this.telekomService.kaydet(new IlcelerTablo(3, st, "ALADAG"));

                this.telekomService.kaydet(new IlcelerTablo(4, st1, "CANKAYA"));
                this.telekomService.kaydet(new IlcelerTablo(5, st1, "YENIMAHALLE"));
                this.telekomService.kaydet(new IlcelerTablo(6, st1, "KECIOREN"));

                this.telekomService.kaydet(new IlcelerTablo(7, st2, "BAGLARBASI"));
                this.telekomService.kaydet(new IlcelerTablo(8, st2, "USKUDAR"));
                this.telekomService.kaydet(new IlcelerTablo(9, st2, "KADIKOY"));
            }
            sehirler = this.telekomService.findAllSehirler();
            this.asehir = new SelectItem[sehirler.size()+1];
            int a = 1;
            asehir[0] = new SelectItem("", "Tümü");
            for (Iterator<SehirlerTablo> it = sehirler.iterator(); it.hasNext();) {
                SehirlerTablo st = it.next();
                this.sehir.add(new SelectItem(st.getDbSehirID(), st.getSehir()));
                asehir[a] = new SelectItem(st.getDbSehirID(), st.getSehir());
                a += 1;
            }



            for (int i = 0; i < enumVendor.length; i++) {
                vendor.add(new SelectItem(enumBolge[i].getValue(), enumBolge[i].getValue()));
            }

            for (int i = 0; i < enumKiralamaDurum.length; i++) {
                kiralananAlanTur.add(new SelectItem(enumKiralamaDurum[i].name(), enumKiralamaDurum[i].getValue()));
            }

            for (int i = 0; i < enumOnayDurum.length; i++) {
                onayDurum.add(new SelectItem(enumOnayDurum[i].name(), enumOnayDurum[i].getValue()));
            }

            for (int i = 0; i < enumIsDurum.length; i++) {
                isDurum.add(new SelectItem(enumIsDurum[i].name(), enumIsDurum[i].getValue()));
            }
            for (int i = 0; i < enumTrans.length; i++) {
                transmisyonYontemi.add(new SelectItem(enumTrans[i].name(), enumTrans[i].getValue()));
            }
            for (int i = 0; i < enumSivil.length; i++) {
                sivilIslerDurum.add(new SelectItem(enumSivil[i].name(), enumSivil[i].getValue()));
            }
            for (int i = 0; i < enumKiralama.length; i++) {
                kiralamaDurum.add(new SelectItem(enumKiralama[i].name(), enumKiralama[i].getValue()));
            }
            for (int i = 0; i < enumEnerji.length; i++) {
                enerjiTip.add(new SelectItem(enumEnerji[i].name(), enumEnerji[i].getValue()));
            }

             int b = 1;
             abolge = new SelectItem[(enumBolge.length)+1];
             abolge[0] = new SelectItem("", "Tümü");
            for (int i = 0; i < enumBolge.length; i++) {
                bolge.add(new SelectItem(enumBolge[i].name(), enumBolge[i].getValue()));
                abolge[b] = new SelectItem(enumBolge[i].name(), enumBolge[i].getValue());
                b += 1;
            }

            List<Altislemtipi> altislemtipis = telekomService.findAllAltIslemTip();
            List<Ustislemtipi> ustislemtipis = telekomService.findAllUstIslemTip();

            for (int i = 0; i < altislemtipis.size(); i++) {
                altIslem.add(new SelectItem(altislemtipis.get(i).getDbAltIslemTipiID(), altislemtipis.get(i).getAltIslemAdi()));
            }

            for (int i = 0; i < ustislemtipis.size(); i++) {
                ustIslem.add(new SelectItem(ustislemtipis.get(i).getDbUstIslemTipiID(), ustislemtipis.get(i).getUstIslemAdi()));
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<SelectItem> altIslem4SelectList(String ustIslemKod) throws Exception {
        List<SelectItem> sis = new ArrayList<SelectItem>();
        if (ustIslemKod.equals("-1") || ustIslemKod.equals("")) {
            sis = util.selectOneMenuDoldur(new ArrayList<IlcelerTablo>(), "dbIlceId", "ilceAdi", ustIslemKod);
        } else {
            sis = util.selectOneMenuDoldur(telekomService.findAltIslemByUstIslemId(Integer.parseInt(ustIslemKod)), "dbAltIslemTipiID", "altIslemAdi", ustIslemKod);
        }

        return sis;
    }

    public List<SelectItem> ilce4SelectList(String ilKod) throws Exception {
        List<SelectItem> sis = new ArrayList<SelectItem>();
        if (ilKod.equals("-1") || ilKod.equals("")) {
            sis = util.selectOneMenuDoldur(new ArrayList<IlcelerTablo>(), "dbIlceId", "ilceAdi", ilKod);
        } else {
            sis = util.selectOneMenuDoldur(telekomService.findIlceByIl(Integer.parseInt(ilKod)), "dbIlceId", "ilceAdi", ilKod);
        }

        return sis;
    }

    @Override
    public String toString() {
        return "appBean";
    }

    //<editor-fold>
    public YetkilendirmeServis getYetkilendirmeServis() {
        return yetkilendirmeServis;
    }

    public List<SelectItem> getIlce() {
        return ilce;
    }

    public void setIlce(List<SelectItem> ilce) {
        this.ilce = ilce;
    }

    public SelectItem[] getAsehir() {
        return asehir;
    }

    public void setAsehir(SelectItem[] asehir) {
        this.asehir = asehir;
    }

    public TelekomService getTelekomService() {
        return telekomService;
    }

    public void setTelekomService(TelekomService telekomService) {
        this.telekomService = telekomService;
    }

    public List<SelectItem> getSehir() {
        return sehir;
    }

    public void setSehir(List<SelectItem> sehir) {
        this.sehir = sehir;
    }

    public void setYetkilendirmeServis(YetkilendirmeServis yetkilendirmeServis) {
        this.yetkilendirmeServis = yetkilendirmeServis;
    }

    public List<SelectItem> getBolge() {
        return bolge;
    }

    public void setBolge(List<SelectItem> bolge) {
        this.bolge = bolge;
    }

    public List<SelectItem> getIsDurum() {
        return isDurum;
    }

    public void setIsDurum(List<SelectItem> isDurum) {
        this.isDurum = isDurum;
    }

    public List<SelectItem> getOnayDurum() {
        return onayDurum;
    }

    public void setOnayDurum(List<SelectItem> onayDurum) {
        this.onayDurum = onayDurum;
    }

    public List<SelectItem> getEnerjiTip() {
        return enerjiTip;
    }

    public void setEnerjiTip(List<SelectItem> enerjiTip) {
        this.enerjiTip = enerjiTip;
    }

    public List<SelectItem> getKiralananAlanTur() {
        return kiralananAlanTur;
    }

    public void setKiralananAlanTur(List<SelectItem> kiralananAlanTur) {
        this.kiralananAlanTur = kiralananAlanTur;
    }

    public List<SelectItem> getKiralamaDurum() {
        return kiralamaDurum;
    }

    public void setKiralamaDurum(List<SelectItem> kiralamaDurum) {
        this.kiralamaDurum = kiralamaDurum;
    }

    public List<SelectItem> getSivilIslerDurum() {
        return sivilIslerDurum;
    }

    public void setSivilIslerDurum(List<SelectItem> sivilIslerDurum) {
        this.sivilIslerDurum = sivilIslerDurum;
    }

    public List<SelectItem> getTransmisyonYontemi() {
        return transmisyonYontemi;
    }

    public void setTransmisyonYontemi(List<SelectItem> transmisyonYontemi) {
        this.transmisyonYontemi = transmisyonYontemi;
    }

    public List<SelectItem> getVendor() {
        return vendor;
    }

    public void setVendor(List<SelectItem> vendor) {
        this.vendor = vendor;
    }

    public List<SelectItem> getAltIslem() {
        return altIslem;
    }

    public void setAltIslem(List<SelectItem> altIslem) {
        this.altIslem = altIslem;
    }

    public List<SelectItem> getUstIslem() {
        return ustIslem;
    }

    public void setUstIslem(List<SelectItem> ustIslem) {
        this.ustIslem = ustIslem;
    }

    public SelectItem[] getAbolge() {
        return abolge;
    }

    public void setAbolge(SelectItem[] abolge) {
        this.abolge = abolge;
    }

    
    //</editor-fold>
}
