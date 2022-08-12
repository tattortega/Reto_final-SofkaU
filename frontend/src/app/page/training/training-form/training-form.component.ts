import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Training} from "../../../shared/interfaces/training";
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from "ngx-toastr";
import {TrainingService} from "../../../shared/services/training/training.service";
import {LearningRoute} from "../../../shared/interfaces/learning-route";
import {LearningRouteService} from "../../../shared/services/learning-route/learning-route.service";

@Component({
  selector: 'app-training-form',
  templateUrl: './training-form.component.html',
  styleUrls: ['./training-form.component.scss']
})
export class TrainingFormComponent implements OnInit {

  trainings: Training | undefined;
  // coaches: Array<object> = new Array<object>();
  coaches = [{
    name: 'edgar'
  } ]
  routes: LearningRoute[] | undefined;
  createTrainingForm: FormGroup;
  createMode: boolean = true
  filess: FileList | undefined;

  constructor(
    private formBuilder: FormBuilder,
    public activeModal: NgbActiveModal,
    private trainingService: TrainingService,
    private learningRouteService: LearningRouteService,
    private toastr: ToastrService) {
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
    this.getLearningRoutes();
    if (!this.createMode) {
      this.loadTraining(this.trainings);
    }
  }

  getLearningRoutes(): void {
    this.learningRouteService.getAllLearningRoute().subscribe(route => {
      this.routes = route;
    });
  }

  loadTraining(training: Training | undefined) {
    // @ts-ignore
    this.createTrainingForm.patchValue(training)
  }

  changeRoute(e: any) {
    this.createTrainingForm.value.routeLearning?.setValue(e.target.value, {
      onlySelf: true,
    });
  }
  get routeLearning() {
    return this.createTrainingForm.get('route');
  }

  changeCoach(e: any) {
    this.createTrainingForm.value.coach?.setValue(e.target.value, {
      onlySelf: true,
    });
  }
  get coach() {
    return this.createTrainingForm.get('coach');
  }

  changeListener(event: Event) {
    const target = event.target as HTMLInputElement;
    const files = target.files as FileList;
    this.filess = files
    console.log(this.filess);
  }

  // public changeListener(files: EventTarget){
  //   console.log(files);
  //   if(files && files.length > 0) {
  //     // @ts-ignore
  //     let file : File = files.item(0);
  //     console.log(file.name);
  //     console.log(file.size);
  //     console.log(file.type);
  //     let reader: FileReader = new FileReader();
  //     reader.readAsText(file);
  //     reader.onload = (e) => {
  //       let csv: string = reader.result as string;
  //       console.log(csv);
  //     }
  //   }
  // }

  saveTraining() {
    // if (this.createTrainingForm.invalid) {
    //   return;
    // }
    console.log("entro")
    console.log(this.createMode)
    if (this.createMode) {
      console.log("entro")
      console.log(this.createTrainingForm.value)
      this.trainingService.createTraining({
        name: this.createTrainingForm.value.name,
        description: this.createTrainingForm.value.description,
        startDate: this.createTrainingForm.value.startDate,
        endDate: this.createTrainingForm.value.endDate,
        coach: this.createTrainingForm.value.coach,
        routeLearning: this.createTrainingForm.value.routeLearning,
        apprentices: this.createTrainingForm.value.apprentices,
      } as Training)
        .subscribe({
          next: training => {
            this.handleSuccessfulSaveTodo(training)
            this.toastr.success('El training fue registrado con éxito!', 'Training Registrado', {
              positionClass: 'toast-bottom-right'
            })
          }, complete: () => {

            setTimeout(function () {
              window.location.reload()
            }, 1000)
          }
        });
    } else {
      const trainingUpdated: any = {
        name: this.createTrainingForm.value.name,
        description: this.createTrainingForm.value.description,
        startDate: this.createTrainingForm.value.startDate,
        endDate: this.createTrainingForm.value.endDate,
        coach: this.createTrainingForm.value.coach,
        routeLearning: this.createTrainingForm.value.routeLearning,
        apprentices: this.createTrainingForm.value.apprentices,
      }
      this.trainingService.updateTraining(this.trainings?.id, trainingUpdated).subscribe({
        next: trainings => {
          this.handleSuccessfulEditTodo(trainings)
          this.toastr.success('El training fue actualizado con éxito!', 'Training Actualizado', {
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

  handleSuccessfulSaveTodo(training: Training) {
    this.activeModal.dismiss({training: training, createMode: true});
  }

  handleSuccessfulEditTodo(training: Training) {
    this.activeModal.dismiss({training: training, createMode: false});
  }


}
