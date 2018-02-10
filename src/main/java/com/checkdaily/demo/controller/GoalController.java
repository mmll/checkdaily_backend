package com.checkdaily.demo.controller;
import com.checkdaily.demo.service.GoalService;
import com.checkdaily.demo.entity.Goal;
import com.mongodb.util.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goal")
public class GoalController {
    private static final Logger logger = LoggerFactory.getLogger(GoalController.class);
    @Autowired
    GoalService goalService;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> createGoal(@RequestBody Goal goalInput){
        logger.info("createGoal----------"+ goalInput.toString());
        logger.info("taskList----------"+ goalInput.getTaskList());
        Goal goal = goalService.createGoal(goalInput);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Goal created successfully");
        response.put("goal",goal);
        return response;
    }
     @RequestMapping(method = RequestMethod.PUT)
     public  Map<String, Object> updateGoal(@RequestBody Map goalInput){
       // Goal goal  = goalService.updateGoal(goalInput);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Goal updated successfully");
        //response.put("goal",goal);
        return response;

     }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public Map<String, Object> getAllGoals() {
        logger.info("getAllGoals");
        List<Goal> goalList = goalService.getAllGoals();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Get All Goal successfully");
        response.put("goalList",goalList);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{goalId}")
    public Goal getGoalById(@PathVariable("goalId") Integer goalId) {
        logger.info("getReportDetails");
        //return goalService.getGoalById(goalId);
        return null;
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{goalId}")
    public Goal deleteGoalById(@PathVariable("goalId") Integer goalId) {
        logger.info("getReportDetails");
        //return goalService.deleteGoalById(goalId);
        return null;
    }
}
