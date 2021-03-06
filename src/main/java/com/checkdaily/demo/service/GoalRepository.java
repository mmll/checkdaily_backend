package com.checkdaily.demo.service;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import com.checkdaily.demo.entity.Goal;

public interface GoalRepository extends MongoRepository<Goal, String> {
    Goal findByName(String name);
    Goal findById(String id);
//    Goal updateGoal(Goal goal);
}

