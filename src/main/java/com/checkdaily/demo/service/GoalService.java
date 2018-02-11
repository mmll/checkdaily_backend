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
    @Autowired
    private TaskService taskService;

    public Goal createGoal(Goal GoalMap) {

        ArrayList<Task> taskList = GoalMap.getTaskList();

        for(int i=0; i<taskList.size(); i++){
            Task task = taskList.get(i);
            taskService.createTask(task);
        }
        repository.insert(GoalMap);
        return GoalMap;
    }
    public  Goal updateGoal(Goal GoalMap){
        Goal goal = new Goal(GoalMap.getUserId(),GoalMap.getName(),GoalMap.getStartTime(), GoalMap.getEndTime(), GoalMap.getTaskList(), GoalMap.getId());
//        ArrayList<Task> taskList = GoalMap.getTaskList();
//        for(int i=0; i<taskList.size(); i++){
//            //Task task = taskList.get(i).getId();
//            taskService.createTask(new Task(taskList.get(i).getUserId(), taskList.get(i).getName(), taskList.get(i).getPeriod(), taskList.get(i).getTimes()));
//        }

        //repository.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);
        repository.save(goal);
        return goal;
    }

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
