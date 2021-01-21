import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import {MatTableModule} from '@angular/material/table';
import {MatDialog, MatDialogModule} from "@angular/material/dialog";

import { CreateTaskComponent } from './create-task/create-task.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { DeleteTaskComponent } from './delete-task/delete-task.component';
import { GetAllTasksComponent } from './get-tasks/get-tasks.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { InterceptorService } from './services/interceptor.service';
import { InfoBoxComponent } from './info-box/info-box.component';
import { InfoBoxService } from './services/info-box.service';


@NgModule({
  declarations: [
    AppComponent,
    CreateTaskComponent,
    UpdateTaskComponent,
    DeleteTaskComponent,
    GetAllTasksComponent,
    InfoBoxComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatDialogModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: InterceptorService,
      multi: true,
      deps: [MatDialog]
    },
    InfoBoxService,
    MatDialog,
  ],
  entryComponents: [InfoBoxComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
