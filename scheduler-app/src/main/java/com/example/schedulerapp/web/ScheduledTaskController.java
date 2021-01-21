package com.example.schedulerapp.web;

import com.example.schedulerapp.task_service.ScheduledTask;
import com.example.schedulerapp.exceptions.ResourceNotFoundException;
import com.example.schedulerapp.task_service.MainTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

//TODO add patch endpoint
@RestController
@RequestMapping("${scheduledTasksRelativePath}")
public class ScheduledTaskController {
    private static final String ID = "/{id}";
    @Autowired
    private MainTaskService wrapService;

    @GetMapping
    public ResponseEntity<Iterable<ScheduledTask>> getScheduledTasks() {
        return new ResponseEntity<>(wrapService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScheduledTask> insertScheduledTask(@RequestBody @Valid ScheduledTask scheduledTask) {
        return new ResponseEntity<>(wrapService.create(scheduledTask), HttpStatus.CREATED);
    }

    @GetMapping(value = ID)
    public ResponseEntity<ScheduledTask> getScheduledTask(@PathVariable Long id) {
        return new ResponseEntity<>(wrapService.get(id).orElseThrow(() -> new ResourceNotFoundException(id)),
                HttpStatus.OK);
    }

    @PutMapping(value = ID)
    public ResponseEntity<ScheduledTask> updateScheduledTask(@PathVariable Long id,
            @RequestBody @Valid ScheduledTask scheduledTask) {
        return new ResponseEntity<>(wrapService.update(id, scheduledTask), HttpStatus.OK);
    }

    @DeleteMapping(value = ID)
    public ResponseEntity<?> deleteScheduledTask(@PathVariable Long id) {
        wrapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
