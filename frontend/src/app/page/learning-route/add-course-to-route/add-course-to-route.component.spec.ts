import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCourseToRouteComponent } from './add-course-to-route.component';

describe('AddCourseToRouteComponent', () => {
  let component: AddCourseToRouteComponent;
  let fixture: ComponentFixture<AddCourseToRouteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddCourseToRouteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddCourseToRouteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
