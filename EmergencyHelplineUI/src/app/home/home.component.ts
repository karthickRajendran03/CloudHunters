import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"]
})
export class HomeComponent implements OnInit {
  showAbout: boolean = false;
  constructor() {}
  userType: string = "";

userName:String = "Login/Sign Up";
sessionUser:String = "";
  ngOnInit() {

   this.userType = sessionStorage.getItem("userType");   
   this.sessionUser = sessionStorage.getItem("userName")
   if(this.sessionUser){
this.userName = this.sessionUser;
   }
  }
}
