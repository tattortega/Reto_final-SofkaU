import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RutaAprendizajeComponent } from './components/ruta-aprendizaje/ruta-aprendizaje.component';
import { CourseComponent } from './components/course/course.component';

const routes: Routes = [
  { path: 'ruta-aprendizaje', component: RutaAprendizajeComponent },
  { path: 'course', component: CourseComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
