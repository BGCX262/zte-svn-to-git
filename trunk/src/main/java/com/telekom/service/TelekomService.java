/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.service;


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
import java.util.List;
import java.util.Map;

/**
 *
 * @author esimsek
 */
public interface TelekomService {

    void kaydet(IlcelerTablo o);

    void sil(IlcelerTablo o);

    void guncelle(IlcelerTablo o);

    void kaydet(KapsananYerler o);

    void sil(KapsananYerler o);

    void guncelle(KapsananYerler o);

    void kaydet(KiralamaTablo o);

    void sil(KiralamaTablo o);

    void guncelle(KiralamaTablo o);

    SitePlanlanan findSitePlanlanan(Integer id);

    void kaydet(SehirlerTablo o);

    void sil(SehirlerTablo o);

    void guncelle(SehirlerTablo o);

    void kaydet(SitePlanlanan o);

    void sil(SitePlanlanan o);

    void guncelle(SitePlanlanan o);

    List<SitePlanlanan> findAllSitePlanlanan();

    void kaydet(SiteSarf o);

    void sil(SiteSarf o);

    void guncelle(SiteSarf o);

    void kaydet(TssForm o);

    void sil(TssForm o);

    void guncelle(Altislemtipi o);

    void kaydet(Altislemtipi o);

    void sil(Altislemtipi o);

    void guncelle(Ustislemtipi o);

    void kaydet(Ustislemtipi o);

    void sil(Ustislemtipi o);

    void guncelle(TssForm o);

    List<TssForm> findAllTssForm();

    TssForm findTssFormById(Integer id);

    void kaydet(YorumlarTablo o);

    void sil(YorumlarTablo o);

    void guncelle(YorumlarTablo o);
    
    void sahaSarfKaydet(SiteSarf ss,Boolean isKaydet);

    void sitePlanlananKaydet(SitePlanlanan sp,Integer ilKod,Integer ilceKod,Boolean isKaydet);

    public SiteSarf findSiteSarfById(Integer sarfId);

    public List<KiralamaTablo> findAllKiralama();

    public List<KapsananYerler> findAllKapsananYer();

    public List<IlcelerTablo> findIlceByIl(Integer ilId);

    public List<SiteSarf> findSiteSarfBySitePlananlanan(Integer ilId);

    public List<SehirlerTablo> findAllSehirler();

    public List<SitePlanlanan> lazyLoadSitePlananlanan(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters);

    public void removeSiteSarf(Integer sarfId);

    public void removeSitePlanlanan(Integer planId);

    public List<Altislemtipi> findAllAltIslemTip();

    public List<Ustislemtipi> findAllUstIslemTip();

    public List<Yapilanisler> findYapilanIslerBySitePlanlananId(Integer dbSiteID);

    public void kaydet(Yapilanisler yapilanisler);

    public void guncelle(Yapilanisler yapilanisler);

    public Altislemtipi findAltIslemById(Integer altIslemId);

    public Ustislemtipi findUStIslemById(Integer ustIslemId);

    public KapsananYerler findKapsananYerlerBySiteSarfId(Integer dbSiteSarfID);

    public TssForm findTssFormBySiteSarfId(Integer dbSiteSarfID);

    public KiralamaTablo findKiralamaTabloBySiteSarfId(Integer dbSiteSarfID);

    public List<YorumlarTablo> findAllYorumBySiteSarfId(Integer dbSiteSarfID);

    public List<Altislemtipi> findAltIslemByUstIslemId(Integer ilId);

    public Ustislemtipi findUStIslemByUStIslemAd(String string);

    public Altislemtipi findAltIslemByAltIslemAd(int altislemid,int ustislemId);
    
    public List<SiteSarf> findAllSiteSarfs();

}
