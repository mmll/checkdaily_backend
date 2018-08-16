package com.checkdaily.demo.service;

import com.checkdaily.demo.entity.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class GoalRepositoryImpl implements GoalRepository{
    @Autowired
    MongoTemplate mongoTemplate;

//    @Override
//    public Goal updateGoal(Goal goal) {
//        return null;
//    }
}
