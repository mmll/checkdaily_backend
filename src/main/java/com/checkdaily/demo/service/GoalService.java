package com.checkdaily.demo.service;


import com.checkdaily.demo.entity.Goal;
import com.checkdaily.demo.service.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoalService {

    @Autowired
    private GoalRepository repository;

    public Goal createGoal(Map<String, Object> GoalMap) {
        Goal goal = new Goal(GoalMap.get("date").toString(),
                GoalMap.get("title").toString(),
                GoalMap.get("content").toString());

        repository.save(goal);
        return goal;
    }

    @Cacheable(value = "goalcache", keyGenerator = "wiselyKeyGenerator")
    public Goal getGoalDetails(String name) {
        System.out.println("无缓存的时候调用这里---数据库查询, name=" + name);
        return repository.findByName(name);
    }
}
