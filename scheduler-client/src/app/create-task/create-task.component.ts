import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ScheduledTask } from '../app.scheduled_task';
import { TaskService } from '../task-service.service';

@Component({
  selector: 'app-create-task',
  templateUrl: './create-task.component.html',
  styleUrls: ['./create-task.component.css'],
})
export class CreateTaskComponent {
  title = 'Create sheduled task';
  formGroup;

  constructor(
    private formBuilder: FormBuilder, private taskService : TaskService
  ) {
    this.formGroup = this.formBuilder.group({
      name: '',
      recurrency: '',
      code: ''
    });
  }

  onSubmit(formData: { [x: string]: any; }) {
    this.taskService.createTask(new ScheduledTask(0, formData.name, formData.recurrency, formData.code))
      .subscribe((data: ScheduledTask) => console.log("The new task with id "+ data.id +" is created."));
  }
}