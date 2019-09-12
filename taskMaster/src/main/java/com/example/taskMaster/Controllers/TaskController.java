package com.example.taskMaster.Controllers;

import com.example.taskMaster.Models.History;
import com.example.taskMaster.Models.States;
import com.example.taskMaster.Models.Task;
import com.example.taskMaster.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskmaster/v1")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> Tasks() {
        return (List) taskRepository.findAll();
    }


    @GetMapping("/users/{name}/tasks")
    public List<Task> getAllTasksForTheUser(@PathVariable String name) {
        return (List) taskRepository.findByAssignee(name);
    }


    @PostMapping("/tasks")
    public String addNewtask(@RequestBody Task task) {
        Task t = new Task();
        if (task.getAssignee() != null) {
            t.setAssignee(task.getAssignee());
            t.setStatus("Assigned");
        } else {
            t.setAssignee("");
            t.setStatus("Available");
        }
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        ArrayList<History> historyArrayList = new ArrayList<>();
        t.setHistoryArrayList(historyArrayList);
        t.setNewHistory(new History("Task: " + t.getDescription() + " was added"));

        taskRepository.save(t);
        return "Successfully added a new task!";
    }

    @PutMapping("/tasks/{id}/state")
    public String advanceTask(@PathVariable String id) {
        Task task = taskRepository.findOneById(id);
        StringBuilder message = new StringBuilder("Task advanced from " + task.getStatus()); // For displaying message
        task.setStatus(States.changeState(task.getStatus())); //Changes the current status
        message.append(" to "+ task.getStatus());

        task.getHistoryArrayList().add(new History(message.toString()));
        taskRepository.save(task);
        return message.toString();

    }


    @PutMapping("/tasks/{id}/assign/{assignee}")
    public String addUserToTask(@PathVariable String id, @PathVariable String assignee) {
        Task task = taskRepository.findOneById(id);
        //Check condition here to see other task status

        task.setAssignee(assignee);
        task.setStatus("Assigned");
        task.getHistoryArrayList().add(new History(assignee + " assigned to the task"));
        taskRepository.save(task);

        return "task assigned to "+ assignee;
    }


}