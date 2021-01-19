package com.example.schedulerapp.executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class CustomExecutorService extends ThreadPoolTaskScheduler {

    public void addTask() {
    }

    public void updateTask() {
    }

    public void removeTask(Runnable task) {
        super.cancelRemainingTask(task);
    }
}
