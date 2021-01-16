package com.example.schedulerapp.web;

import lombok.Data;

@Data
public class ScheduledTaskDTO {
    private Long id;
    private String name;
    private String description;
    private Double meanTemp;
}
