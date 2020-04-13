package com.ahmetyuzun.demo.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Report Table imizi ve Variable lari olusturduk.
 */
@Table(name = "report")
@Entity
public class Report implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "endPoint")
    private String endPoint;
    @Column(name = "httpType")
    private String httpType;
    @Column(name = "time")
    private Long time;
    @Column(name = "ipaddress", length = 50)
    private String ipAddress;

    /**
     * parametresiz constructor
     * Time complexity : O(1)
     */
    public Report() {
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getHttpType() {
        return httpType;
    }

    public void setHttpType(String httpType) {
        this.httpType = httpType;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
