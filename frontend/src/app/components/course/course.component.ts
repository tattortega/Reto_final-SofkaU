import {Component, OnInit} from '@angular/core';
import {CourseService} from "../../services/course/course.service";
import {Course} from "../../interfaces/course";
import {ToastrService} from "ngx-toastr";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {CourseFormComponent} from "../modal/course-form/course-form.component";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  courses: Course[] | undefined;
  createCourseForm: FormGroup;
  submitted = false
  id: string | undefined

  constructor(
    private courseService: CourseService,
    private toastr: ToastrService,
    private modal: NgbModal,
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

  courseForm() {
    const modal = this.modal.open(CourseFormComponent);
    modal.result.then(
      this.handleModalTodoFormClose.bind(this),
      this.handleModalTodoFormClose.bind(this)
    )
  }

  handleModalTodoFormClose() {}

  handleEditClick(course: Course) {
    const modal = this.modal.open(CourseFormComponent);
    modal.result.then(
      this.handleModalTodoFormClose.bind(this),
      this.handleModalTodoFormClose.bind(this)
    )
    modal.componentInstance.createMode = false;
    modal.componentInstance.courses = course;
  }

  handleDeleteClick(id: string, ) {
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

  getCourses(): void {
    this.courseService.getAllCourse().subscribe(course => {
      this.courses = course;
    })
  }

}
