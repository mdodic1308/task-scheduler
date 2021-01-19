import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { ScheduledTask } from './app.scheduled_task';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

    constructor(private http:HttpClient) {}

    findTasks(
        id:number, name = '', sortOrder = 'asc',
        pageNumber = 0, pageSize = 3):  Observable<ScheduledTask[]> {
        return this.http.get<ScheduledTask[]>('/api/scheduledTasks');
    }

    createTask(taskData : ScheduledTask):  Observable<ScheduledTask> {
      return this.http.post<ScheduledTask>('/api/scheduledTasks', taskData);
    }

    updateTask(taskData : ScheduledTask):  Observable<ScheduledTask> {
      return this.http.put<ScheduledTask>('/api/scheduledTasks/'+taskData.id, taskData);
    }

    deleteTask(id: number):  Observable<any> {
      return this.http.delete<ScheduledTask>('/api/scheduledTasks/'+id);
    }
}