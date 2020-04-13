package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Report;
import com.ahmetyuzun.demo.repository.ReportRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
/**
 * raporlari kayıt , hepsini cektigimiz , endpointe göre cektigimiz servisleri yazdik.
 */
@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final EntityManager entityManager;
    /**
     * Constructor
     * Time Complexity : O(1)
     * @param reportRepository
     * @param entityManager
     */
    public ReportService(ReportRepository reportRepository, EntityManager entityManager) {
        this.reportRepository = reportRepository;
        this.entityManager = entityManager;
    }
    /**
     * butun verileri doner.
     * @return report list.
     */
    public List<Report> findAll() {
        return this.reportRepository.findAll();
    }

    /**
     * kayit atar.
     * @param report parametresi
     * @return save.
     */
    public Report save(Report report) {
        return this.reportRepository.save(report);
    }

    /**
     * Criteria api ile report table dan endpoint sutununa gore /character olanları ceker
     * @return Liste olarak geri dondurur.
     */
    public List<Report> findCharacter() {

        CriteriaBuilder ca = entityManager.getCriteriaBuilder();
        //Donus icin
        CriteriaQuery<Report> cq = ca.createQuery(Report.class);
        //sql-from
        Root<Report> root = cq.from(Report.class);
        //where RoomBookng.sumSprice = 10
        Predicate searchField = ca.like(root.get("endPoint"), "%/character%");
        cq.where(ca.and(searchField));
        return entityManager.createQuery(cq).getResultList();
    }
    /**
     * Criteria api ile report table dan endpoint sutununa gore /episode olanları ceker
     * @return Liste olarak geri dondurur.
     */
    public List<Report> findEpisode() {

        CriteriaBuilder ca = entityManager.getCriteriaBuilder();
        //Donus icin
        CriteriaQuery<Report> cq = ca.createQuery(Report.class);
        //sql-from
        Root<Report> root = cq.from(Report.class);
        //where RoomBookng.sumSprice = 10
        Predicate searchField = ca.like(root.get("endPoint"), "%/episode%");
        cq.where(ca.and(searchField));
        return entityManager.createQuery(cq).getResultList();
    }

}
