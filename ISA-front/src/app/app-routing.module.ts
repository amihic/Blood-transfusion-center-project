import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegistrationComponent } from '../app/registration/registration.component';
import { HomeComponent } from '../app/home/home.component';
import { MedCentersComponent } from './med-centers/med-centers.component';
import { QuestionsForDonnorComponent } from './questions-for-donnor/questions-for-donnor.component';
import { VerificationComponent } from './verification/verification.component';

const routes: Routes = [
  {path: 'registration', component: RegistrationComponent},
  {path: 'home', component: HomeComponent},
  {path: 'medCenters', component: MedCentersComponent},
  {path: 'questionsForDonnor', component: QuestionsForDonnorComponent},
  {path: 'verification', component: VerificationComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
