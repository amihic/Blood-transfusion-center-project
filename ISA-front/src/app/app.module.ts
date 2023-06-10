import { CommonModule } from "@angular/common";
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { RegistrationComponent } from './registration/registration.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { MedCentersComponent } from './med-centers/med-centers.component';
import { QuestionsForDonnorComponent } from './questions-for-donnor/questions-for-donnor.component';
import { VerificationComponent } from './verification/verification.component';
import { LoginComponent } from './login/login.component';
import { TokenInterceptor } from "./interceptor/TokenInterceptor";
import { AppointmentsComponent } from './appointments/appointments.component';
import { FutureAppointmentsComponent } from './future-appointments/future-appointments.component';



@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    RegistrationComponent,
    HomeComponent,
    MedCentersComponent,
    QuestionsForDonnorComponent,
    VerificationComponent,
    LoginComponent,
    AppointmentsComponent,
    FutureAppointmentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    HttpClientModule,
    CommonModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatTabsModule

    
    
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
