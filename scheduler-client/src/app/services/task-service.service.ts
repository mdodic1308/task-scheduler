import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ScheduledTask } from '../app.scheduled_task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  SCHEDULED_TASKS_PATH: string = '/api/scheduledTasks/';
    constructor(private http:HttpClient) {}

    findTasks():  Observable<ScheduledTask[]> {
        return this.http.get<ScheduledTask[]>(this.SCHEDULED_TASKS_PATH);
    }

    createTask(taskData : ScheduledTask):  Observable<ScheduledTask> {
      return this.http.post<ScheduledTask>(this.SCHEDULED_TASKS_PATH, taskData);
    }

    updateTask(taskData : ScheduledTask):  Observable<ScheduledTask> {
      return this.http.put<ScheduledTask>(this.SCHEDULED_TASKS_PATH + taskData.id, taskData);
    }

    deleteTask(id: number):  Observable<any> {
      return this.http.delete<ScheduledTask>(this.SCHEDULED_TASKS_PATH + id);
    }
}