import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ScheduledTask } from '../app.scheduled_task';
import { InfoBoxService } from '../services/info-box.service';
import { TaskService } from '../services/task-service.service';

@Component({
  selector: 'app-update-task',
  templateUrl: './update-task.component.html',
  styleUrls: ['./update-task.component.css']
})
export class UpdateTaskComponent {
  title = 'Update existing sheduled task';
  formGroup;

  constructor(
    private formBuilder: FormBuilder, private taskService : TaskService, private infoBoxService: InfoBoxService
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
      .subscribe((data: ScheduledTask) => {
        let message : String = "task with id:"+data.id+" is updated";
        this.infoBoxService.open("INFO", message);
        console.log("The task with id:"+data.id+" is updated");
      })
  }
}