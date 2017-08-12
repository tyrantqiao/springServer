package com.qiao.graber.domain;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author qiao
 * email tyrantqiao@icloud.com
 */
@Entity //实体类
public class Baike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String title;
    @URL @NotNull
    private String url;
    @NotNull
    private String synopsis;

    public Baike() {
    }

    public Baike(String title, String url, String synopsis) {
        this.title = title;
        this.url = url;
        this.synopsis = synopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return  url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
