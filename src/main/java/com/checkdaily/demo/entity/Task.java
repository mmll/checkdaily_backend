package com.checkdaily.demo.entity;

import java.util.ArrayList;

public class Task {
    private String name;
    private String period;
    private String times;
    private String id;
    private String userId;

    public Task(){

    }
    public Task(String userId,String name, String period, String times){
        this.userId = userId;
        this.name = name;
        this.period = period;
        this.times = times;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
