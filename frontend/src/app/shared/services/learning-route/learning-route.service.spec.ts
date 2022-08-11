import { TestBed } from '@angular/core/testing';

import { LearningRouteService } from './learning-route.service';

describe('RutaaprendizajeService', () => {
  let service: LearningRouteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LearningRouteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
