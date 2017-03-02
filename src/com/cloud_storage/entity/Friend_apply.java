package com.cloud_storage.entity;

import java.util.Date;

/**
 * Created by dell on 1/23/2017.
 */
public class Friend_apply {
    private int applier_id;
    private int target_id;
    private int is_valid;
    private String date;

    public Friend_apply(int applier_id, int target_id, int is_valid,String date) {
        this.applier_id = applier_id;
        this.target_id = target_id;
        this.is_valid = is_valid;
        this.date=date;
    }

    public Friend_apply() {
        is_valid=1;
        date=new Date().toString();
    }

    public int getApplier_id() {
        return applier_id;
    }

    public void setApplier_id(int applier_id) {
        this.applier_id = applier_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
