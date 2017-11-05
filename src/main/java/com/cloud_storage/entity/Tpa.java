package com.cloud_storage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Tpa {
    private int tpa_id;
    private String token;
    private String description;

    public Tpa(int tpa_id, String token) {
        this.tpa_id = tpa_id;
        this.token = token;
    }

    public Tpa() {
    }

    public int getTpa_id() {
        return tpa_id;
    }

    public void setTpa(int tpa_id) {
        this.tpa_id = tpa_id;
    }

    public String getPassword() {
        return token;
    }

    public void setPassword(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
