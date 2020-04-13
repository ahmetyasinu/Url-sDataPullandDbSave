package com.ahmetyuzun.demo.service;

import com.ahmetyuzun.demo.entity.Location;
import com.ahmetyuzun.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Location Service Database imizde ki verilerin hepsini veya id ye cekmeyi ve Database imize kayit etmeyi saglar.
 */
@Transactional
@Service
public class LocationService {

    private final LocationRepository locationRepository;
    /**
     * Constructor
     * Time Complexity : O(1)
     * @param locationRepository
     */
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * butun verileri doner.
     * @return location list.
     */
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }
    /**
     * id ye gore veri ceker.
     * @param id  sutunumuzda ki id.
     * @return location.
     */
    public Location findById(Integer id) {
        return this.locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Böyle bir id bulunamadı."));
    }

    /**
     * veri kaydi atar
     * @param location location objesi.
     * @return save.
     */
    public Location save(Location location) {
        return this.locationRepository.save(location);
    }

    /**
     * Location name ye gore veri ceker.
     * @param name verilen parametre
     * @return bulunan deger.
     */
    public Optional<Location> findByName(String name) {
        return Optional.ofNullable(this.locationRepository.findByName(name));
    }

}
