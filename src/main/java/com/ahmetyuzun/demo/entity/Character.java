package com.ahmetyuzun.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Character Table imizi ve Variable lari olusturduk.
 */
@Table(name = "character")
@Entity
public class Character implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "species")
    private String species;
    @Column(name = "type")
    private String type;
    @Column(name = "gender")
    private String gender;
    @Column(name = "originLocationName")
    private String originLocationName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "originLocationName", referencedColumnName = "name", insertable = false, updatable = false)
    private Location originLocation;
    @Column(name = "locationName")
    private String locationName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationName", referencedColumnName = "name", insertable = false, updatable = false)
    private Location location;
    @Column(name = "image")
    private String image;
    @Column(name = "episode")
    @ElementCollection
    private List<String> episode = new ArrayList<>();
    @Column(name = "url")
    private String url;
    @Column(name = "created")
    private String created;

    /**
     * parametresiz constructor
     * Time complexity : O(1)
     */
    public Character() {

    }

    /**
     * butun fieldlarin dolduruldugu constructor
     * Time complexity : O(1)
     */
    public Character(Integer id, String name, String status, String species, String type, String gender, String originLocationName, String LocationName, String image, List<String> episode, String url, String created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.originLocationName = originLocationName;
        this.locationName = LocationName;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOriginLocationName() {
        return originLocationName;
    }

    public void setOriginLocationName(String originLocationName) {
        this.originLocationName = originLocationName;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(Location originLocation) {
        this.originLocation = originLocation;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
