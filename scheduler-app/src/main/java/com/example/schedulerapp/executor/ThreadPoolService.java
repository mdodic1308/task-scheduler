package com.example.schedulerapp.executor;

import com.example.schedulerapp.task_service.ScheduledTask;

public interface ThreadPoolService {
    void add(ScheduledTask scheduledTask);

    void update(ScheduledTask scheduledTask);

    void remove(long id);
}
