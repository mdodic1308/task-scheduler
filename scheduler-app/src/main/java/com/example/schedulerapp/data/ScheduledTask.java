package com.example.schedulerapp.data;

import com.example.schedulerapp.validation.CronFormatValidation;
import com.example.schedulerapp.validation.GroovyScriptValidation;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "scheduled_task")
public class ScheduledTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 250)
    @Size(max = 250, min = 1)
    @NotBlank(message = "Name is mandatory")
    private String name;
    //TODO add @Size
    @Column(length = 30)
    @CronFormatValidation
    private String recurrency;
    @Lob
    @GroovyScriptValidation
    private String code;
}
