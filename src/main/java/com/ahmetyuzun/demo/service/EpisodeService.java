package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Episode;
import com.ahmetyuzun.demo.repository.EpisodeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *Episode Service Database imizde ki verilerin hepsini veya id ye cekmeyi ve Database imize kayit etmeyi sağlar.
 */
@Transactional
@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;
    /**
     * Constructor
     * Time Complexity : O(1)
     * @param episodeRepository
     */
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    /**
     * Tabloda ki tum verileri ceker.
     * @param stringType istene siralama tipine gore listeler
     * @return Episode listesi.
     */
    public List<Episode> findAll(String stringType) {
        return stringType.isEmpty() ?
                this.episodeRepository.findAll() :
                this.episodeRepository.findAll(Sort.by(Sort.Order.asc(stringType)));
    }
    /**
     * id ye gore veri ceker.
     * @param id  sutunumuzda ki id.
     * @return episode.
     */
    public Episode findById(Integer id) {
        return this.episodeRepository.findById(id).orElseThrow(() -> new RuntimeException("Böyle bir id bulunamadı."));
    }
    /**
     * episode kaydı atilir.
     * @param episode gelen karakter objesi.
     * @return save.
     */
    public Episode save(Episode episode) {
        return this.episodeRepository.save(episode);
    }

}
