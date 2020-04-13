package com.ahmetyuzun.demo;

import com.ahmetyuzun.demo.service.CharacterPullAndSaveService;
import com.ahmetyuzun.demo.service.EpisodePullAndSaveService;
import com.ahmetyuzun.demo.service.LocationPullAndSaveService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class.
 */
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final CharacterPullAndSaveService characterPullAndSaveService;
    private final EpisodePullAndSaveService episodePullAndSaveService;
    private final LocationPullAndSaveService locationPullAndSaveService;

    public DemoApplication(CharacterPullAndSaveService characterPullAndSaveService, EpisodePullAndSaveService episodePullAndSaveService, LocationPullAndSaveService locationPullAndSaveService) {
        this.characterPullAndSaveService = characterPullAndSaveService;
        this.episodePullAndSaveService = episodePullAndSaveService;
        this.locationPullAndSaveService = locationPullAndSaveService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    /**
     * projenin Applicationunda CommandLineRunner ile proje baslamadan veri cekme ve kayit islemini yaptik.
     */
    @Override
    public void run(String... args) throws Exception {
        locationPullAndSaveService.PullDataAndSaveService();
        episodePullAndSaveService.PullDataAndSaveService();
        characterPullAndSaveService.PullDataAndSaveService();
    }
}
