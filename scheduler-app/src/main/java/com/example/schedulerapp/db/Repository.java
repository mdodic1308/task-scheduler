package com.example.schedulerapp.db;

import com.example.schedulerapp.task_service.ScheduledTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<ScheduledTask, Long> {
}
