package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Location;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Url den Location tablosuna veri cekme servisi.
 */
@Transactional
@Service
public class LocationPullAndSaveService {

    private final LocationService locationService;

    /**
     * Data fieldlarini alan Constructor
     * Time complexity : O(1)
     *
     * @param locationService injection edilmistir.
     */
    public LocationPullAndSaveService(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * RestTemplate  kullanarak characterUrl imizden Json object olarak verilerimiz cektik.
     * for ile donup objemizin içinden bütün bilgileri alarak
     * location entity mize tek tek set ettikten sonra Database mize kayit ettik.
     * Time complexity : O(m.n)
     *
     * @throws JSONException Json hatalarini gosterir.
     */
    public void PullDataAndSaveService() throws JSONException {
        final String locationUrl = "https://rickandmortyapi.com/api/location";
        RestTemplate restTemplate = new RestTemplate();
        String resultLocation = restTemplate.getForObject(locationUrl, String.class);
        JSONObject rlocation = new JSONObject(resultLocation);
        JSONArray results = rlocation.getJSONArray("results");
        Location location = new Location();

        for (int i = 0; i < results.length(); i++) {
            JSONObject LocationObject = (JSONObject) results.get(i);
            location.setId(LocationObject.getInt("id"));
            location.setName(LocationObject.getString("name"));
            location.setType(LocationObject.getString("type"));
            location.setDimension(LocationObject.getString("dimension"));
            JSONArray residents = LocationObject.getJSONArray("residents");
            List<String> residentlist = new ArrayList();
            for (int a = 0; a < residents.length(); a++) {
                residentlist.add(String.valueOf(residents.get(a)));
            }
            location.setResident(residentlist);
            location.setUrl(LocationObject.getString("url"));
            location.setCreated(LocationObject.getString("created"));
            locationService.save(location);

        }


    }


}
