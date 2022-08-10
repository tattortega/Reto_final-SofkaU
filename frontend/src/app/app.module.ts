
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {ToastrModule} from 'ngx-toastr';

import { AngularFireModule } from '@angular/fire/compat';
import { AngularFireAuthModule } from '@angular/fire/compat/auth';
import { AngularFireStorageModule } from '@angular/fire/compat/storage';
import { AngularFirestoreModule } from '@angular/fire/compat/firestore';
import { AngularFireDatabaseModule } from '@angular/fire/compat/database';

import { environment } from '../environments/environment';

import { MenuComponent } from './components/menu/menu.component';
import { NavComponent } from './components/nav/nav.component';

// page
import { SignInComponent } from './page/sign-in/sign-in.component';
import { ProfileComponent } from './page/profile/profile.component';
import { CourseFormComponent } from './page/course/course-form/course-form.component';
import {CourseComponent} from './page/course/course.component';
import {LearningRouteComponent} from './page/learning-route/learning-route.component';

// routing
import { AppRoutingModule } from './app-routing.module';

// service
import { AuthService } from './shared/services/auth.service';
import { CourseService } from './shared/services/course/course.service';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    NavComponent,
    LearningRouteComponent,
    SignInComponent,
    ProfileComponent,
    CourseFormComponent,
    CourseComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireAuthModule,
    AngularFirestoreModule,
    AngularFireStorageModule,
    AngularFireDatabaseModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot(),
    NgbModule
    ],
  providers: [AuthService, CourseService],
  bootstrap: [AppComponent],
})

export class AppModule {}
