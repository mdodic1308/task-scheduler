package com.example.schedulerapp.executor;

import com.example.schedulerapp.task_service.ScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;

@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {

    @Autowired
    ConcurrentMap<Long, Future<?>> futureHolder;
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Override
    public void add(ScheduledTask scheduledTask) {
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler
                .schedule(new ExecutorThread(scheduledTask),
                        new CronTrigger(scheduledTask.getRecurrency()));
        futureHolder.put(scheduledTask.getId(), scheduledFuture);
    }

    @Override
    public void update(ScheduledTask scheduledTask) {
        long id = scheduledTask.getId();
        futureHolder.get(id).cancel(true);
        ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler
                .schedule(new ExecutorThread(scheduledTask),
                        new CronTrigger(scheduledTask.getRecurrency()));
        futureHolder.put(id, scheduledFuture);
    }

    @Override
    public void remove(long id) {
        futureHolder.get(id).cancel(true);
    }
}
