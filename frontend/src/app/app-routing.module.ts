import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LearningRouteComponent } from './components/learning-route/learning-route.component';
import { CourseComponent } from './components/course/course.component';

const routes: Routes = [
  { path: 'learning-route', component: LearningRouteComponent },
  { path: 'course', component: CourseComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
