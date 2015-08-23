/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.web.bean;

import com.telekom.entity.KapsananYerler;
import com.telekom.entity.KiralamaTablo;
import com.telekom.entity.SitePlanlanan;
import com.telekom.entity.SiteSarf;
import com.telekom.entity.TssForm;
import com.telekom.entity.Yapilanisler;
import com.telekom.entity.YorumlarTablo;
import com.telekom.service.TelekomService;
import com.telekom.web.util.WebUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author esimsek
 */
@ManagedBean
@ViewScoped
public class TssFormuBean {

    @ManagedProperty(value = "#{TelekomService}")
    private TelekomService telekomService;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    private SitePlanlanan sitePlanan;
    private SiteSarf siteSarf;
    private KiralamaTablo kiralamaTablo;
    private TssForm tssFrom;
    private Yapilanisler yapilanisler;
    private List<Yapilanisler> yapilanislerList;
    private List<YorumlarTablo> yorumlarList;
    private YorumlarTablo yorumlarTablo;
    private KapsananYerler kapsananYerler;
    private WebUtil util = new WebUtil();
    private Integer rowId;
    private Integer altIslemId;
    private Integer ustIslemId;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(TssForm.class);

    public TssFormuBean() {
    }

    @PostConstruct
    public void init() {
        if (!this.util.isPostBack(FacesContext.getCurrentInstance())) {
            this.yorumlarTablo = new YorumlarTablo();
        }
        if (WebUtil.getSessionMap(FacesContext.getCurrentInstance()).containsKey("selectedSiteSarf")) {
            this.siteSarf = (SiteSarf) WebUtil.getSessionMap(FacesContext.getCurrentInstance()).get("selectedSiteSarf");
            sitePlanan = telekomService.findSitePlanlanan(siteSarf.getDbSiteID().getDbSiteID());

            yapilanisler = new Yapilanisler();

            try {
                tssFrom = telekomService.findTssFormBySiteSarfId(this.siteSarf.getDbSiteSarfID());
            } catch (NoResultException e) {
                tssFrom = new TssForm();
            }
            try {
                yorumlarList = telekomService.findAllYorumBySiteSarfId(siteSarf.getDbSiteSarfID());
                //yorumlarList = new ArrayList<YorumlarTablo>();//telekomService.findAllYorumBySiteSarfId(this.siteSarf.getDbSiteSarfID());
            } catch (NoResultException e) {
                yorumlarList = new ArrayList<YorumlarTablo>();
            }
            try {
                kapsananYerler = telekomService.findKapsananYerlerBySiteSarfId(this.siteSarf.getDbSiteSarfID());
            } catch (NoResultException e) {
                kapsananYerler = new KapsananYerler();
            }

            try {
                yapilanislerList = telekomService.findYapilanIslerBySitePlanlananId(this.siteSarf.getDbSiteSarfID());
            } catch (NoResultException e) {
                yapilanislerList = new ArrayList<Yapilanisler>();
            }

            try {
                kiralamaTablo = telekomService.findKiralamaTabloBySiteSarfId(this.siteSarf.getDbSiteSarfID());
            } catch (NoResultException e) {
                kiralamaTablo = new KiralamaTablo();
            }

        }

    }

    public void handleFileUpload(FileUploadEvent e) {
             FileOutputStream fileOutputStream = null;
        try {
            File f = new File("dosyalar");

            if (!f.exists()) {
                f.mkdir();
            }
            String dosyaYeni = new SimpleDateFormat("ddMMyykmsS").format(Calendar.getInstance().getTime()) + new Random().nextInt(9) + e.getFile().getFileName().substring(e.getFile().getFileName().lastIndexOf("."));
            f = new File("dosyalar\\" + dosyaYeni);
            this.tssFrom.setTssDokumanDosyaYolu("dosyalar\\" + dosyaYeni);
            fileOutputStream = new FileOutputStream(f);
            byte[] buffer = e.getFile().getContents();
            int bulk;
            InputStream inputStream = e.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            telekomService.kaydet(this.tssFrom);
            FacesMessage msg = new FacesMessage(e.getFile().getFileName() + " dosyası başarı ile gönderildi.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception ex) {
            ex.getStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void downloadDokuman(String dosyaAd) {
        FacesContext fc = FacesContext.getCurrentInstance();

        ServletContext context = (ServletContext) fc.getExternalContext().getContext();
        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        response.setContentType("application/force-download");
        String downloadFile = dosyaAd;
        response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile + "\"");
        byte[] buf = new byte[1024];
        try {
            File file = new File(dosyaAd);
            long length = file.length();
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            ServletOutputStream out = response.getOutputStream();
            response.setContentLength((int) length);
            while ((in != null) && ((length = in.read(buf)) != -1)) {
                out.write(buf, 0, (int) length);
            }
            in.close();
            out.close();
            fc.responseComplete();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public void saveYapilanIs_actionListener() {
        try {
            if (this.yapilanisler.getDbYapilanIslerID() == null) {
                yapilanisler.setDbAltIslemTipiID(telekomService.findAltIslemById(altIslemId));
                yapilanisler.setDbUstIslemTipiID(telekomService.findUStIslemById(ustIslemId));
                this.yapilanisler.setDbSiteSarfID(siteSarf);
                this.telekomService.kaydet(yapilanisler);
            } else {

                this.telekomService.guncelle(yapilanisler);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
            this.yapilanisler = new Yapilanisler();
            yapilanislerList = telekomService.findYapilanIslerBySitePlanlananId(siteSarf.getDbSiteSarfID());
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void saveYorum_actionListener() {
        try {
            if (this.yorumlarTablo.getDbYorumlarID() == null) {
                //yorumlarTablo.setDbAltIslemTipiID(telekomService.findAltIslemById(altIslemId));
                this.yorumlarTablo.setDbSiteSarfID(siteSarf);
                this.telekomService.kaydet(yorumlarTablo);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("Kiralama"));
                yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(41,6));
                telekomService.kaydet(yi);
            } else {
                this.telekomService.guncelle(yorumlarTablo);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("Kiralama"));
                yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(41,6));
                telekomService.kaydet(yi);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
            this.yorumlarTablo = new YorumlarTablo();
            yorumlarList = telekomService.findAllYorumBySiteSarfId(siteSarf.getDbSiteSarfID());
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void saveKapsananYerler_actionListener() {
        try {
            if (this.kapsananYerler.getDbKapsananYerlerID() == null) {
                this.kapsananYerler.setDbSiteSarfID(siteSarf);
                this.telekomService.kaydet(kapsananYerler);
            } else {
                this.telekomService.guncelle(kapsananYerler);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void saveTSSForm_actionListener() {
        try {
            if (this.tssFrom.getDbTSSRID() == null) {
                this.tssFrom.setDbSiteSarfID(siteSarf);
                this.telekomService.kaydet(tssFrom);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("TSS Formu"));

                if (this.tssFrom.getTssOnayDurumu().equals("Onaylandi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(43,7));
                }
                if (this.tssFrom.getTssOnayDurumu().equals("Beklemede")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(42,7));
                }
                if (this.tssFrom.getTssOnayDurumu().equals("Reddedildi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(44,7));
                }
                telekomService.kaydet(yi);
                telekomService.kaydet(yi);
            } else {
                this.telekomService.guncelle(tssFrom);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("TSS Formu"));

                if (this.tssFrom.getTssOnayDurumu().equals("Onaylandi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(43,7));
                }
                if (this.tssFrom.getTssOnayDurumu().equals("Beklemede")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(42,7));
                }
                if (this.tssFrom.getTssOnayDurumu().equals("Reddedildi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(44,7));
                }
                telekomService.kaydet(yi);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void saveKiralamaTablo_actionListener() {
        try {
            if (this.kiralamaTablo.getDbSAID() == null) {
                this.kiralamaTablo.setDbSiteSarfID(siteSarf);
                this.telekomService.kaydet(kiralamaTablo);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("Kiralama"));

                if (this.kiralamaTablo.getKiralamaDurum().equals("Beklemede")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(38,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Görüsülüyor")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(37,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Kiralandi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(39,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Reddedildi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(40,6));
                }
                telekomService.kaydet(yi);

            } else {
                this.telekomService.guncelle(kiralamaTablo);
                Yapilanisler yi = new Yapilanisler();
                yi.setGerceklesenBaslamaTarihi(Calendar.getInstance());
                yi.setGerceklesenBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBitisTarihi(Calendar.getInstance());
                yi.setPlanlananBaslamaTarihi(Calendar.getInstance());
                yi.setDbSiteSarfID(siteSarf);
                yi.setDbUstIslemTipiID(telekomService.findUStIslemByUStIslemAd("Kiralama"));
                if (this.kiralamaTablo.getKiralamaDurum().equals("Beklemede")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(38,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Görüsülüyor")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(37,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Kiralandi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(39,6));
                }
                if (this.kiralamaTablo.getKiralamaDurum().equals("Reddedildi")) {
                    yi.setDbAltIslemTipiID(telekomService.findAltIslemByAltIslemAd(40,6));
                }
                telekomService.kaydet(yi);

            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void remove_actionListener() {
        if (this.rowId != null) {
            this.telekomService.sil(this.telekomService.findTssFormById(this.rowId));
            this.tssFrom = new TssForm();
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Kayit Silinmistir.", FacesMessage.SEVERITY_INFO);
        } else {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Tablodan Kayit Seciniz:", FacesMessage.SEVERITY_WARN);
        }
    }

    public void row_selectListener(SelectEvent e) {
        e.getSource();
    }

    public String sitePlanlananYonlendir(SiteSarf site) {
        //this.util.getSessionMap(FacesContext.getCurrentInstance()).put("sitePlanlanan", sitePlanlanan);
        this.util.getSessionMap(FacesContext.getCurrentInstance()).put("selectedSiteSarf", site);
        return "tssForm";
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">
    public Logger getLogger() {
        return logger;
    }

    public List<YorumlarTablo> getYorumlarList() {
        return yorumlarList;
    }

    public void setYorumlarList(List<YorumlarTablo> yorumlarList) {
        this.yorumlarList = yorumlarList;
    }

    public KapsananYerler getKapsananYerler() {
        return kapsananYerler;
    }

    public void setKapsananYerler(KapsananYerler kapsananYerler) {
        this.kapsananYerler = kapsananYerler;
    }

    public List<Yapilanisler> getYapilanislerList() {
        return yapilanislerList;
    }

    public Integer getAltIslemId() {
        return altIslemId;
    }

    public void setAltIslemId(Integer altIslemId) {
        this.altIslemId = altIslemId;
    }

    public Integer getUstIslemId() {
        return ustIslemId;
    }

    public void setUstIslemId(Integer ustIslemId) {
        this.ustIslemId = ustIslemId;
    }

    public void setYapilanislerList(List<Yapilanisler> yapilanislerList) {
        this.yapilanislerList = yapilanislerList;
    }

    public KiralamaTablo getKiralamaTablo() {
        return kiralamaTablo;
    }

    public YorumlarTablo getYorumlarTablo() {
        return yorumlarTablo;
    }

    public void setYorumlarTablo(YorumlarTablo yorumlarTablo) {
        this.yorumlarTablo = yorumlarTablo;
    }

    public void setKiralamaTablo(KiralamaTablo kiralamaTablo) {
        this.kiralamaTablo = kiralamaTablo;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public SitePlanlanan getSitePlanan() {
        return sitePlanan;
    }

    public void setSitePlanan(SitePlanlanan sitePlanan) {
        this.sitePlanan = sitePlanan;
    }

    public SiteSarf getSiteSarf() {
        return siteSarf;
    }

    public void setSiteSarf(SiteSarf siteSarf) {
        this.siteSarf = siteSarf;
    }

    public TelekomService getTelekomService() {
        return telekomService;
    }

    public void setTelekomService(TelekomService telekomService) {
        this.telekomService = telekomService;
    }

    public TssForm getTssFrom() {
        return tssFrom;
    }

    public void setTssFrom(TssForm tssFrom) {
        this.tssFrom = tssFrom;
    }

    public WebUtil getUtil() {
        return util;
    }

    public void setUtil(WebUtil util) {
        this.util = util;
    }

    public Yapilanisler getYapilanisler() {
        return yapilanisler;
    }

    public void setYapilanisler(Yapilanisler yapilanisler) {
        this.yapilanisler = yapilanisler;
    }
    //</editor-fold>
}
