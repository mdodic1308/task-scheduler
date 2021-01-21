import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { MatDialog } from '@angular/material/dialog';
import { InfoBoxComponent } from '../info-box/info-box.component';

@Injectable()
export class InterceptorService implements HttpInterceptor{

 constructor(private dialog: MatDialog) { }

 handleError(error: HttpErrorResponse){
  let title: String = "ERROR";
  let message: String; 
  switch(error.status){
    case 404:{
      message = "Resource not found";
      this.dialog.open(InfoBoxComponent, {    
        data: {
          title: title,
          message: message,
        }
      });
      console.log(message);
      break;
     }
     case 400:{
      message = "Input data is not correct";
      this.dialog.open(InfoBoxComponent, {    
        data: {
          title: title,
          message: message,
        }
      });
      console.log(message);
      break;
    }
   }
  return throwError(error);
 }

intercept(req: HttpRequest<any>, next: HttpHandler):
Observable<HttpEvent<any>>{
 return next.handle(req)
 .pipe(
  catchError(this.handleError)
 )
 }
}