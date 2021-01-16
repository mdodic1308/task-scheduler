package com.example.schedulerapp.web;

import com.example.schedulerapp.data.ScheduledTask;
import com.example.schedulerapp.data.SchedulerTaskService;
import com.example.schedulerapp.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${scheduledTasksRelativePath}")
public class SchedulerController {
    private static final String ID = "/{id}";
    //TODO remove model mapper
  //  @Autowired
  //  private ModelMapper modelMapper;
    @Autowired
    private SchedulerTaskService scheduledTaskService;

    @GetMapping
    public ResponseEntity<Iterable<ScheduledTask>> getScheduledTasks() {
        Iterable<ScheduledTask> scheduledTasks = scheduledTaskService.findAll();
        return new ResponseEntity<>(scheduledTasks, HttpStatus.OK);
    }

    //TODO add validation
    @PostMapping
    public ResponseEntity<ScheduledTask> insertScheduledTask(@RequestBody ScheduledTask scheduledTask) {
        ScheduledTask savedScheduledTask = scheduledTaskService.saveScheduledTask(scheduledTask);
        return new ResponseEntity<>(savedScheduledTask, HttpStatus.CREATED);
    }

    @GetMapping(value = ID)
    public ResponseEntity<ScheduledTask> getScheduledTask(@PathVariable Long id) {
        ScheduledTask scheduledTask = scheduledTaskService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new ResponseEntity<>(scheduledTask, HttpStatus.OK);
    }

    @PutMapping(value = ID)
    public ResponseEntity<ScheduledTask> updateScheduledTask(@PathVariable Long id, @RequestBody ScheduledTask scheduledTask) {
        ScheduledTask updatedScheduledTask = scheduledTaskService.update(id, scheduledTask);
        return new ResponseEntity<>(updatedScheduledTask, HttpStatus.OK);
    }

    //TODO add update endpoint
    @PatchMapping(value = ID)
    public ResponseEntity<ScheduledTask> patchScheduledTask(@PathVariable Long id,
            @RequestBody(required = true) Map<String, String> parameters) {
        return new ResponseEntity<>(scheduledTaskService.update(id, parameters),
                HttpStatus.OK);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<?> deleteScheduledTask(@PathVariable Long id) {
        scheduledTaskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
