import { Component } from '@angular/core';
import { TasksDataSource } from './get-tasks.tasks-data-source';
import { TaskService } from '../task-service.service';

@Component({
  selector: 'app-get-tasks',
  templateUrl: './get-tasks.component.html',
  styleUrls: ['./get-tasks.component.css']
})
export class GetAllTasksComponent{
  title = 'Get scheduled task';
  dataSource: TasksDataSource;
  displayedColumns = ["id", "name", "recurrency", "code"];
  constructor(
    private taskService: TaskService
  ) {
    this.dataSource = new TasksDataSource(this.taskService);
  }

  onSubmit() {
    this.dataSource.loadTasks(1);
  }
}