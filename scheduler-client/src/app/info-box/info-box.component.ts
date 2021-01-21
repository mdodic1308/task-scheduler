import { Inject } from '@angular/core';
import { HostListener } from '@angular/core';
import { Component } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from "@angular/material/dialog";

@Component({
  selector: 'app-info-box',
  templateUrl: './info-box.component.html',
  styleUrls: ['./info-box.component.css']
})
export class InfoBoxComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: {
    message: string,
    title: string
  }, private matDialogRef: MatDialogRef<InfoBoxComponent>){}

  public close() {
    this.matDialogRef.close();
  }

  @HostListener("keydown.esc") 
  public onEsc() {
    this.close();
  }
}
