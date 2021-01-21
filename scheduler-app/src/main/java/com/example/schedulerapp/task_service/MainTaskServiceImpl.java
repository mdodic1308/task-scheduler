package com.example.schedulerapp.task_service;

import com.example.schedulerapp.db.DBService;
import com.example.schedulerapp.executor.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainTaskServiceImpl implements MainTaskService {
    @Autowired
    DBService dbService;

    @Autowired
    ThreadPoolService threadPoolService;

 /*   public MainTaskServiceImpl() {
        initThreadPool();
    }*/

    @Override
    public ScheduledTask create(ScheduledTask scheduledTask) {
        ScheduledTask newScheduledTask = dbService.saveScheduledTask(scheduledTask);
        threadPoolService.add(newScheduledTask);
        return newScheduledTask;
    }

    @Override
    public Iterable<ScheduledTask> getAll() {
        return dbService.findAll();
    }

    @Override
    public Optional<ScheduledTask> get(long id) {
        return dbService.findById(id);
    }

    @Override
    public ScheduledTask update(Long id, ScheduledTask scheduledTask) {
        ScheduledTask updatedScheduledTask = dbService.update(id, scheduledTask);
        threadPoolService.update(updatedScheduledTask);
        return updatedScheduledTask;
    }

    @Override
    public void delete(long id) {
        dbService.delete(id);
        threadPoolService.remove(id);
    }

    //TODO test this functionality
    private void initThreadPool() {
        Iterable<ScheduledTask> initialScheduledTasks = dbService.findAll();
        for (ScheduledTask initialScheduledTask :
                initialScheduledTasks) {
            create(initialScheduledTask);
        }
    }
}
