import { Component, OnInit } from '@angular/core';
import { LearningRouteService } from '../../services/learning-route/learning-route.service';
import { CourseService } from 'src/app/services/course/course.service'; 
import { LearningRoute } from '../../interfaces/learning-route';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Course } from 'src/app/interfaces/course';

@Component({
  selector: 'app-learning-route',
  templateUrl: './learning-route.component.html',
  styleUrls: ['./learning-route.component.css'],
})
export class LearningRouteComponent implements OnInit {

  routes: LearningRoute[] | undefined
  createLearningRouteForm: FormGroup
  title = 'Ruta de Aprendizaje'
  submitted = false
  id: string | undefined

  constructor(
    private learningRouteService: LearningRouteService,
    private courseService: CourseService,
    private toastr: ToastrService,
    private formBuilder: FormBuilder
  ) {
    this.createLearningRouteForm = this.formBuilder.group({
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.getLearningRoutes()
  }

  createLearningRoute(): void {
    this.learningRouteService
      .createLearningRoute({
        name: this.createLearningRouteForm.value.name,
        description: this.createLearningRouteForm.value.description
      } as LearningRoute)
      .subscribe({
        next: () => {
          this.toastr.success('¡Se registro con exito!');
          positionClass: 'toast-bottom-right';
        },
        complete: () => {
          setTimeout(function () {
            window.location.reload();
          }, 1000);
        },
      });
  }

  getLearningRoutes(): void {
    this.learningRouteService.getAllLearningRoute().subscribe(route => {
      this.routes = route;
    })
  }

  createEditLearningRoute() {
    this.submitted = true;

    if (this.createLearningRouteForm.invalid) {
      this.toastr.error(
        'Todos los campos son obligatorios',
        'Intenta de nuevo',
        {
          positionClass: 'toast-bottom-right',
        }
      )
    } if (this.title == 'Ruta de Aprendizaje') {
      this.createLearningRoute()
    } else {
      this.updateLearningRoute()
    }
  }

  isUpdate(route: LearningRoute): void {
    this.title = 'EDICIÓN DE RUTA'
    this.id = route.id
    this.learningRouteService.getLearningRoute(this.id).subscribe(route => {
      this.createLearningRouteForm.setValue({
        name: route.name,
        description: route.description
      })
    })
  }

  updateLearningRoute(): void {
    const updatedRoute: any = {
      name: this.createLearningRouteForm.value.name,
      description: this.createLearningRouteForm.value.description
    }
    this.learningRouteService.updateLearningRoute(this.id, updatedRoute).subscribe({
      next: () => {
        this.toastr.success('El curso fue actualizado con éxito!', 'Curso Actualizado', {
          positionClass: 'toast-bottom-right'
        })
      }, complete: () => {
        setTimeout(function () {
          window.location.reload()
        }, 1000)
      }
    })
  }

  deleteLearningRoute(id: string): void {
    this.learningRouteService.deleteLearningRoute(id).subscribe({
      next: () => {
        this.toastr.warning('El curso fue eliminado con éxito!', 'Curso Eliminado', {
          positionClass: 'toast-bottom-right'
        })
      }, complete: () => {
        this.getLearningRoutes()
      }
    });
  }
}
