package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Character;
import com.ahmetyuzun.demo.entity.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Url den Karakter tablosuna veri cekme servisi.
 */
@Transactional
@Service
public class CharacterPullAndSaveService {

    private final CharacterService characterService;
    private final LocationService locationService;

    /**
     * Data fieldlarini alan Constructor
     * Time complexity : O(1)
     * @param characterService injection edilmistir.
     * @param locationService injection edilmistir.
     */
    public CharacterPullAndSaveService(CharacterService characterService, LocationService locationService) {
        this.characterService = characterService;
        this.locationService = locationService;
    }
    /**
     * RestTemplate  kullanarak characterUrl imizden Json object olarak verilerimiz cektik.
     * for ile donup objemizin içinden bütün bilgileri alarak
     * Character entity mize tek tek set ettikten sonra Database mize kayit ettik.
     * Time complexity : O(m.n)
      * @throws JSONException Json hatalarini gosterir.
     */
    public void PullDataAndSaveService() throws JSONException {
        final String characterUrl = "https://rickandmortyapi.com/api/character";
        RestTemplate restTemplate = new RestTemplate();
        String resultLocation = restTemplate.getForObject(characterUrl, String.class);
        JSONObject rlocation = new JSONObject(resultLocation);
        JSONArray results = rlocation.getJSONArray("results");
        Character character = new Character();
        for (int i = 0; i < results.length(); i++) {
            JSONObject episodeObject = (JSONObject) results.get(i);
            character.setId(episodeObject.getInt("id"));
            character.setName(episodeObject.getString("name"));
            character.setStatus(episodeObject.getString("status"));
            character.setSpecies(episodeObject.getString("species"));
            character.setType(episodeObject.getString("type"));
            character.setGender(episodeObject.getString("gender"));
            character.setOriginLocationName(episodeObject.getJSONObject("origin").getString("name"));
            Optional<Location> location = this.locationService.findByName(character.getOriginLocationName());
            if (location.isEmpty())
                character.setOriginLocationName(null);
            // character.setOriginLocation(new Location(character.getOriginLocationName()));
            character.setLocationName(episodeObject.getJSONObject("location").getString("name"));
            location = this.locationService.findByName(character.getLocationName());
            if (location.isEmpty())
                character.setLocationName(null);
            //character.setLocation(new Location(character.getLocationName()));
            character.setImage(episodeObject.getString("image"));
            JSONArray episode = episodeObject.getJSONArray("episode");
            List<String> episodeList = new ArrayList();
            for (int a = 0; a < episode.length(); a++) {
                episodeList.add(String.valueOf(episode.get(a)));
            }
            character.setEpisode(episodeList);
            character.setUrl(episodeObject.getString("url"));
            character.setCreated(episodeObject.getString("created"));
            characterService.save(character);
        }
    }
}
