import { Component, OnInit } from '@angular/core';
import { LearningRouteService } from '../../shared/services/learning-route/learning-route.service';
import { LearningRoute } from '../../shared/interfaces/learning-route';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
//import { LearningRouteFormComponent } from '../modal/learning-route-form/learning-route-form.component';

@Component({
  selector: 'app-learning-route',
  templateUrl: './learning-route.component.html',
  styleUrls: ['./learning-route.component.css'],
})
export class LearningRouteComponent implements OnInit {

  routes: LearningRoute[] | undefined;
  createLearningRouteForm: FormGroup;
  submitted = false;
  id: string | undefined;

  constructor(
    private learningRouteService: LearningRouteService,
    private toastr: ToastrService,
    private modal: NgbModal,
    private formBuilder: FormBuilder
  ) {
    this.createLearningRouteForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
    });
  }

  ngOnInit(): void {
    this.getLearningRoutes();
  }

  learningRouteForm() {
  /*  const modal = this.modal.open(LearningRouteFormComponent);
    modal.result.then(
      this.handleModalLearningRouteFormClose.bind(this),
      this.handleModalLearningRouteFormClose.bind(this)
    );*/
  }

  handleModalLearningRouteFormClose() {}

  handleEditClick(route: LearningRoute) {
   /* const modal = this.modal.open(LearningRouteFormComponent);
    modal.result.then(
      this.handleModalLearningRouteFormClose.bind(this),
      this.handleModalLearningRouteFormClose.bind(this)
    )
    modal.componentInstance.createMode = false;
    modal.componentInstance.routes = route;*/
  }

  handleDeleteClick(id: string, ) {
    this.learningRouteService.deleteLearningRoute(id).subscribe({
      next: () => {
        this.toastr.warning(
          'La ruta de aprendizaje fue eliminada con éxito!',
          'Ruta de Aprendizaje Eliminada',
          {
            positionClass: 'toast-bottom-right',
          }
        );
      },
      complete: () => {
        this.getLearningRoutes();
      },
    });
  }

  handleAddCourses() {
    this.toastr.warning(
      'Se agregó con éxito!',
      'Curso Agregado',
      {
        positionClass: 'toast-bottom-right',
      }
    );
  }

  getLearningRoutes(): void {
    this.learningRouteService.getAllLearningRoute().subscribe(route => {
      this.routes = route;
    });
  }
}
