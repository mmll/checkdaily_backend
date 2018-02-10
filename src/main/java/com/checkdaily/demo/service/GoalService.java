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
public class GoalService {

    @Autowired
    private GoalRepository repository;

    public Goal createGoal(Goal GoalMap) {
        Goal goal = new Goal(GoalMap.getName(),GoalMap.getStartTime(), GoalMap.getEndTime(), GoalMap.getTaskList());
        ArrayList<Task> taskList = GoalMap.getTaskList();

        for(int i=0; i<taskList.size(); i++){
            Task task = taskList.get(i);

            System.out.println("taskName----------"+ task.getName());
            System.out.println("taskName----------"+ task.getName());

        }
        repository.insert(goal);
        return goal;
    }
    public List<Goal> getAllGoals(){
        return repository.findAll();
    }
    @Cacheable(value = "goalcache", keyGenerator = "wiselyKeyGenerator")
    public Goal getGoalDetails(String name) {
        System.out.println("无缓存的时候调用这里---数据库查询, name=" + name);
        return repository.findByName(name);
    }
}
