package com.cloud_storage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Tpa {
    private String tpa_id;
    private String password;

    public Tpa(String tpa_id, String password) {
        this.tpa_id = tpa_id;
        this.password = password;
    }

    public Tpa() {
    }

    public String getTpa_id() {
        return tpa_id;
    }

    public void setTpa_id(String tpa_id) {
        this.tpa_id = tpa_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
