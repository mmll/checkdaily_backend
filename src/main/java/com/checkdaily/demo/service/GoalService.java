package com.checkdaily.demo.service;


import com.checkdaily.demo.entity.Goal;
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


        repository.insert(GoalMap);


        return GoalMap;
    }
//    public  Goal updateGoal(Goal GoalMap){
//        Goal goal = new Goal(GoalMap.getUserId(),GoalMap.getName(),GoalMap.getStartTime(), GoalMap.getEndTime(), GoalMap.getTimes(), GoalMap.getId());
//        repository.updateGoal(goal);
//        return goal;
//    }

    public List<Goal> getAllGoals(){
        return repository.findAll();
    }
    public Goal getGoalById(String goalId){
        return repository.findById(goalId);
    }
    @Cacheable(value = "goalcache", keyGenerator = "wiselyKeyGenerator")
    public Goal getGoalDetails(String name) {
        System.out.println("无缓存的时候调用这里---数据库查询, name=" + name);
        return repository.findByName(name);
    }
}
