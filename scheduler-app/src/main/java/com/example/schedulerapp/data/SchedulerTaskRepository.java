package com.example.schedulerapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedulerTaskRepository extends JpaRepository<ScheduledTask, Long> {
}
