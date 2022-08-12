import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { LearningRouteService } from 'src/app/shared/services/learning-route/learning-route.service';
import { ToastrService } from 'ngx-toastr';
import { LearningRoute } from 'src/app/shared/interfaces/learning-route';

@Component({
  selector: 'app-learning-route-form',
  templateUrl: './learning-route-form.component.html',
  styleUrls: ['./learning-route-form.component.css'],
})
export class LearningRouteFormComponent implements OnInit {
  routes: LearningRoute | undefined;
  createLearningRouteForm: FormGroup;
  createMode: boolean = true;

  constructor(
    private formBuilder: FormBuilder,
    public activeModal: NgbActiveModal,
    private learningRouteService: LearningRouteService,
    private toastr: ToastrService
  ) {
    this.createLearningRouteForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnInit() {
    if (!this.createMode) {
      this.loadLearningRoute(this.routes);
    }
  }

  loadLearningRoute(route: LearningRoute | undefined) {
    // @ts-ignore
    this.createLearningRouteForm.patchValue(route);
  }

  saveLearningRoute() {
    if (this.createLearningRouteForm.invalid) {
      return;
    }
    if (this.createMode) {
      this.learningRouteService
        .createLearningRoute({
          name: this.createLearningRouteForm.value.name,
          description: this.createLearningRouteForm.value.description
        } as LearningRoute)
        .subscribe({
          next: route => {
            this.handleSuccessfulSaveLearningRoute(route);
            this.toastr.success(
              'La ruta de aprendizaje fue registrada con éxito!',
              'Ruta de Aprendizaje Registrada',
              {
                positionClass: 'toast-bottom-right',
              }
            );
          },
          complete: () => {
            setTimeout(function () {
              window.location.reload();
            }, 1000);
          },
        });
    } else {
      const learningRouteUpdated: any = {
        name: this.createLearningRouteForm.value.name,
        description: this.createLearningRouteForm.value.description,
      };
      this.learningRouteService
        .updateLearningRoute(this.routes?.id, learningRouteUpdated)
        .subscribe({
          next: routes => {
            this.handleSuccessfulEditLearningRoute(routes);
            this.toastr.success(
              'La ruta de aprendizaje fue registrada con éxito!',
              'Ruta de Aprendizaje Registrada',
              {
                positionClass: 'toast-bottom-right',
              }
            );
          },
          complete: () => {
            setTimeout(function () {
              window.location.reload();
            }, 1000);
          },
        });
    }
  }

  handleSuccessfulSaveLearningRoute(learningRoute: LearningRoute) {
    this.activeModal.dismiss({ route: learningRoute, createMode: true });
  }

  handleSuccessfulEditLearningRoute(learningRoute: LearningRoute) {
    this.activeModal.dismiss({ route: learningRoute, createMode: false });
  }
}
