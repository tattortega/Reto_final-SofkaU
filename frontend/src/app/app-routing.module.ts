import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignInComponent } from './page/sign-in/sign-in.component';
import { ProfileComponent } from './page/profile/profile.component';
import { CourseComponent } from './page/course/course.component';
import { LearningRouteComponent } from './page/learning-route/learning-route.component';

// route guard
import { AuthGuard } from './shared/guard/auth.guard';
import {TrainingComponent} from "./page/training/training.component";

const routes: Routes = [
  { path: '', redirectTo: '/sign-in', pathMatch: 'full' },
  { path: 'sign-in', component: SignInComponent },
  { path: 'dashboard', component: ProfileComponent, canActivate: [AuthGuard] },
  { path: 'course', component: CourseComponent, canActivate: [AuthGuard] },
  { path: 'learning-route', component: LearningRouteComponent, canActivate: [AuthGuard] },
  { path: 'training', component: TrainingComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})

export class AppRoutingModule {}
