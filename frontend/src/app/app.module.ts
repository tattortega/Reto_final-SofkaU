import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LearningRouteComponent } from './components/learning-route/learning-route.component';
import { CourseComponent } from './components/course/course.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { CourseFormComponent } from './components/modal/course-form/course-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LearningRouteFormComponent } from './components/modal/learning-route-form/learning-route-form.component';

@NgModule({
  declarations: [
    AppComponent,
    LearningRouteComponent,
    CourseComponent,
    CourseFormComponent,
    LearningRouteFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    ReactiveFormsModule,
    NgbModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  entryComponents: [CourseFormComponent],
})
export class AppModule {}
