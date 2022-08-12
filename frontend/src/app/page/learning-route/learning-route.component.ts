import { Component, OnInit } from '@angular/core';
import { LearningRouteFormComponent } from './learning-route-form/learning-route-form.component';
import { AddCourseToRouteComponent } from './add-course-to-route-form/add-course-to-route.component';
import { LearningRouteService } from 'src/app/shared/services/learning-route/learning-route.service';
import { LearningRoute, Route } from '../../shared/interfaces/learning-route';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-learning-route',
  templateUrl: './learning-route.component.html',
  styleUrls: ['./learning-route.component.css'],
})
export class LearningRouteComponent implements OnInit {

  routes: LearningRoute[] = [];
  routess: Route[] | undefined;
  createLearningRouteForm: FormGroup;
  submitted = false;
  id: string | undefined;

  constructor(
    private learningRouteService: LearningRouteService,
    private toastr: ToastrService,
    private modal: NgbModal,
    private modalAdd: NgbModal,
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

  handleModalLearningRouteFormClose() {}

  modalAddCourseToRouteFormClose() {}

  learningRouteForm() {
    const modal = this.modal.open(LearningRouteFormComponent);
    modal.result.then(
      this.handleModalLearningRouteFormClose.bind(this),
      this.handleModalLearningRouteFormClose.bind(this)
    );
  }

  addCourseToRouteForm() {
    const modalAdd = this.modalAdd.open(AddCourseToRouteComponent);
    modalAdd.result.then(
        this.modalAddCourseToRouteFormClose.bind(this),
        this.modalAddCourseToRouteFormClose.bind(this)
      );
  }

  handleEditClick(route: LearningRoute) {
    const modal = this.modal.open(LearningRouteFormComponent);
    modal.result.then(
      this.handleModalLearningRouteFormClose.bind(this),
      this.handleModalLearningRouteFormClose.bind(this)
    )
    modal.componentInstance.createMode = false;
    modal.componentInstance.routes = route;
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
    const modal = this.modal.open(AddCourseToRouteComponent);
    modal.result.then(
      this.handleModalLearningRouteFormClose.bind(this),
      this.handleModalLearningRouteFormClose.bind(this)
    );
  }

  getLearningRoutes(): void {
    this.learningRouteService.getAllLearningRoute().subscribe(route => {
      console.log(this.routes = route);
      console.log("----->")
      console.log(this.routess = route.routes);
    });
  }

  public getKeyByPosition(obj: any,position=0): any{
    return Object.keys(obj)[position];
  }
}
