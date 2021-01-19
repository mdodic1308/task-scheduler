import { CollectionViewer } from '@angular/cdk/collections';
import { DataSource } from '@angular/cdk/table';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { ScheduledTask } from '../app.scheduled_task';
import { TaskService } from '../task-service.service';
import { finalize, catchError } from 'rxjs/operators';

export class TasksDataSource implements DataSource<ScheduledTask> {

    private tasksSubject = new BehaviorSubject<ScheduledTask[]>([]);
    private loadingSubject = new BehaviorSubject<boolean>(false);

    public loading$ = this.loadingSubject.asObservable();

    constructor(private coursesService: TaskService) {}

    connect(collectionViewer: CollectionViewer): Observable<ScheduledTask[]> {
        return this.tasksSubject.asObservable();
    }

    disconnect(collectionViewer: CollectionViewer): void {
        this.tasksSubject.complete();
        this.loadingSubject.complete();
    }

    loadTasks(id: number, filter = '',
                sortDirection = 'asc', pageIndex = 0, pageSize = 3) {

        this.loadingSubject.next(true);

        this.coursesService.findTasks(id, filter, sortDirection,
            pageIndex, pageSize).pipe(
            catchError(() => of([])),
            finalize(() => this.loadingSubject.next(false))
        )
        .subscribe(tasks => this.tasksSubject.next(tasks));
    }    
}