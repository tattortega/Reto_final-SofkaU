import {Component, Input, OnInit} from '@angular/core';
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

  createCourse(courseName: string, courseDescription: string, approvalValue: number): void {
    this.courseService.createCourse({
      name: courseName,
      description: courseDescription,
      approvalValue: approvalValue
    } as Course)
      .subscribe(() => {
        this.toastr.success('El curso fue registrado con éxito!', 'Curso Registrado', {
          positionClass: 'toast-bottom-right'
        });
        setTimeout(() => {
          window.location.reload();
        }, 2000);
      })
  }

  getCourses(): void {
    this.courseService.getAllCourse().subscribe(course => {
      this.courses = course;
    })
  }

  createEditCourse() {

  }

  isUpdate(course: Course): void {
    this.courseService.getCourse(course.id).subscribe(courses => {
      this.createCourseForm.setValue({
        name: courses.name,
        description: courses.description,
        approvalValue: courses.approvalValue
      })
    })
    this.updateCourse(course.id )
  }

  updateCourse(id: string): void {
    const courseUpdated: any = {
      name: this.createCourseForm.value.name,
      description: this.createCourseForm.value.description,
      approvalValue: this.createCourseForm.value.approvalValue
    }
    this.courseService.updateCourse(id, courseUpdated).subscribe(course => {
      this.toastr.success('El curso fue actualizo con éxito!', 'Curso Actualizado', {
        positionClass: 'toast-bottom-right'
      });
      this.getCourses()
    })
  }

  deleteCourse(id: string): void {
    this.courseService.deleteCourse(id).subscribe({
      next: course => {
        this.toastr.warning('El curso fue eliminado con éxito!', 'Curso Eliminado', {
          positionClass: 'toast-bottom-right'
        })
      }, complete: () => {
        this.getCourses()
      }
    });
  }

}
