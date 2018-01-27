package com.checkdaily.demo.entity;

public class Goal {
    private String name;
    private String period;
    private String id;

    public Goal(){

    }

    public Goal(String name, String period, String id){
        this.name = name;
        this.period = period;
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public String getPeriod() {
        return period;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, name='%s', period='%s']",
                id, name, period);
    }
}
