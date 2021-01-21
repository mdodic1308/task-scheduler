import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { InfoBoxComponent } from '../info-box/info-box.component';

@Injectable({
  providedIn: 'root'
})
export class InfoBoxService {

  constructor(private dialog: MatDialog) { }

  dialogRef: MatDialogRef<InfoBoxComponent> | undefined;
  
  public open(title: String, message: String) {
    this.dialogRef = this.dialog.open(InfoBoxComponent, {    
         data: {
           title: title,
           message: message,
         }
    });  
  }

}
