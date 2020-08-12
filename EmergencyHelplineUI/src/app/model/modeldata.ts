export class ModelData {
  stateName: String;
  districtTalukPinCode: DistrictTalukPinCode[];
}

export class DistrictTalukPinCode {
  districtTalukPinCode: String;
}
export class ApiResponseArray{
  apiResArray:ApiResponse [];
}

export class ApiResponse  {
  hospitalRegnNo: String = null;
  hospitalName: String = null;
  hospitalType: String = null;
  contactNumber: String = null;
  address: String = null;
  multiSpeciality: String = null;
  ambulanceAvailability: String = null;
  bloodBankAvailability: String = null;
  scanAvailability: String = null;
  insuranceAvailability: String = null;
  email: String = null;
  city: String = null;
  pincode: String = null;
  state: String = null;
  country: String = null;
  latitude: String = null;
  longitude: String = null;
  bedCapacity: String = null;
  bedAvailable: String = null;
  ventilatorFacility: String = null;
  ventilatorCapacity: String = null;
  ventilatorAvailable: String = null;
  covidSpeciality: String = null;
  heartSpeciality: String = null;
  accidentSpeciality: String = null;
  orthoSpeciality: String = null;
  neuroSpeciality: String = null;
}
export class RequestInput{
  state:String = null;
  city:String = null;
  speciality:String = null;
  pincode:String = null;
}
export class ViewAdmissionRequestArray{
  viewAdmissionRequest:ViewAdmissionRequest[];
}
export class ViewAdmissionRequest{
  requestNumber:string;
  requestedDate:string;
  hospitalName:string;
  admissionStatus:string;
  comments:string;
}
export class SubmitAdmissionRequest{
  mobileNumber: String = null;
  hospitalRegnNo: String = null;
}
export class SubmitAdmissionResponse{
  requestNumber: String = null;
  message: String = null;
}
export class ViewAdmissionHospitalRequestArray{
  viewAdmissionHospitalRequestArray:ViewHospitalAdmissionResponse[];
}

export class SubmitAdmissionHospitalRequest{
  requestNumber: String = null;
  admissionStatus: String = null;
  comments: String = null;
}

export class ViewHospitalAdmissionResponse{
  requestNumber: String = null;
  mobileNumber: String = null;
  requestedDate: String = null;
  hospitalName: String = null;
  admissionStatus: String = null;
  comments: String = null;
  email: String = null;
	address: String = null;
	city: String = null;
	pincode: String = null;
	state: String = null;
	country: String = null;
	insuranceProvider: String = null;
	insuranceTpaName: String = null;
	insuranceId: String = null;
	bloodGroup: String = null;
	gender: String = null;
	dob: String = null;
	maritalStatus: String = null;
	idProofType: String = null;
	idProofNumber: String = null;
	medicalHistory: String = null;
}

export class Login{
  username:string = null;
   password:string = null;
   name:string = null;
   roles:string = null;   
}

export class HospitalLogin{
  hospitalRegn:String=null;
password:String=null;
role:String=null;

}
