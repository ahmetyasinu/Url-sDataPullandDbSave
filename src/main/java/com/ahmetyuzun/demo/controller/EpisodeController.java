package com.ahmetyuzun.demo.controller;

import com.ahmetyuzun.demo.entity.Episode;
import com.ahmetyuzun.demo.repository.EpisodeRepository;
import com.ahmetyuzun.demo.service.EpisodePullAndSaveService;
import com.ahmetyuzun.demo.service.EpisodeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Episode ile ilgili bilgileri elde etmeye yarayan endpointlerin bulundugu controller.
 */
@RestController
public class EpisodeController {

    private final EpisodeService episodeService;
    private final EpisodePullAndSaveService episodePullAndSaveService;
    /**
     * EpisodeController icin constructor.
     * Time complexity : O(1)
     * @param episodeService objesi
     */
    public EpisodeController(EpisodeService episodeService, EpisodePullAndSaveService episodePullAndSaveService) {
        this.episodeService = episodeService;
        this.episodePullAndSaveService = episodePullAndSaveService;
    }
    /**
     * Episode tablosundan tum verileri ceker.
     * Time complexity : O(n)
     * @param sortingType istenilmesi halinde siralama araci.
     * @return tabloda kayitli butun veriler.
     */
    @GetMapping(path = "/episode")
    public List<Episode> findAll(@RequestParam(required = false, defaultValue = "") String sortingType) {
        return this.episodeService.findAll(sortingType);

    }
    /**
     * Episode tablosundan id ye gore verileri ceker
     * Time complexity : O(1)
     * @param id tabloda ki id sutunu
     * @return episode
     */
    @GetMapping(path = "/episode/{id}")
    public Episode findById(@PathVariable Integer id) {
        return this.episodeService.findById(id);

    }

}
