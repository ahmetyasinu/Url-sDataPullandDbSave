package com.ahmetyuzun.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Location Table imizi ve Variable lari olusturduk.
 */
@Table(name = "location")
@Entity
public class Location implements Serializable {


    @Column(name = "id")
    private Integer id;
    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "dimension")
    private String dimension;
    @Column(name = "resident")
    @ElementCollection
    private List<String> resident = new ArrayList<>();
    @Column(name = "url")
    private String url;
    @Column(name = "created")
    private String created;

    /**
     * parametresiz constructor
     * Time complexity : O(1)
     */
    public Location() {
    }

    /**
     * butun fieldlarin dolduruldugu constructor
     * Time complexity : O(1)
     */
    public Location(Integer id, String name, String type, String dimension, List<String> resident, String url, String created, String originLocationName) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.resident = resident;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<String> getResident() {
        return resident;
    }

    public void setResident(List<String> resident) {
        this.resident = resident;
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
