import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LearningRouteFormComponent } from './learning-route-form.component';

describe('LearningRouteFormComponent', () => {
  let component: LearningRouteFormComponent;
  let fixture: ComponentFixture<LearningRouteFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LearningRouteFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LearningRouteFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
