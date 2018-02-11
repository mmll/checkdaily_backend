package com.checkdaily.demo.service;


import com.checkdaily.demo.entity.Goal;
import com.checkdaily.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task createTask(Task TaskMap) {
        Task task = new Task(TaskMap.getUserId(),TaskMap.getName(),TaskMap.getPeriod(), TaskMap.getTimes());
        repository.insert(task);
        return task;
    }

}
