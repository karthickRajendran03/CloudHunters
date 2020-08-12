import { Component, OnInit,Input } from '@angular/core';
import { DataserviceService } from "../service/dataservice.service";
import {
  ModelData,
  DistrictTalukPinCode,
  SubmitAdmissionResponse,
  RequestInput,
  ApiResponseArray,
  ViewAdmissionRequestArray,
  ViewAdmissionHospitalRequestArray,
  SubmitAdmissionHospitalRequest,
  ViewHospitalAdmissionResponse
} from "../model/modeldata";
@Component({
  selector: 'app-viewrequest',
  templateUrl: './viewrequest.component.html',
  styleUrls: ['./viewrequest.component.css']
})
export class ViewrequestComponent implements OnInit {
viewAdmissionRequestArray:ViewAdmissionRequestArray;
viewAdmissionHospitalRequestArray:ViewAdmissionHospitalRequestArray ;
viewAdmissionHospitalRequest:ViewHospitalAdmissionResponse ;
requestAdmit: boolean;
apiResponse: SubmitAdmissionResponse;
submitAdmissionRequest: SubmitAdmissionHospitalRequest = new SubmitAdmissionHospitalRequest();

userType:string="";

  constructor(
    private dataService: DataserviceService
  ) {
  }

  ngOnInit() {
    this.userType = sessionStorage.getItem("userType");
    console.log(JSON.parse(sessionStorage.getItem("viewAdmissionHospitalRequestArray")))
    this.viewAdmissionRequestArray = JSON.parse(sessionStorage.getItem("viewAdmissionRequestArray"));
    this.viewAdmissionHospitalRequestArray = JSON.parse(sessionStorage.getItem("viewAdmissionHospitalRequestArray"));
  }

index: number;
  onClickActionApproveRequestAdmission(i,hospitalDetails) {
    this.requestAdmit = true;
    this.index = i;
    this.apiResponse = hospitalDetails;
    this.submitAdmissionRequest.requestNumber = hospitalDetails.requestNumber;
    this.submitAdmissionRequest.admissionStatus = "Approved";
    this.submitAdmissionRequest.comments = "Request Approved";
    this.dataService
      .submitHospitalRequest(JSON.stringify(this.submitAdmissionRequest))
      .subscribe(data => {
        this.apiResponse = data;
      });
  }

  onClickActionDenyRequestAdmission(i,hospitalDetails) {
    this.requestAdmit = true;
    this.index = i;
    this.apiResponse = hospitalDetails;
    this.submitAdmissionRequest.requestNumber = hospitalDetails.requestNumber;
    this.submitAdmissionRequest.admissionStatus = "Denied";
    this.submitAdmissionRequest.comments = "Request Denied due to unavailability of beds";
    this.dataService
      .submitHospitalRequest(JSON.stringify(this.submitAdmissionRequest))
      .subscribe(data => {
        this.apiResponse = data;
      });
  }

  showDetails(i, req) {
    this.requestAdmit = !this.requestAdmit;
    this.index = i;
    this.viewAdmissionHospitalRequest = req;

  }
}
