package com.telekom.service;

import com.telekom.dao.TelekomDAO;
import com.telekom.entity.Altislemtipi;
import com.telekom.entity.IlcelerTablo;
import com.telekom.entity.KapsananYerler;
import com.telekom.entity.KiralamaTablo;
import com.telekom.entity.SehirlerTablo;
import com.telekom.entity.SitePlanlanan;
import com.telekom.entity.SiteSarf;
import com.telekom.entity.TssForm;
import com.telekom.entity.Ustislemtipi;
import com.telekom.entity.Yapilanisler;
import com.telekom.entity.YorumlarTablo;
import java.lang.Integer;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author esimsek
 */
@Service(value = "TelekomService")
public class TelekomServiceImpl implements TelekomService {

    @Autowired
    private TelekomDAO telekomDAO;

    @Transactional
    public SiteSarf findSiteSarfById(Integer sarfId) {
        return this.telekomDAO.findSiteSarfById(sarfId);
    }

    @Transactional
    public void kaydet(IlcelerTablo o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(IlcelerTablo o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(IlcelerTablo o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(KapsananYerler o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(KapsananYerler o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(KapsananYerler o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(KiralamaTablo o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(KiralamaTablo o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(KiralamaTablo o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(SehirlerTablo o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(SehirlerTablo o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(SehirlerTablo o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(SitePlanlanan o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(SitePlanlanan o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(SitePlanlanan o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(SiteSarf o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(SiteSarf o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(SiteSarf o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(TssForm o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(TssForm o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(TssForm o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(YorumlarTablo o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(YorumlarTablo o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(YorumlarTablo o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public List<SitePlanlanan> findAllSitePlanlanan() {
        return this.telekomDAO.findAllSitePlanlanan();
    }

    @Transactional
    public SitePlanlanan findSitePlanlanan(Integer id) {
        return this.telekomDAO.findSitePlanlanan(id);
    }

    @Transactional
    public List<TssForm> findAllTssForm() {
        return this.telekomDAO.findAllTssForm();
    }

    @Transactional
    public List<TssForm> findAllTssFormBySiteSarfId(Integer siteSarfId) {
        return this.telekomDAO.findAllTssFormBySiteSarfId(siteSarfId);
    }

    @Transactional
    public List<KiralamaTablo> findAllKiralamaBySiteSarfId(Integer siteSarfId) {
        return this.telekomDAO.findAllKiralamaBySiteSarfId(siteSarfId);
    }

    @Transactional
    public List<KapsananYerler> findAllKapsananYerlerBySiteSarfId(Integer siteSarfId) {
        return this.telekomDAO.findAllKapsananYerlerBySiteSarfId(siteSarfId);
    }

    @Transactional
    public void sahaSarfKaydet(SiteSarf ss, Boolean isKaydet) {
        if (isKaydet) {
            this.kaydet(ss);
        } else {
            this.guncelle(ss);
        }
    }

    @Transactional
    public TssForm findTssFormById(Integer id) {
        return this.telekomDAO.findTssFormById(id);
    }

    @Transactional
    public List<KiralamaTablo> findAllKiralama() {
        return telekomDAO.findAllKiralama();
    }

    @Transactional
    public List<KapsananYerler> findAllKapsananYer() {
        return telekomDAO.findAllKapsananYer();
    }

    @Transactional
    public List<IlcelerTablo> findIlceByIl(Integer ilId) {
        return this.telekomDAO.findIlceByIl(ilId);
    }

    @Transactional
    public List findSiteSarfBySitePlananlanan(Integer ilId) {
        return this.telekomDAO.findSiteSarfBySitePlananlanan(ilId);
    }

    @Transactional
    public List<SehirlerTablo> findAllSehirler() {
        return telekomDAO.findAllSehirler();
    }

    @Transactional
    public List<SitePlanlanan> lazyLoadSitePlananlanan(int first, int pageSize, String sortField, boolean sortOrder, Map filters) {
        return telekomDAO.lazyLoadSitePlananlanan(first, pageSize, sortField, sortOrder, filters);
    }

    @Transactional
    public void removeSiteSarf(Integer sarfId) {
        //SitePlanlanan sp=this.findSitePlanlanan(planlanId);
        SiteSarf sf = this.findSiteSarfById(sarfId);
        this.telekomDAO.sil(sf);
    }

    @Transactional
    public void sitePlanlananKaydet(SitePlanlanan sp, Integer ilKod, Integer ilceKod, Boolean isKaydet) {
        SehirlerTablo st = (SehirlerTablo) this.telekomDAO.findBySehirlerTablo(ilKod);
        IlcelerTablo it = (IlcelerTablo) this.telekomDAO.findByIlcelerTablo(ilceKod);
        sp.setIlceID(it);
        sp.setSehirID(st);
        if (isKaydet) {
            this.kaydet(sp);
        } else {
            this.guncelle(sp);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void removeSitePlanlanan(Integer planId) {
        SitePlanlanan sp = this.findSitePlanlanan(planId);
        List<SiteSarf> sf = this.findSiteSarfBySitePlananlanan(planId);

        for (int i = 0; i < sf.size(); i++) {
            SiteSarf siteSarf = sf.get(i);
            List<TssForm> tfs = this.findAllTssFormBySiteSarfId(planId);
            List<KiralamaTablo> kts = this.findAllKiralamaBySiteSarfId(planId);
            List<KapsananYerler> kys = this.findAllKapsananYerlerBySiteSarfId(planId);
            List<YorumlarTablo> yorum = this.findAllYorumBySiteSarfId(planId);
            List<Yapilanisler> isler = this.findYapilanIslerBySitePlanlananId(planId);
            for (int j = 0; j < tfs.size(); j++) {
                TssForm tf = tfs.get(j);
                tf.setDbSiteSarfID(null);
                this.guncelle(tf);
                this.sil(tf);
            }
            for (int j = 0; j < kts.size(); j++) {
                KiralamaTablo kt = kts.get(j);
                kt.setDbSiteSarfID(null);
                this.guncelle(kt);
                this.sil(kt);
            }
            for (int j = 0; j < kys.size(); j++) {
                KapsananYerler ky = kys.get(j);
                ky.setDbSiteSarfID(null);
                this.guncelle(ky);
                this.sil(ky);
            }
            for (int j = 0; j < yorum.size(); j++) {
                YorumlarTablo ky = yorum.get(j);
                ky.setDbSiteSarfID(null);
                this.guncelle(ky);
                this.sil(ky);
            }
            for (int j = 0; j < isler.size(); j++) {
                Yapilanisler ky = isler.get(j);
                ky.setDbSiteSarfID(null);
                this.guncelle(ky);
                this.sil(ky);
            }
            siteSarf.setDbSiteID(null);
            this.guncelle(siteSarf);
        }
        this.sil(sp);
        for (int i = 0; i < sf.size(); i++) {
            SiteSarf siteSarf = sf.get(i);
            siteSarf.setDbSiteID(null);
            this.sil(siteSarf);
        }
    }

    @Transactional
    public List<Altislemtipi> findAllAltIslemTip() {
        return telekomDAO.findAllAltIslemTip();
    }

    @Transactional
    public List<Ustislemtipi> findAllUstIslemTip() {
        return telekomDAO.findAllUstIslemTip();
    }

    @Transactional
    public List<Yapilanisler> findYapilanIslerBySitePlanlananId(Integer dbSiteID) {
        return telekomDAO.findYapilanIslerBySitePlanlananId(dbSiteID);
    }

    @Transactional
    public void kaydet(Yapilanisler yapilanisler) {
        telekomDAO.kaydet(yapilanisler);
    }

    @Transactional
    public void guncelle(Yapilanisler yapilanisler) {
        telekomDAO.guncelle(yapilanisler);
    }

    @Transactional
    public Altislemtipi findAltIslemById(Integer altIslemId) {
        return telekomDAO.findAltIslemById(altIslemId);
    }

    @Transactional
    public Ustislemtipi findUStIslemById(Integer ustIslemId) {
        return telekomDAO.findUStIslemById(ustIslemId);
    }

    @Transactional
    public void guncelle(Altislemtipi o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(Altislemtipi o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(Altislemtipi o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public void guncelle(Ustislemtipi o) {
        telekomDAO.guncelle(o);
    }

    @Transactional
    public void kaydet(Ustislemtipi o) {
        telekomDAO.kaydet(o);
    }

    @Transactional
    public void sil(Ustislemtipi o) {
        telekomDAO.sil(o);
    }

    @Transactional
    public KapsananYerler findKapsananYerlerBySiteSarfId(Integer dbSiteSarfID) {
        return telekomDAO.findKapsananYerlerBySiteSarfId(dbSiteSarfID);
    }

    @Transactional
    public TssForm findTssFormBySiteSarfId(Integer dbSiteSarfID) {
        return telekomDAO.findTssFormBySiteSarfId(dbSiteSarfID);
    }

    @Transactional
    public KiralamaTablo findKiralamaTabloBySiteSarfId(Integer dbSiteSarfID) {
        return telekomDAO.findKiralamaTabloBySiteSarfId(dbSiteSarfID);
    }

    @Transactional
    public List<YorumlarTablo> findAllYorumBySiteSarfId(Integer dbSiteSarfID) {
        return telekomDAO.findAllYorumBySiteSarfId(dbSiteSarfID);
    }

    @Transactional
    public List<Altislemtipi> findAltIslemByUstIslemId(Integer Id) {
        return this.telekomDAO.findAltIslemByUstIslemId(Id);
    }

    @Transactional
    public Ustislemtipi findUStIslemByUStIslemAd(String string) {
        return this.telekomDAO.findUStIslemByUStIslemAd(string);
    }

    @Transactional
    public Altislemtipi findAltIslemByAltIslemAd(int altislemid, int ustislemId) {
        return this.telekomDAO.findAltIslemByAltIslemAd(altislemid, ustislemId);
    }

    @Transactional
    public List<SiteSarf> findAllSiteSarfs() {
        return this.telekomDAO.findAllSiteSarfs();
    }

    @Transactional
    private void sil(Yapilanisler ky) {
        this.telekomDAO.sil(ky);
    }
}
