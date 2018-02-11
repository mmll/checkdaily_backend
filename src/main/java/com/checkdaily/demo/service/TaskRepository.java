package com.checkdaily.demo.service;
import com.checkdaily.demo.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
