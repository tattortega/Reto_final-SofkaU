import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Training} from "../../shared/interfaces/training";
import {ToastrService} from "ngx-toastr";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {TrainingService} from "../../shared/services/training/training.service";
import {TrainingFormComponent} from "./training-form/training-form.component";

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.scss']
})
export class TrainingComponent implements OnInit {

  trainings: Training[] | undefined;
  createTrainingForm: FormGroup;
  id: string | undefined

  constructor(
    private trainingService: TrainingService,
    private toastr: ToastrService,
    private modal: NgbModal,
    private formBuilder: FormBuilder) {
    this.createTrainingForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      startDate: ['', Validators.required],
      endDate: ['', Validators.required],
      coach: ['', Validators.required],
      routeLearning: ['', Validators.required],
      apprentices: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    this.getTrainings()
  }

  trainingForm() {
    const modal = this.modal.open(TrainingFormComponent);
    modal.result.then(
      this.handleModalTodoFormClose.bind(this),
      this.handleModalTodoFormClose.bind(this)
    )
  }

  handleModalTodoFormClose() {}

  handleEditClick(training: Training) {
    const modal = this.modal.open(TrainingFormComponent);
    modal.result.then(
      this.handleModalTodoFormClose.bind(this),
      this.handleModalTodoFormClose.bind(this)
    )
    modal.componentInstance.createMode = false;
    modal.componentInstance.trainings = training;
  }

  handleDeleteClick(id: string, ) {
    this.trainingService.deleteTraining(id).subscribe({
      next: () => {
        this.toastr.warning('El training fue eliminado con éxito!', 'Training Eliminado', {
          positionClass: 'toast-bottom-right'
        })
      }, complete: () => {
        this.getTrainings()
      }
    });
  }

  getTrainings(): void {
    this.trainingService.getAllTrainings().subscribe(training => {
      this.trainings = training;
    })
  }

}
