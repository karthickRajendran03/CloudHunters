import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from "@angular/forms";
import { DataserviceService } from "../service/dataservice.service";
import {
  ModelData,
  DistrictTalukPinCode,
  ApiResponse,
  RequestInput,
  ApiResponseArray,
  ViewAdmissionRequestArray,Login,HospitalLogin
} from "../model/modeldata";
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private dataService: DataserviceService) { }


loginForm:FormGroup;
loginRequest:Login= new Login();
login:Login;
usr:String = "";
response:String  = "";
isNotRegistered: string = "";
isRegistered: string= "";
  ngOnInit() {
    this.usr = "loguser";
    this.isNotRegistered = "false";
    this.loginForm = this.formBuilder.group({
    usertype: ['patientLogin',Validators.required],
    name: ['', Validators.required],
    username: ['', Validators.required],
    password: ['',Validators.required]
  });
  }
 usrType:string="patientLogin";
 username:string="";
 name:string="";
 pass:string="";

loginUser(){
  this.usrType= this.loginForm.get('usertype').value;
  this.username = this.loginForm.get('username').value;
  this.pass = this.loginForm.get('password').value;
  if(this.usrType==="patientLogin"){
 if(!this.username && !this.pass){
   alert("Please enter Mobile Number and Password to login")
 }else{
  this.loginRequest.roles = this.usrType;
  this.loginRequest.username = this.username;
  this.loginRequest.password = this.pass;
  this.dataService.authService(JSON.stringify(this.loginRequest)).subscribe(data=>{
      window.sessionStorage.setItem('token', JSON.stringify(data));
      this.dataService.getUsers(this.loginRequest.username).subscribe(data=>{
    if(data){
      if(data.roles === this.usrType && data.username === this.username){
      sessionStorage.setItem("userType",this.usrType);
      sessionStorage.setItem("userName",this.username);
      } else{
        this.usr="register";
      }
    }
  })
  })
 }
} else {
  if(!this.username && !this.pass){
    alert("Please enter Hospital Registration and Password to login")
  }else{
   this.loginRequest.roles = this.usrType;
   this.loginRequest.username = this.username;
   this.loginRequest.password = this.pass;
   this.dataService.authService(JSON.stringify(this.loginRequest)).subscribe(data=>{
     if(data){
       if(data.roles === this.usrType && data.username === this.username){
       sessionStorage.setItem("userType",this.usrType);
       sessionStorage.setItem("userName",this.username);
       } else{
         this.usr="register";
       }
     }

   })
  }
}
}

setradio(e: string): void{
   this.usrType = e;
 }

register(){
  this.loginRequest.roles = this.usrType;
  this.loginRequest.username = this.username;
  this.loginRequest.password = this.pass;
  this.loginRequest.name = this.name;
  this.dataService.registerUser(JSON.stringify(this.loginRequest)).subscribe(data=>{
    this.isRegistered = "true";
    this.usr="loguser";
})
}

}
