package com.checkdaily.demo.entity;


import java.util.ArrayList;

public class Goal {
    private String name;
    private String startTime;
    private String endTime;
    private String id;
    private String userId;
    private int times;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Goal(String userId,String name, String startTime, String endTime , int times){
        this.userId = userId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public Goal(String userId, String name, String startTime, String endTime, int times, String id){
        this.userId = userId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {

        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', startTime='%s', endTime='%s']",
                id, name, startTime, endTime);
    }
}
