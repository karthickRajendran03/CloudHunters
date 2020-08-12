import { Component, OnInit } from "@angular/core";
import { FormGroup, FormControl, FormBuilder } from "@angular/forms";
import {
  ModelData,
  DistrictTalukPinCode,
  ApiResponse,
  RequestInput,
  ApiResponseArray,
  ViewAdmissionRequestArray,
  SubmitAdmissionRequest,
  SubmitAdmissionResponse,
  ViewAdmissionHospitalRequestArray
} from "../model/modeldata";

import { FormsModule, FormArray, ReactiveFormsModule } from "@angular/forms";
import { HttpClient } from "@angular/common/http";
import { DataserviceService } from "../service/dataservice.service";
import { Router } from '@angular/router';

declare var require: any;
@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.css"]
})
export class DashboardComponent implements OnInit {
  stateDropDownData: ModelData[];
  districtDropDownData: DistrictTalukPinCode[];
  apiResponseArray: ApiResponseArray;
  apiResponse: ApiResponse;
  configData = require("./configData.json");
  mdoelData: ModelData;
  selectedStateName: string = "";
  selectedCityName: string = "";
  selectedSpeciality: string = "";
  selectedpin: string = "";
  requestAdmit: boolean;
  searchMessage: string = "";
  userType: string;
  response : string;
  showImage:boolean=false;
  viewAdmissionRequestArray: ViewAdmissionRequestArray;
  requestInput: RequestInput = new RequestInput();
  submitAdmissionRequest: SubmitAdmissionRequest = new SubmitAdmissionRequest();
  submitAdmissionResponse: SubmitAdmissionResponse = new SubmitAdmissionResponse();
  viewAdmissionHospitalRequestArray: ViewAdmissionHospitalRequestArray;
  isNotRegistered: string = "";

  constructor(
    private formBuilder: FormBuilder,
    private dataService: DataserviceService,
    private router:Router
  ) {
    this.stateDropDownData = this.configData["inputData"];
  }

  ngOnInit() {
    this.userType = sessionStorage.getItem("userType");
    this.isNotRegistered = "false";
    this.showImage = true;
  }
  dashBoardForm = this.formBuilder.group({
    state: [""],
    city: [""],
    pincode: [""],
    speciality: [""]
  });

  onStateChange(state) {
    this.selectedStateName = state;
    for (var i of this.stateDropDownData) {
      this.mdoelData = i;
      if (this.mdoelData.stateName === state) {
        this.districtDropDownData = this.mdoelData.districtTalukPinCode;
      }
    }
  }
  onCityChange(city) {
    this.selectedCityName = city;
  }

  public onSearchHospital(): boolean {
    this.selectedpin = this.dashBoardForm.get("pincode").value;
    if (
      !this.selectedStateName &&
      !this.selectedCityName &&
      !this.selectedSpeciality &&
      !this.dashBoardForm.get("pincode").value
    ) {
      this.searchMessage =
        "Please choose atleast State to search for Hospitals .... ";
        this.showImage = true;
    } else {
      this.showImage = false;
      this.searchMessage = "";
      this.requestInput.state = this.selectedStateName;
      this.requestInput.city = this.selectedCityName;
      this.requestInput.pincode = this.selectedpin;
      this.requestInput.speciality = this.selectedSpeciality;

      this.dataService
        .getHospitalSearchResult(JSON.stringify(this.requestInput))
        .subscribe(data => {
          this.apiResponseArray = data;
        });
    }
    return true;
  }
  onSpecialityChange(speciality) {
    this.selectedSpeciality = speciality;
  }
  index: number;
  onClickRequestAdmission(i,hospitalDetails) {
    this.requestAdmit = true;
    this.index = i;
    this.apiResponse = hospitalDetails;
    //remove
  //  sessionStorage.setItem("userType", "hospitalLogin");
    this.userType = sessionStorage.getItem("userType");
    if(this.userType === "patientLogin"){
      console.log(JSON.stringify(hospitalDetails));
      //remove
    //  sessionStorage.setItem("mobileNumber", "9840789719");
  //    this.userType = sessionStorage.getItem("mobileNumber");
      this.submitAdmissionRequest.hospitalRegnNo = hospitalDetails.hospitalRegnNo;
      this.dataService.submitRequest(this.submitAdmissionRequest).subscribe(data=>{
      this.submitAdmissionResponse = data;
      console.log(JSON.stringify(this.submitAdmissionResponse));
      });
     this.dataService.getSubmittedRequests("mobNumber").subscribe(data => {
      this.viewAdmissionRequestArray = data;
      sessionStorage.setItem("viewAdmissionRequestArray", JSON.stringify(this.viewAdmissionRequestArray));
    });
    this.router.navigate(['viewrequest'])
    // move this to login
    }else if(this.userType === "hospitalLogin"){
      this.dataService.viewHospitalSubmittedRequests("hospitalRegnNo").subscribe(data => {
       this.viewAdmissionHospitalRequestArray = data;
       console.log(JSON.stringify(this.viewAdmissionHospitalRequestArray))
       sessionStorage.setItem("viewAdmissionHospitalRequestArray", JSON.stringify(this.viewAdmissionHospitalRequestArray));
      });

      this.router.navigate(['viewrequest'])
    } else {
      this.isNotRegistered = "true";
    }

  }

  showDetails(i, hospitalDetails) {
    this.requestAdmit = !this.requestAdmit;
    this.index = i;
    this.apiResponse = hospitalDetails;
  }
}
