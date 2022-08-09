import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {CourseService} from "../../../services/course/course.service";
import {ToastrService} from "ngx-toastr";
import {Course} from "../../../interfaces/course";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {
  courses: Course | undefined;
  createCourseForm: FormGroup;
  createMode: boolean = true

  constructor(
    private formBuilder: FormBuilder,
    public activeModal: NgbActiveModal,
    private courseService: CourseService,
    private toastr: ToastrService,) {
    this.createCourseForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      approvalValue: ['', Validators.required],
    })
  }

  ngOnInit() {
    if (!this.createMode) {
      this.loadCourse(this.courses);
    }
  }

  loadCourse(course: Course | undefined) {
    // @ts-ignore
    this.createCourseForm.patchValue(course)
    // @ts-ignore
    // this.courseService.getCourse(course.id).subscribe(courses => {
    //   this.createCourseForm.setValue({
    //     name: courses.name,
    //     description: courses.description,
    //     approvalValue: courses.approvalValue
    //   })
    // })
  }

  saveCourse() {
    if (this.createCourseForm.invalid) {
      return;
    }
    if (this.createMode) {
      this.courseService.createCourse({
        name: this.createCourseForm.value.name,
        description: this.createCourseForm.value.description,
        approvalValue: this.createCourseForm.value.approvalValue
      } as Course)
        .subscribe({
          next: course => {
            this.handleSuccessfulSaveTodo(course)
            this.toastr.success('El curso fue registrado con éxito!', 'Curso Registrado', {
              positionClass: 'toast-bottom-right'
            })
          }, complete: () => {

            setTimeout(function () {
              window.location.reload()
            }, 1000)
          }
        });
    } else {
      const courseUpdated: any = {
        name: this.createCourseForm.value.name,
        description: this.createCourseForm.value.description,
        approvalValue: this.createCourseForm.value.approvalValue
      }
      this.courseService.updateCourse(this.courses?.id, courseUpdated).subscribe({
        next: courses => {
          this.handleSuccessfulEditTodo(courses)
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


  }

  handleSuccessfulSaveTodo(course: Course) {
    this.activeModal.dismiss({course: course, createMode: true});
  }

  handleSuccessfulEditTodo(course: Course) {
    this.activeModal.dismiss({course: course, createMode: false});
  }

}
