import {Component, OnInit} from '@angular/core';
import {CourseService} from "../../services/course/course.service";
import {Course} from "../../interfaces/course";
import {ToastrService} from "ngx-toastr";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  courses: Course[] | undefined;
  createCourseForm: FormGroup;
  tittle = 'CREACIÓN DE CURSO'
  submitted = false
  id: string | undefined

  constructor(
    private courseService: CourseService,
    private toastr: ToastrService,
    private formBuilder: FormBuilder) {
    this.createCourseForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      approvalValue: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    this.getCourses()
  }

  createCourse(): void {
    this.courseService.createCourse({
      name: this.createCourseForm.value.name,
      description: this.createCourseForm.value.description,
      approvalValue: this.createCourseForm.value.approvalValue
    } as Course)
      .subscribe({
        next: () => {
          this.toastr.success('El curso fue registrado con éxito!', 'Curso Registrado', {
            positionClass: 'toast-bottom-right'
          })
        }, complete: () => {
          setTimeout(function () {
            window.location.reload()
          }, 1000)
        }
      });
  }

  getCourses(): void {
    this.courseService.getAllCourse().subscribe(course => {
      this.courses = course;
    })
  }

  createEditCourse() {
    this.submitted = true;

    if (this.createCourseForm.invalid) {
      this.toastr.error('Todos los campos son obligatorios', 'Intenta de nuevo', {
        positionClass: 'toast-bottom-right'
      })
    }
    if (this.tittle == 'CREACIÓN DE CURSO') {
      this.createCourse()
    } else {
      this.updateCourse()
    }
  }

  isUpdate(course: Course): void {
    this.tittle = 'EDICIÓN DE CURSO'
    this.id = course.id
    this.courseService.getCourse(this.id).subscribe(courses => {
      this.createCourseForm.setValue({
        name: courses.name,
        description: courses.description,
        approvalValue: courses.approvalValue
      })
    })
  }

  updateCourse(): void {
    const courseUpdated: any = {
      name: this.createCourseForm.value.name,
      description: this.createCourseForm.value.description,
      approvalValue: this.createCourseForm.value.approvalValue
    }
    this.courseService.updateCourse(this.id, courseUpdated).subscribe({
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

  deleteCourse(id: string): void {
    this.courseService.deleteCourse(id).subscribe({
      next: () => {
        this.toastr.warning('El curso fue eliminado con éxito!', 'Curso Eliminado', {
          positionClass: 'toast-bottom-right'
        })
      }, complete: () => {
        this.getCourses()
      }
    });
  }

}
