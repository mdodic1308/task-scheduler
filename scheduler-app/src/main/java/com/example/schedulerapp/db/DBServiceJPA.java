package com.example.schedulerapp.db;

import com.example.schedulerapp.task_service.ScheduledTask;
import com.example.schedulerapp.exceptions.BadIdException;
import com.example.schedulerapp.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class DBServiceJPA implements DBService {

    @Autowired
    private Repository schedulerTaskRepository;

    @Override
    public Iterable<ScheduledTask> findAll() {
        return schedulerTaskRepository.findAll();
    }

    @Override
    public Optional<ScheduledTask> findById(Long id) {
        return schedulerTaskRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        try {
            schedulerTaskRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException(id);
        }
    }

    //TODO think about exception handling for bad tasks
    @Override
    public ScheduledTask saveScheduledTask(ScheduledTask scheduledTask) {
        return schedulerTaskRepository.save(scheduledTask);
    }

    @Override
    public Iterable<ScheduledTask> saveScheduledTasks(Iterable<ScheduledTask> scheduledTasks) {
        return schedulerTaskRepository.saveAll(scheduledTasks);
    }

    @Override
    public boolean existsById(Long id) {
        return schedulerTaskRepository.existsById(id);
    }

    @Override
    public long countScheduledTasks() {
        return schedulerTaskRepository.count();
    }

    @Override
    public ScheduledTask update(Long id, ScheduledTask scheduledTask) {
        if (!id.equals(scheduledTask.getId())) throw new BadIdException();
        if (!schedulerTaskRepository.existsById(id)) throw new ResourceNotFoundException(id);
        return schedulerTaskRepository.save(scheduledTask);
    }

    //TODO implement patch update
    @Override
    public ScheduledTask update(Long id, Map<String, String> parameters) {
        if (parameters.containsKey("id") && Long.parseLong(parameters.get("id"))!=id) throw new BadIdException();
        return null;
    }
}
