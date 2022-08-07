import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RutaAprendizajeComponent } from './components/ruta-aprendizaje/ruta-aprendizaje.component';

@NgModule({
  declarations: [
    AppComponent,
    RutaAprendizajeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
