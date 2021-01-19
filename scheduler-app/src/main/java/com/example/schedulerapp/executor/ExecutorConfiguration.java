package com.example.schedulerapp.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ExecutorConfiguration {

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler
                = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(10);
        threadPoolTaskScheduler.setThreadNamePrefix(
                "ThreadPoolTaskScheduler");
        threadPoolTaskScheduler.setRemoveOnCancelPolicy(true);
        return threadPoolTaskScheduler;
    }

    @Bean
    public CustomExecutorService getExecutorService() {
        CustomExecutorService executorService
                = new CustomExecutorService();
        executorService.setPoolSize(10);
        executorService.setThreadNamePrefix(
                "ThreadPoolTaskScheduler");
        executorService.setRemoveOnCancelPolicy(true);
        return executorService;
    }
}
