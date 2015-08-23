/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telekom.dao;


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
public interface TelekomDAO {

    SiteSarf findSiteSarfById(Integer sarfId);

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

    List<SitePlanlanan> findAllSitePlanlanan();

    void sil(SitePlanlanan o);

    void guncelle(SitePlanlanan o);

    void kaydet(SiteSarf o);

    void sil(SiteSarf o);

    void guncelle(SiteSarf o);

    void kaydet(TssForm o);

    void sil(TssForm o);

    void guncelle(TssForm o);

    void kaydet(YorumlarTablo o);

    void sil(YorumlarTablo o);

    void guncelle(YorumlarTablo o);

    List<TssForm> findAllTssForm();

    SehirlerTablo findBySehirlerTablo(Integer id);

    TssForm findTssFormById(Integer id);

    IlcelerTablo findByIlcelerTablo(Integer id);

    public List<KiralamaTablo> findAllKiralama();

    public List<KapsananYerler> findAllKapsananYer();

    public List<IlcelerTablo> findIlceByIl(Integer ilId);

    public List<SiteSarf> findSiteSarfBySitePlananlanan(Integer ilId);

    public List<SehirlerTablo> findAllSehirler();

    public List<SitePlanlanan> lazyLoadSitePlananlanan(int first, int pageSize, String sortField, boolean sortOrder, Map filters);

    public void kaydet(IlcelerTablo o);

    public void sil(IlcelerTablo o);

    public void guncelle(IlcelerTablo o);

    public List<Altislemtipi> findAllAltIslemTip();

    public List<Ustislemtipi> findAllUstIslemTip();

    public List<Yapilanisler> findYapilanIslerBySitePlanlananId(Integer dbSiteID);

    public void guncelle(Yapilanisler yapilanisler);

    public void kaydet(Yapilanisler yapilanisler);

    public Altislemtipi findAltIslemById(Integer altIslemId);

    public Ustislemtipi findUStIslemById(Integer ustIslemId);

    public void guncelle(Altislemtipi o);

    public void kaydet(Altislemtipi o);

    public void sil(Altislemtipi o);

    public void guncelle(Ustislemtipi o);

    public void kaydet(Ustislemtipi o);

    public void sil(Ustislemtipi o);

    public KapsananYerler findKapsananYerlerBySiteSarfId(Integer dbSiteSarfID);

    public TssForm findTssFormBySiteSarfId(Integer dbSiteSarfID);

    public KiralamaTablo findKiralamaTabloBySiteSarfId(Integer dbSiteSarfID);

    public List<YorumlarTablo> findAllYorumBySiteSarfId(Integer dbSiteSarfID);

    public List<Altislemtipi> findAltIslemByUstIslemId(Integer Id);

    public Ustislemtipi findUStIslemByUStIslemAd(String string);
    
    public Altislemtipi findAltIslemByAltIslemAd(int altislemid,int ustislemId);

    public List<SiteSarf> findAllSiteSarfs();

    public List<TssForm> findAllTssFormBySiteSarfId(Integer siteSarfId);

    public List<KiralamaTablo> findAllKiralamaBySiteSarfId(Integer siteSarfId);

    public List<KapsananYerler> findAllKapsananYerlerBySiteSarfId(Integer siteSarfId);

    public void sil(Yapilanisler ky);
}
