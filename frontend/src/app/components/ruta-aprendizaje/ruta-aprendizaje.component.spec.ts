import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RutaAprendizajeComponent } from './ruta-aprendizaje.component';

describe('RutaAprendizajeComponent', () => {
  let component: RutaAprendizajeComponent;
  let fixture: ComponentFixture<RutaAprendizajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RutaAprendizajeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RutaAprendizajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
