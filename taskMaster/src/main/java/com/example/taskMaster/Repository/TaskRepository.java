package com.example.taskMaster.Repository;

import com.example.taskMaster.Models.Task;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface TaskRepository extends CrudRepository<Task, String> {
    Optional<Task> findById(String id);
    Task findOneById(String id);
    List<Task> findByAssignee(String assignee);
//    Optional<Task> findByName(String name);
}