package com.ahmetyuzun.demo.repository;

import com.ahmetyuzun.demo.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * ReportService icin interface.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {
}
