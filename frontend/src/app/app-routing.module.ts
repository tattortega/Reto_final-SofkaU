import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RutaAprendizajeComponent } from './components/ruta-aprendizaje/ruta-aprendizaje.component';

const routes: Routes = [
  { path: 'ruta-aprendizaje', component: RutaAprendizajeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
