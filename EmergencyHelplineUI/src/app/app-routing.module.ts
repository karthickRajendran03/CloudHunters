import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HospitalComponent } from './hospital/hospital.component';
import { ServicesComponent } from './services/services.component';
import { AdminComponent } from './admin/admin.component';
import { ViewrequestComponent } from './viewrequest/viewrequest.component';
const routes: Routes = [
 {
    path:"about",
    component:AboutComponent
  },
  {
    path:"dashboard",
    component:DashboardComponent
  },
  {
    path:"",
    component:DashboardComponent
  },
   {
    path:"contact",
    component:ContactComponent
  },
   {
    path:"hospital",
    component:HospitalComponent
  },
  {
    path:"services",
    component:ServicesComponent
  },
  {
    path:"admin",
    component:AdminComponent
  },
  {
    path:"viewrequest",
    component:ViewrequestComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
