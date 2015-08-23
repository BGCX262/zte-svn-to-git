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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author esimsek
 */
@Repository
public class TelekomDAOImpl implements TelekomDAO {

    @PersistenceContext
    private EntityManager em;

    public void kaydet(Object o) {
        em.persist(o);
    }

    public void sil(Object o) {
        em.remove(o);
    }

    public void guncelle(Object o) {
        em.merge(o);
    }

    public void kaydet(IlcelerTablo o) {
        em.persist(o);
    }

    public void sil(IlcelerTablo o) {
        em.remove(o);
    }

    public void guncelle(IlcelerTablo o) {
        em.merge(o);
    }

    public void kaydet(KapsananYerler o) {
        em.persist(o);
    }

    public void sil(KapsananYerler o) {
        em.remove(o);
    }

    public void guncelle(KapsananYerler o) {
        em.merge(o);
    }

    public void kaydet(KiralamaTablo o) {
        em.persist(o);
    }

    public void sil(KiralamaTablo o) {
        em.remove(o);
    }

    public void guncelle(KiralamaTablo o) {
        em.merge(o);
    }

    public SitePlanlanan findSitePlanlanan(Integer id) {
        return em.find(SitePlanlanan.class, id);
    }

    public void kaydet(SehirlerTablo o) {
        em.persist(o);
    }

    public void sil(SehirlerTablo o) {
        em.remove(o);
    }

    public void guncelle(SehirlerTablo o) {
        em.merge(o);
    }

    public void kaydet(SitePlanlanan o) {
        em.persist(o);
    }

    public List<SitePlanlanan> findAllSitePlanlanan() {
        Query q = em.createNamedQuery("SitePlanlanan.findAll");
        return q.getResultList();
    }

    public void sil(SitePlanlanan o) {
        em.remove(o);
    }

    public void guncelle(SitePlanlanan o) {
        em.merge(o);
    }

    public void kaydet(SiteSarf o) {
        em.persist(o);
    }

    public void sil(SiteSarf o) {
        em.remove(o);
    }

    public void guncelle(SiteSarf o) {
        em.merge(o);
    }

    public void kaydet(TssForm o) {
        em.persist(o);
    }

    public void sil(TssForm o) {
        em.remove(o);
    }

    public void guncelle(TssForm o) {
        em.merge(o);
    }

    public void kaydet(YorumlarTablo o) {
        em.persist(o);
    }

    public void sil(YorumlarTablo o) {
        em.remove(o);
    }

    public void guncelle(YorumlarTablo o) {
        em.merge(o);
    }

    public List findAllTssForm() {
        Query q = em.createNamedQuery("TssForm.findAll");
        return q.getResultList();

    }

    public TssForm findTssFormById(Integer id) {
        return em.find(TssForm.class, id);
    }

    public SehirlerTablo findBySehirlerTablo(Integer id) {
        Query q = em.createNamedQuery("SehirlerTablo.findByDbSehirID");
        q.setParameter("dbSehirID", id);
        return (SehirlerTablo) q.getSingleResult();
    }

    public IlcelerTablo findByIlcelerTablo(Integer id) {
        Query q = em.createNamedQuery("IlcelerTablo.findByDbIlceId");
        q.setParameter("dbIlceId", id);
        return (IlcelerTablo) q.getSingleResult();
    }

    public List<KiralamaTablo> findAllKiralama() {
        Query q = em.createNamedQuery("KiralamaTablo.findAll");
        return q.getResultList();
    }

    public List<KapsananYerler> findAllKapsananYer() {
        Query q = em.createNamedQuery("KapsananYerler.findAll");
        return q.getResultList();
    }

    public List<IlcelerTablo> findIlceByIl(Integer ilId) {
        Query q = em.createQuery("SELECT i FROM IlcelerTablo i WHERE i.dbSehirID.id = :sehir");
        q.setParameter("sehir", ilId);
        return q.getResultList();
    }

    public List<SiteSarf> findSiteSarfBySitePlananlanan(Integer ilId) {
        Query q = em.createQuery("SELECT s FROM SiteSarf s WHERE s.dbSiteID.dbSiteID = :sitePlanlanan");
        q.setParameter("sitePlanlanan", ilId);
        return q.getResultList();
    }

    public List<SehirlerTablo> findAllSehirler() {
        Query q = em.createNamedQuery("SehirlerTablo.findAll");
        return q.getResultList();
    }

    public List<SitePlanlanan> lazyLoadSitePlananlanan(int first, int pageSize, String sortField, boolean sortOrder, Map filters) {
        System.err.println("filters" + filters + "sortField" + sortField + "first" + first);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<SitePlanlanan> cq = cb.createQuery(SitePlanlanan.class);
        Root<SitePlanlanan> list = cq.from(SitePlanlanan.class);
        cq.select(list);
        Query q = em.createQuery(cq);
        q.setFirstResult(first);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public SiteSarf findSiteSarfById(Integer sarfId) {
        Query q = em.createNamedQuery("SiteSarf.findByDbSiteSarfID");
        q.setParameter("dbSiteSarfID", sarfId);
        return (SiteSarf) q.getSingleResult();
    }

    public List<Altislemtipi> findAllAltIslemTip() {
        Query q = em.createNamedQuery("Altislemtipi.findAll");
        return q.getResultList();
    }

    public List<Ustislemtipi> findAllUstIslemTip() {
        Query q = em.createNamedQuery("Ustislemtipi.findAll");
        return q.getResultList();
    }

    public List<Yapilanisler> findYapilanIslerBySitePlanlananId(Integer dbSiteID) {
        Query q = em.createQuery("SELECT y FROM Yapilanisler y WHERE y.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID ORDER BY y.dbYapilanIslerID DESC");
        q.setParameter("dbSiteSarfID", dbSiteID);
        return q.getResultList();
    }

    public void guncelle(Yapilanisler yapilanisler) {
        em.merge(yapilanisler);
    }

    public void kaydet(Yapilanisler yapilanisler) {
        em.persist(yapilanisler);
    }

    public Altislemtipi findAltIslemById(Integer altIslemId) {
        return em.find(Altislemtipi.class, altIslemId);
    }

    public Ustislemtipi findUStIslemById(Integer ustIslemId) {
        return em.find(Ustislemtipi.class, ustIslemId);
    }

    public void guncelle(Altislemtipi o) {
        em.merge(o);
    }

    public void kaydet(Altislemtipi o) {
        em.persist(o);
    }

    public void sil(Altislemtipi o) {
        em.remove(o);
    }

    public void guncelle(Ustislemtipi o) {
        em.merge(o);
    }

    public void kaydet(Ustislemtipi o) {
        em.persist(o);
    }

    public void sil(Ustislemtipi o) {
        em.remove(o);
    }

    public KapsananYerler findKapsananYerlerBySiteSarfId(Integer dbSiteSarfID) {
        Query q = em.createQuery("SELECT k FROM KapsananYerler k WHERE k.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", dbSiteSarfID);
        return (KapsananYerler) q.getSingleResult();
    }

    public TssForm findTssFormBySiteSarfId(Integer dbSiteSarfID) {
        Query q = em.createQuery("SELECT t FROM TssForm t WHERE t.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", dbSiteSarfID);
        return (TssForm) q.getSingleResult();
    }

    public KiralamaTablo findKiralamaTabloBySiteSarfId(Integer dbSiteSarfID) {
        Query q = em.createQuery("SELECT k FROM KiralamaTablo k WHERE k.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", dbSiteSarfID);
        return (KiralamaTablo) q.getSingleResult();
    }

    public List<YorumlarTablo> findAllYorumBySiteSarfId(Integer dbSiteSarfID) {
        Query q = em.createQuery("SELECT y FROM YorumlarTablo y WHERE y.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", dbSiteSarfID);
        return q.getResultList();
    }

    public List<Altislemtipi> findAltIslemByUstIslemId(Integer Id) {
        Query q = em.createQuery("SELECT a FROM Altislemtipi a WHERE a.dbUstIslemTipiID.dbUstIslemTipiID = :dbUstIslemTipiID");
        q.setParameter("dbUstIslemTipiID", Id);
        return q.getResultList();
    }

    public Ustislemtipi findUStIslemByUStIslemAd(String string) {
        Query q = em.createQuery("SELECT u FROM Ustislemtipi u WHERE u.ustIslemAdi = :ustIslemAdi");
        q.setParameter("ustIslemAdi", string);
        return (Ustislemtipi) q.getSingleResult();
    }

    public Altislemtipi findAltIslemByAltIslemAd(int altislemid,int ustislemId) {
        Query q = em.createQuery("SELECT a FROM Altislemtipi a WHERE a.dbAltIslemTipiID = :dbAltIslemTipiID AND a.dbUstIslemTipiID=:dbUstIslemTipiID");
        q.setParameter("dbAltIslemTipiID", altislemid);
        q.setParameter("dbUstIslemTipiID", ustislemId);
        return (Altislemtipi) q.getSingleResult();
    }

    public List<SiteSarf> findAllSiteSarfs() {
        Query q = em.createNamedQuery("SiteSarf.findAll");
        return q.getResultList();
    }

    public List<TssForm> findAllTssFormBySiteSarfId(Integer siteSarfId) {
        Query q = em.createQuery("SELECT t FROM TssForm t WHERE t.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", siteSarfId);
        return q.getResultList();
    }

    public List<KiralamaTablo> findAllKiralamaBySiteSarfId(Integer siteSarfId) {
        Query q = em.createQuery("SELECT k FROM KiralamaTablo k WHERE k.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID");
        q.setParameter("dbSiteSarfID", siteSarfId);
        return q.getResultList();
    }

    public List<KapsananYerler> findAllKapsananYerlerBySiteSarfId(Integer siteSarfId) {
        Query q = em.createQuery("SELECT k FROM KapsananYerler k WHERE k.dbSiteSarfID.dbSiteSarfID = :dbSiteSarfID ");
        q.setParameter("dbSiteSarfID", siteSarfId);
        return q.getResultList();
    }

    public void sil(Yapilanisler ky) {
        em.remove(ky);
    }


}
