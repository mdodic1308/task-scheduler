package com.example.schedulerapp.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "scheduled_task")
public class ScheduledTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //TODO add @Size for easier FE validation
    @Column(length = 250)
    private String name;
    //TODO add @Size
    @Column(length = 30)
    private String recurrency;
    @Lob
    private String code;
}
