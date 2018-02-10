package com.checkdaily.demo.entity;


import java.util.ArrayList;

public class Goal {
    private String name;
    private String startTime;
    private String endTime;
    private String id;
    private ArrayList<Task> taskList;

    public Goal(){

    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public Goal(String name, String startTime, String endTime, ArrayList<Task> taskList){
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskList = taskList;
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
