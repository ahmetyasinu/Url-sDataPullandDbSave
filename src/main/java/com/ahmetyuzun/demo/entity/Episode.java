package com.ahmetyuzun.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Episode Table imizi ve Variable lari olusturduk.
 */
@Table(name = "episode")
@Entity
public class Episode implements Serializable {


    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "air_date")
    private String airDate;
    @Column(name = "episode")
    private String episode;
    @Column(name = "characters")
    @ElementCollection
    private List<String> characters = new ArrayList<>();
    @Column(name = "url")
    private String url;
    @Column(name = "created")
    private String created;

    /**
     * parametresiz constructor
     * Time complexity : O(1)
     */
    public Episode() {
    }

    /**
     * butun fieldlarin dolduruldugu constructor
     * Time complexity : O(1)
     */
    public Episode(Integer id, String name, String airDate, String episode, List<String> characters, String url, String created) {
        this.id = id;
        this.name = name;
        this.airDate = airDate;
        this.episode = episode;
        this.characters = characters;
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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
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
