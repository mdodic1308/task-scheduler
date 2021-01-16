package com.example.schedulerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchedulerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerAppApplication.class, args);
	}

/*	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(ScheduledTask.class, BeerDTO.class);
		return modelMapper;
	}*/
}
