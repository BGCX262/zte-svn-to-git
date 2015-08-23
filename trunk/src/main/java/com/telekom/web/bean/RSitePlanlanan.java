/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.web.bean;

import com.telekom.entity.SitePlanlanan;
import com.telekom.entity.SiteSarf;
import com.telekom.enums.EnumOnayDurum;
import com.telekom.service.TelekomService;
import com.telekom.web.util.WebUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author erman
 */
@ManagedBean
@ViewScoped
public class RSitePlanlanan implements Serializable {

    private String k_bolge;
    private WebUtil util = new WebUtil();
    private List<SitePlanlanan> splanlanans = new ArrayList<SitePlanlanan>();
    private List<SiteSarf> siteSarfs = new ArrayList<SiteSarf>();
    @ManagedProperty(value = "#{TelekomService}")
    private TelekomService telekomService;
    private int count4Onaylandi;
    private int count4Beklemede;
    private int count4Reddedildi;

    @PostConstruct
    public void init() {
        this.splanlanans=this.telekomService.findAllSitePlanlanan();
        this.siteSarfs=this.telekomService.findAllSiteSarfs();
    }

    public void islem(){
        List<String> bolgeler=new ArrayList();
        if(this.siteSarfs!=null){
            for (int i = 0; i < siteSarfs.size(); i++) {
                SiteSarf sf = siteSarfs.get(i);
                if(!bolgeler.contains(sf.getDbSiteID().getBolge().getValue())){
                    bolgeler.add(sf.getDbSiteID().getBolge().getValue());
                }
            }
            for (int i = 0; i < bolgeler.size(); i++) {
                String s = bolgeler.get(i);
                for (int j = 0; j < this.siteSarfs.size(); j++) {
                    SiteSarf r= this.siteSarfs.get(j);
                    if(s.equalsIgnoreCase(r.getDbSiteID().getBolge().getValue())){

                    }
                }
            }

        }
    }

    public void search_actionListener() {
        if (k_bolge != null && !k_bolge.isEmpty() && !k_bolge.equalsIgnoreCase("-1")) {
        } else {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Bolge Seciniz", FacesMessage.SEVERITY_WARN);
        }
    }

    public int hesapla(SiteSarf row,String dur,String bolge){
        this.count4Onaylandi=0;
        for(int i=0;i<this.siteSarfs.size();i++){
            SiteSarf r=siteSarfs.get(i);
            if(r.getDbSiteID().getBolge().name().equalsIgnoreCase(bolge)&&r.getOnayDurum().getValue().equalsIgnoreCase("Onaylandi")){
                this.count4Onaylandi+=1;
            }
        }
        return count4Onaylandi;
    }
    public int hesapla2(SiteSarf row,String dur,String bolge){
      this.count4Beklemede=0;
        for(int i=0;i<this.siteSarfs.size();i++){
            SiteSarf r=siteSarfs.get(i);
            if(r.getDbSiteID().getBolge().name().equalsIgnoreCase(bolge)&&r.getOnayDurum().getValue().equalsIgnoreCase("Beklemede")){
                this.count4Beklemede+=1;
            }
        }
        return count4Beklemede;
    }
    public int hesapla3(SiteSarf row,String dur,String bolge){
         this.count4Reddedildi=0;
        for(int i=0;i<this.siteSarfs.size();i++){
            SiteSarf r=siteSarfs.get(i);
            if(r.getDbSiteID().getBolge().name().equalsIgnoreCase(bolge)&&r.getOnayDurum().getValue().equalsIgnoreCase("Reddedildi")){
                this.count4Reddedildi+=1;
            }
        }
        return count4Reddedildi;
    }

    //<editor-fold>
    public String getK_bolge() {
        return k_bolge;
    }

    public List<SiteSarf> getSiteSarfs() {
        return siteSarfs;
    }

    public void setSiteSarfs(List<SiteSarf> siteSarfs) {
        this.siteSarfs = siteSarfs;
    }

    public List<SitePlanlanan> getSplanlanans() {
        return splanlanans;
    }

    public TelekomService getTelekomService() {
        return telekomService;
    }

    public void setTelekomService(TelekomService telekomService) {
        this.telekomService = telekomService;
    }

    public void setSplanlanans(List<SitePlanlanan> splanlanans) {
        this.splanlanans = splanlanans;
    }

    public void setK_bolge(String k_bolge) {
        this.k_bolge = k_bolge;
    }

    public int getCount4Beklemede() {
        return count4Beklemede;
    }

    public void setCount4Beklemede(int count4Beklemede) {
        this.count4Beklemede = count4Beklemede;
    }

    public int getCount4Onaylandi() {
        return count4Onaylandi;
    }

    public int getCount4Reddedildi() {
        return count4Reddedildi;
    }

    public void setCount4Reddedildi(int count4Reddedildi) {
        this.count4Reddedildi = count4Reddedildi;
    }

    public void setCount4Onaylandi(int count4Onaylandi) {
        this.count4Onaylandi = count4Onaylandi;
    }

    //</editor-fold>
}
