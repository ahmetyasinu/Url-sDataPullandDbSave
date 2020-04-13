package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Episode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Url den Episode tablosuna veri cekme servisi.
 */
@Transactional
@Service
public class EpisodePullAndSaveService {

    private final EpisodeService episodeService;

    /**
     * Data fieldlarini alan Constructor
     * Time complexity : O(1)
     *
     * @param episodeService injection edilmistir.
     */
    public EpisodePullAndSaveService(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    /**
     * RestTemplate  kullanarak characterUrl imizden Json object olarak verilerimiz cektik.
     * for ile donup objemizin içinden bütün bilgileri alarak
     * Episode entity mize tek tek set ettikten sonra Database mize kayit ettik.
     * Time complexity : O(m.n)
     *
     * @throws JSONException Json hatalarini gosterir.
     */
    public void PullDataAndSaveService() throws JSONException {
        final String episodeUrl = "https://rickandmortyapi.com/api/episode";
        RestTemplate restTemplate = new RestTemplate();
        String resultLocation = restTemplate.getForObject(episodeUrl, String.class);
        JSONObject rlocation = new JSONObject(resultLocation);
        JSONArray results = rlocation.getJSONArray("results");
        Episode episode = new Episode();

        for (int i = 0; i < results.length(); i++) {
            JSONObject episodeObject = (JSONObject) results.get(i);
            episode.setId(episodeObject.getInt("id"));
            episode.setName(episodeObject.getString("name"));
            episode.setAirDate(episodeObject.getString("air_date"));
            episode.setEpisode(episodeObject.getString("episode"));
            JSONArray characters = episodeObject.getJSONArray("characters");
            List<String> characterslist = new ArrayList();
            for (int a = 0; a < characters.length(); a++) {
                characterslist.add(String.valueOf(characters.get(a)));
            }
            episode.setCharacters(characterslist);
            episode.setUrl(episodeObject.getString("url"));
            episode.setCreated(episodeObject.getString("created"));
            episodeService.save(episode);
        }


    }
}
