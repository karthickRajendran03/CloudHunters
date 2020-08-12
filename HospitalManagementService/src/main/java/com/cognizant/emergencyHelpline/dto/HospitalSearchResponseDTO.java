package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HospitalSearchResponseDTO  implements Serializable{

	private static final long serialVersionUID = -2512071192667431484L;

	private String hospitalRegnNo;
	private String hospitalName;
	private String contactNumber;
	private String hospitalType;
	private String email;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String latitude;
	private String longitude;
	private String multiSpeciality;
	private String ambulanceAvailability;
	private String bloodBankAvailability;
	private String scanAvailability;
	private String insuranceAvailability;
	private String bedCapacity;
	private String bedAvailable;
	private String ventilatorFacility;
	private String ventilatorCapacity;
	private String ventilatorAvailable;
	private String covidSpeciality;
	private String heartSpeciality;
	private String accidentSpeciality;
	private String orthoSpeciality;
	private String neuroSpeciality;

}
