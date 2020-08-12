import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ContactComponent } from './contact/contact.component';
import { HospitalComponent } from './hospital/hospital.component';
import { ServicesComponent } from './services/services.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RequestdetailsComponent } from './requestdetails/requestdetails.component';
import {HttpClientModule} from '@angular/common/http';
import { ViewrequestComponent } from './viewrequest/viewrequest.component';
import { Router } from '@angular/router';
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
    HospitalComponent,
    ServicesComponent,
    AdminComponent,
    RequestdetailsComponent,
    ViewrequestComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
