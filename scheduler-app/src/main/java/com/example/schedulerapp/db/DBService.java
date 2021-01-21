package com.example.schedulerapp.db;

import com.example.schedulerapp.task_service.ScheduledTask;

import java.util.Map;
import java.util.Optional;

public interface DBService {
    Iterable<ScheduledTask> findAll();

    Optional<ScheduledTask> findById(Long id);

    void delete(Long id);

    ScheduledTask saveScheduledTask(ScheduledTask scheduledTask);

    Iterable<ScheduledTask> saveScheduledTasks(Iterable<ScheduledTask> scheduledTasks);

    boolean existsById(Long id);

    long countScheduledTasks();

    ScheduledTask update(Long id, ScheduledTask scheduledTask);

    ScheduledTask update(Long id, Map<String,String> parameters);
}
