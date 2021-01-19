import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { from, scheduled } from 'rxjs';
import { ScheduledTask } from '../app.scheduled_task';
import { TaskService } from '../task-service.service';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent {
  title = 'Update existing sheduled task';
  formGroup;

  constructor(
    private formBuilder: FormBuilder, private taskService : TaskService
  ) {
    this.formGroup = this.formBuilder.group({
      id:'',
      name: '',
      recurrency: '',
      code: ''
    });
  }

  onSubmit(formData: { [x: string]: any; }) {
    this.taskService.updateTask(new ScheduledTask(formData.id, formData.name, formData.recurrency, formData.code))
      .subscribe((data: ScheduledTask) => console.log("task with id:"+data.id+" is updated"));
  }
}