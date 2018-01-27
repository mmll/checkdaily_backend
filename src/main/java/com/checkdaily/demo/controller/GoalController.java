package com.checkdaily.demo.controller;
import com.checkdaily.demo.service.GoalService;
import com.checkdaily.demo.entity.Goal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
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
    public Map<String, Object> createGoal(@RequestBody Map<String, Object> goalMap){
        logger.info("createGoal");
        Goal goal = goalService.createGoal(goalMap);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "Goal created successfully");
        response.put("goal",goal);
        return response;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{goalName}")
    public Goal getGoalDetails(@PathVariable("goalName") String name) {
        logger.info("getReportDetails");
        return goalService.getGoalDetails(name);
    }
}
