package com.telekom.web.bean;

import com.telekom.entity.IlcelerTablo;
import com.telekom.entity.SehirlerTablo;
import com.telekom.entity.SitePlanlanan;
import com.telekom.entity.SiteSarf;
import com.telekom.entity.Yapilanisler;
import com.telekom.enums.EnumOnayDurum;
import com.telekom.service.TelekomService;
import com.telekom.web.util.ApplicationBean;
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
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author esimsek
 */
@ManagedBean
@ViewScoped
public class SitePlanlananBean {
    // <editor-fold defaultstate="collapsed" desc="PROPERTIES">

    @ManagedProperty(value = "#{TelekomService}")
    private TelekomService telekomService;
    private List<SitePlanlanan> planlanans;
    @ManagedProperty(value = "#{sessionBean}")
    private SessionBean sessionBean;
    @ManagedProperty(value = "#{applicationBean}")
    private ApplicationBean applicationBean;
    private SitePlanlanan selectedRow = new SitePlanlanan();
    private WebUtil util = new WebUtil();
    private Integer rowId;
    private Integer remove_sarf_row_id;
    private Logger logger = LoggerFactory.getLogger(SitePlanlananBean.class);
    public LazyDataModel<SitePlanlanan> lazyModel;
    private List<SiteSarf> siteSarfs;
    private SitePlanlanan sitePlanlanan;
    private SiteSarf selectedRow_sf = new SiteSarf();
    private Integer ilKod;
    private Integer ilceKod;
    private Boolean render_dtPlanlanan;
    private List<SelectItem> ilce = new ArrayList<SelectItem>();
    private Integer sitePlanlananId;
    List<Yapilanisler> yapilanislers = new ArrayList<Yapilanisler>();
    //</editor-fold>

    public SitePlanlananBean() {
    }

    public void init4Planlanan() {
        this.planlanans = this.telekomService.findAllSitePlanlanan();
        selectedRow = new SitePlanlanan();
        SehirlerTablo st = new SehirlerTablo();
        IlcelerTablo ilce = new IlcelerTablo();
        selectedRow.setSehirID(st);
        selectedRow.setIlceID(ilce);
        lazyModel = new LazyDataModel<SitePlanlanan>() {

            @Override
            public List<SitePlanlanan> load(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
                List<SitePlanlanan> liste = telekomService.lazyLoadSitePlananlanan(first, pageSize, sortField, sortOrder, filters);
                return liste;
            }
        };
        lazyModel.setRowCount(planlanans.size());
        this.ilKod = null;
        this.ilceKod = null;
    }

    @PostConstruct
    public void init() {
        if (!this.util.isPostBack(FacesContext.getCurrentInstance())) {
            this.init4Planlanan();
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
            this.selectedRow_sf.setSarfDokumanDosyaYolu("dosyalar\\" + dosyaYeni);
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

    public void save_actionListener() {
        try {
            if (this.selectedRow.getDbSiteID() == null) {
                selectedRow.setVendor(sessionBean.getUserTablo().getVendor());
                this.telekomService.sitePlanlananKaydet(selectedRow, ilKod, ilceKod, Boolean.TRUE);
            } else {
                selectedRow.setVendor(sessionBean.getUserTablo().getVendor());
                this.telekomService.sitePlanlananKaydet(selectedRow, ilKod, ilceKod, Boolean.FALSE);
            }
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Isleminiz Basarili Sekilde Kaydedilmistir", FacesMessage.SEVERITY_INFO);
            this.init4Planlanan();
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
    }

    public void remove_actionListener() {
        if (this.rowId != null) {
            //this.telekomService.sil(this.telekomService.findSitePlanlanan(this.rowId));
            this.telekomService.removeSitePlanlanan(rowId);
            this.planlanans = this.telekomService.findAllSitePlanlanan();
            this.selectedRow = new SitePlanlanan();
            this.setRender_dtPlanlanan(false);
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Kayit Silinmistir.", FacesMessage.SEVERITY_INFO);
        } else {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Tablodan Kayit Seciniz:", FacesMessage.SEVERITY_WARN);
        }
    }

    public void row_selectListener(SelectEvent e) {
        try {
            e.getSource();
            this.ilKod = ((SitePlanlanan) e.getObject()).getSehirID().getDbSehirID();
            this.ilce = this.getApplicationBean().ilce4SelectList(String.valueOf(this.ilKod));
            this.ilceKod = ((SitePlanlanan) e.getObject()).getIlceID().getDbIlceId();
        } catch (Exception ex) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Hata:" + ex.getMessage(), FacesMessage.SEVERITY_ERROR);
            ex.printStackTrace();
        }
    }

    public void detaySitePlanlanan_actionListener(SitePlanlanan site) {
        if (site != null && site.getDbSiteID() != null) {
            this.sitePlanlananId = site.getDbSiteID();
            this.selectedRow = site;
            this.siteSarfs = this.telekomService.findSiteSarfBySitePlananlanan(site.getDbSiteID());
            this.sarf_initBean();
            Integer onaylananSarfId = null;
            for (int i = 0; i < siteSarfs.size(); i++) {
                SiteSarf ss = siteSarfs.get(i);
                if (ss != null && ((ss.getIsColocated() != null && ss.getIsColocated())|| (ss.getOnayDurum()!=null && ss.getOnayDurum().equals(EnumOnayDurum.Onaylandi)))) {
                    onaylananSarfId = ss.getDbSiteSarfID();
                    break;
                }
            }
            if (onaylananSarfId != null) {
                this.yapilanislers = this.telekomService.findYapilanIslerBySitePlanlananId(onaylananSarfId);
            }
            this.setRender_dtPlanlanan(true);
        } else {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Site Plananlana Tablosundan Kayit Seciniz", FacesMessage.SEVERITY_WARN);
        }
    }
//***************************************************SITE SARF FONSIYONLAR**************************************************************//
//***************************************************SITE SARF FONSIYONLAR**************************************************************//
//***************************************************SITE SARF FONSIYONLAR**************************************************************//

    public void sarf_row_selectListener(SelectEvent e) {
        try {
            e.getSource();

        } catch (Exception ex) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Hata:" + ex.getMessage(), FacesMessage.SEVERITY_ERROR);
            ex.printStackTrace();
        }
    }

    public void sarf_sehir_valueChangeListener(ValueChangeEvent e) {
        try {
            Object il = e.getNewValue() == null ? "0" : e.getNewValue();
            this.ilKod = (Integer) il;
            this.ilce = this.getApplicationBean().ilce4SelectList(String.valueOf(il));
        } catch (Exception ex) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Hata:" + ex.getMessage(), FacesMessage.SEVERITY_ERROR);
            ex.printStackTrace();
        }

    }

    public void sarf_findIlceId(Integer il) {
        try {
            this.ilce = this.getApplicationBean().ilce4SelectList(String.valueOf(il));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sarf_initBean() {
        selectedRow_sf = new SiteSarf();
//        SehirlerTablo st = new SehirlerTablo();
//        IlcelerTablo ilce = new IlcelerTablo();
//        selectedRow_sf.setSehir(st);
//        selectedRow_sf.setIlce(ilce);
    }

    public String sarf_save_actionListener() {
        try {
            if (this.sitePlanlananId != null) {
                sitePlanlanan = this.telekomService.findSitePlanlanan(this.sitePlanlananId);
                this.selectedRow_sf.setDbSiteID(sitePlanlanan);
                if (this.selectedRow_sf.getDbSiteSarfID() == null) {
                    selectedRow_sf.setDbSiteID(sitePlanlanan);
                    this.telekomService.sahaSarfKaydet(selectedRow_sf, Boolean.TRUE);
                } else {
                    this.telekomService.sahaSarfKaydet(selectedRow_sf, Boolean.FALSE);
                }
                this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Kayıt işlemi başarılı", FacesMessage.SEVERITY_INFO);
                this.siteSarfs = this.telekomService.findSiteSarfBySitePlananlanan(this.sitePlanlananId);
                this.selectedRow_sf = new SiteSarf();

            } else {
                this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Site Planlanan Tablosundan Kayit Seciniz", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "HATA:-" + e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
            return null;
        }
        return "sitePlanlanan";
    }

    public void sarf_remove_actionListener() {
        if (this.remove_sarf_row_id != null) {
            this.telekomService.removeSiteSarf(this.remove_sarf_row_id);
            this.siteSarfs = this.telekomService.findSiteSarfBySitePlananlanan(this.sitePlanlananId);
            this.selectedRow_sf = new SiteSarf();
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Kayit Silinmistir.", FacesMessage.SEVERITY_INFO);
        } else {
            this.util.showFacesMessage(FacesContext.getCurrentInstance(), "Tablodan Kayit Seciniz:", FacesMessage.SEVERITY_WARN);
        }
    }

    public void yeniIcinFormHazirla() {
        this.selectedRow = new SitePlanlanan();
        this.init4Planlanan();
    }

      public String sitePlanlananYonlendir(SiteSarf site) {
        //this.util.getSessionMap(FacesContext.getCurrentInstance()).put("sitePlanlanan", sitePlanlanan);
        this.util.getSessionMap(FacesContext.getCurrentInstance()).put("selectedSiteSarf", site);
        return "tssForm";
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS && SETTERS">

    public List<SitePlanlanan> getPlanlanans() {
        return planlanans;
    }

    public List<Yapilanisler> getYapilanislers() {
        return yapilanislers;
    }

    public void setYapilanislers(List<Yapilanisler> yapilanislers) {
        this.yapilanislers = yapilanislers;
    }

    public Boolean getRender_dtPlanlanan() {
        return render_dtPlanlanan;
    }

    public void setRender_dtPlanlanan(Boolean render_dtPlanlanan) {
        this.render_dtPlanlanan = render_dtPlanlanan;
    }

    public LazyDataModel<SitePlanlanan> getLazyModel() {
        return lazyModel;
    }

    public Integer getIlKod() {
        return ilKod;
    }

    public void setIlKod(Integer ilKod) {
        this.ilKod = ilKod;
    }

    public List<SelectItem> getIlce() {
        return ilce;
    }

    public void setIlce(List<SelectItem> ilce) {
        this.ilce = ilce;
    }

    public Integer getIlceKod() {
        return ilceKod;
    }

    public void setIlceKod(Integer ilceKod) {
        this.ilceKod = ilceKod;
    }

    public void setLazyModel(LazyDataModel<SitePlanlanan> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public SiteSarf getSelectedRow_sf() {
        return selectedRow_sf;
    }

    public void setSelectedRow_sf(SiteSarf selectedRow_sf) {
        this.selectedRow_sf = selectedRow_sf;
    }

    public SitePlanlanan getSitePlanlanan() {
        return sitePlanlanan;
    }

    public void setSitePlanlanan(SitePlanlanan sitePlanlanan) {
        this.sitePlanlanan = sitePlanlanan;
    }

    public List<SiteSarf> getSiteSarfs() {
        return siteSarfs;
    }

    public void setSiteSarfs(List<SiteSarf> siteSarfs) {
        this.siteSarfs = siteSarfs;
    }

    public ApplicationBean getApplicationBean() {
        return applicationBean;
    }

    public void setApplicationBean(ApplicationBean applicationBean) {
        this.applicationBean = applicationBean;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public WebUtil getUtil() {
        return util;
    }

    public void setUtil(WebUtil util) {
        this.util = util;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public void setPlanlanans(List<SitePlanlanan> planlanans) {
        this.planlanans = planlanans;
    }

    public SitePlanlanan getSelectedRow() {
        return selectedRow;
    }

    public Integer getSitePlanlananId() {
        return sitePlanlananId;
    }

    public void setSitePlanlananId(Integer sitePlanlananId) {
        this.sitePlanlananId = sitePlanlananId;
    }

    public void setSelectedRow(SitePlanlanan selectedRow) {
        this.selectedRow = selectedRow;
    }

    public TelekomService getTelekomService() {
        return telekomService;
    }

    public Integer getRemove_sarf_row_id() {
        return remove_sarf_row_id;
    }

    public void setRemove_sarf_row_id(Integer remove_sarf_row_id) {
        this.remove_sarf_row_id = remove_sarf_row_id;
    }

    public void setTelekomService(TelekomService telekomService) {
        this.telekomService = telekomService;
    }
    //</editor-fold>
}
