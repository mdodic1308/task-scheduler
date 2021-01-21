package com.example.schedulerapp.task_service;

import java.util.Optional;

public interface MainTaskService {

    ScheduledTask create(ScheduledTask scheduledTask);

    Iterable<ScheduledTask> getAll();

    Optional<ScheduledTask> get(long id);

    ScheduledTask update(Long id, ScheduledTask scheduledTask);

    void delete(long id);
}
