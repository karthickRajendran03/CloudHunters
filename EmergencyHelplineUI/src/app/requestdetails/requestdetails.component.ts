import { Component, OnInit } from '@angular/core';
import { Input } from '@angular/core';
import { ModelData, DistrictTalukPinCode , ApiResponse, ViewHospitalAdmissionResponse} from "../model/modeldata";
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-requestdetails',
  templateUrl: './requestdetails.component.html',
  styleUrls: ['./requestdetails.component.css']
})
export class RequestdetailsComponent implements OnInit {
@Input() stateDropDownData:ModelData[];
userType: string;
@Input() apiResponse:ApiResponse;
apiResponseObj : ApiResponse;
@Input() viewAdmissionHospitalRequest: ViewHospitalAdmissionResponse;
apiHospitalResponseObj: ViewHospitalAdmissionResponse;
  constructor() {

  }

  ngOnInit() {


     this.userType = sessionStorage.getItem("userType");
     if( this.userType == "patientLogin") {
       this.apiResponseObj = this.apiResponse;
       console.log("In RequestdetailsComponent : stateDropDownData:"+this.stateDropDownData)
       console.log("In RequestdetailsComponent : apiResponse :"+this.apiResponse)
  } else {
     this.apiHospitalResponseObj = this.viewAdmissionHospitalRequestObj;
     console.log("In RequestdetailsComponent : apiResponse :"+this.apiHospitalResponseObj)
  }

  }



}
