/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.web.bean;

import com.telekom.entity.Altislemtipi;
import com.telekom.entity.SitePlanlanan;
import com.telekom.entity.Ustislemtipi;
import com.telekom.service.TelekomService;
import com.telekom.web.util.ApplicationBean;
import com.telekom.web.util.WebUtil;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author esimsek
 */
@ManagedBean
@SessionScoped
public class IslemEkleBean {
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">

    @ManagedProperty(value = "#{TelekomService}")
    private TelekomService telekomService;
    private List<SitePlanlanan> planlanans;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    @ManagedProperty(value = "#{applicationBean}")
    private ApplicationBean applicationBean;
    private Altislemtipi altislemtipi;
    private List<Altislemtipi> altislemtipList;
    private Ustislemtipi ustislemtipi;
    private List<Ustislemtipi> ustislemtipList;
    private WebUtil util = new WebUtil();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="METHODS">
    @PostConstruct
    public void init() {
        if (!this.util.isPostBack(FacesContext.getCurrentInstance())) {
            this.initEntities();
        }

    }

    private void initEntities() {
        altislemtipi = new Altislemtipi();
        ustislemtipi = new Ustislemtipi();
        altislemtipList = telekomService.findAllAltIslemTip();
        ustislemtipList = telekomService.findAllUstIslemTip();
    }

    public void saveAltIslemTip_actionListener() {
        try {
            if (this.altislemtipi.getDbAltIslemTipiID() == null) {
                this.telekomService.guncelle(altislemtipi);
            } else {
                telekomService.kaydet(altislemtipi);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Isleminiz Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
            this.initEntities();
            applicationBean.init();
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
    }

    public void saveUstIslemTip_actionListener() {
        try {
            if (this.ustislemtipi.getDbUstIslemTipiID() == null) {
                this.telekomService.guncelle(ustislemtipi);
            } else {
                telekomService.kaydet(ustislemtipi);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Isleminiz Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
            this.initEntities();
            applicationBean.init();
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETTER&SETTER">
    public Altislemtipi getAltislemtipi() {
        return altislemtipi;
    }

    public void setAltislemtipi(Altislemtipi altislemtipi) {
        this.altislemtipi = altislemtipi;
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public List<SitePlanlanan> getPlanlanans() {
        return planlanans;
    }

    public void setPlanlanans(List<SitePlanlanan> planlanans) {
        this.planlanans = planlanans;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public TelekomService getTelekomService() {
        return telekomService;
    }

    public void setTelekomService(TelekomService telekomService) {
        this.telekomService = telekomService;
    }

    public Ustislemtipi getUstislemtipi() {
        return ustislemtipi;
    }

    public void setUstislemtipi(Ustislemtipi ustislemtipi) {
        this.ustislemtipi = ustislemtipi;
    }

    public List<Altislemtipi> getAltislemtipList() {
        return altislemtipList;
    }

    public void setAltislemtipList(List<Altislemtipi> altislemtipList) {
        this.altislemtipList = altislemtipList;
    }

    public List<Ustislemtipi> getUstislemtipList() {
        return ustislemtipList;
    }

    public void setUstislemtipList(List<Ustislemtipi> ustislemtipList) {
        this.ustislemtipList = ustislemtipList;
    }
    //</editor-fold>
}
