import { TestBed } from '@angular/core/testing';

import { RutaaprendizajeService } from './rutaaprendizaje.service';

describe('RutaaprendizajeService', () => {
  let service: RutaaprendizajeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RutaaprendizajeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
