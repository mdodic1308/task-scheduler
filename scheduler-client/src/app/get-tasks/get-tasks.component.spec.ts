import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllTasksComponent } from './get-tasks.component';

describe('GetAllTasksComponent', () => {
  let component: GetAllTasksComponent;
  let fixture: ComponentFixture<GetAllTasksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllTasksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetAllTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
