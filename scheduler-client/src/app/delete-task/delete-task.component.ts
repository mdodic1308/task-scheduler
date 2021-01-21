import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ScheduledTask } from '../app.scheduled_task';
import { InfoBoxService } from '../services/info-box.service';
import { TaskService } from '../services/task-service.service';

@Component({
  selector: 'app-delete-task',
  templateUrl: './delete-task.component.html',
  styleUrls: ['./delete-task.component.css']
})

export class DeleteTaskComponent {
  title = 'Delete sheduled task';
  formGroup;

  constructor(
    private formBuilder: FormBuilder, private taskService : TaskService, private infoBoxService: InfoBoxService
  ) {
    this.formGroup = this.formBuilder.group({
      id:''
    });
  }

  onSubmit(formData: { [x: string]: any; }) {
    this.taskService.deleteTask(formData.id)
      .subscribe(() => {
        let log : String = "The task with id: "+formData.id +" is deleted.";
        this.infoBoxService.open("INFO", log);
        console.log(log);
      })
  }
}