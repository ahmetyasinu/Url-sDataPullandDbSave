package com.ahmetyuzun.demo.controller;

import com.ahmetyuzun.demo.entity.Character;
import com.ahmetyuzun.demo.entity.Report;
import com.ahmetyuzun.demo.service.ReportService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * Report ile ilgili bilgileri elde etmeye yarayan endpointlerin bulundugu controller.
 */
@RestController
public class ReportController {
    private final ReportService reportService;
    /**
     * ReportController icin constructor.
     * Time complexity : O(1)
     * @param reportService objesi
     */
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    /**
     * report tablosundan tum verileri ceker.
     * Time complexity : O(n)
     * @return tabloda kayitli butun veriler.
     */
    @GetMapping(path = "/report")
    public List<Report> report() {
        return this.reportService.findAll();
    }

    /**
     * report tablosundan endpoint sutunundan character listelerini doner.
     * @return character listeleri.
     */
    @GetMapping(path = "/reportcharacter")
    public List<Report> reportcharacter() {
        return this.reportService.findCharacter();
    }
    /**
     * report tablosundan endpoint sutunundan episode listelerini doner.
     * @return episode listeleri.
     */
    @GetMapping(path = "/reportepisode")
    public List<Report> reportepisode() {
        return this.reportService.findEpisode();
    }


}
