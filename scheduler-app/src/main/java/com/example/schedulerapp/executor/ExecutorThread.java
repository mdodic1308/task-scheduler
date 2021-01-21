package com.example.schedulerapp.executor;

import com.example.schedulerapp.task_service.ScheduledTask;
import groovy.lang.GroovyShell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorThread implements Runnable {

    private final ScheduledTask scheduledTask;

    Logger logger = LoggerFactory.getLogger(ExecutorThread.class);

    public ExecutorThread(ScheduledTask scheduledTask) {
        this.scheduledTask = scheduledTask;
    }

    @Override
    public void run() {
        GroovyShell groovyShell = new GroovyShell();
        String log = String.format("Start executing task: %s", scheduledTask.getName());
        logger.info(log);
        groovyShell.evaluate(scheduledTask.getCode());
    }
}
