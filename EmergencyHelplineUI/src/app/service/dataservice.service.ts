import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from "@angular/common/http";
import {
  ModelData,
  DistrictTalukPinCode,
  ApiResponse,Login,
  ApiResponseArray,ViewAdmissionRequestArray,SubmitAdmissionResponse,ViewAdmissionHospitalRequestArray
} from "../model/modeldata";
@Injectable({
  providedIn: 'root'
})
export class DataserviceService {

  constructor(private http: HttpClient) { }


   public getHospitalSearchResult(requestInput){
      const headers = {
      'Content-type': 'application/json'
    }
      return this.http.post<ApiResponseArray>('http://localhost:8083/hospital/searchHospitals', requestInput, {headers});
    }

  public getSubmittedRequests(mobNumber){
    const headers = {
    'Content-type': 'application/json'
  }
    mobNumber = "9840789719";
    return this.http.get<ViewAdmissionRequestArray>('http://localhost:8082/patient/viewAdmission/' + mobNumber, {headers});
  }

  public viewHospitalSubmittedRequests(hospitalRegnNo){
    const headers = {
    'Content-type': 'application/json'
  }
    hospitalRegnNo = "REGN1234";
    return this.http.get<ViewAdmissionHospitalRequestArray>('http://localhost:8083/hospital/viewAdmission/' + hospitalRegnNo, {headers});
  }

  public submitRequest(submitAdmissionRequest){
    const headers = {
    'Content-type': 'application/json'
  }
    console.log(JSON.stringify(submitAdmissionRequest))
    return this.http.post<SubmitAdmissionResponse>('http://localhost:8083/patient/submitAdmission', submitAdmissionRequest, {headers});
  }

  public submitHospitalRequest(submitAdmissionRequest){
    const headers = {
    'Content-type': 'application/json'
  }
    console.log(JSON.stringify(submitAdmissionRequest))    
    return this.http.post<SubmitAdmissionResponse>('http://localhost:8083/patient/submitAdmission', submitAdmissionRequest, {headers});
  }

  public authService(user){
    const headers = {
      'Authorization': 'Basic ' + btoa('cognizant:hackathon'),
       'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8',
       'Access-Control-Allow-Headers' : '*',
    	  'Access-Control-Allow-Origin': '*',
    	  'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
    	  'Access-Control-Max-Age': '3600'
    }
    return this.http.post<any>("http://localhost:8081/oauth/token", user, {headers});
}

public getUsers(userName) {
  console.log(userName)
    return this.http.get<any>("http://localhost:8081/user?access_token=" + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }

public registerUser(user){
  const httpHeaders ={
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  console.log(user)
return this.http.post<any>("localhost:8081/authentication/register", user, httpHeaders);
}
}
