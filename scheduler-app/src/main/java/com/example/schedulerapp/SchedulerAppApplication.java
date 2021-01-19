package com.example.schedulerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
public class SchedulerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerAppApplication.class, args);
	}
}
