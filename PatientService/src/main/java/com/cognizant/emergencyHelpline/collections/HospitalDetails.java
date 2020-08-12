package com.cognizant.emergencyHelpline.collections;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document(collection = "HospitalDetails")
public class HospitalDetails {

	@Id
	@JsonProperty("hospitalRegnNo")
	private String hospitalRegnNo;
	
	@JsonProperty("hospitalName")
	private String hospitalName;

	@JsonProperty("contactNumber")
	private String contactNumber;
	
	@JsonProperty("hospitalType")
	private String hospitalType;
	
	@JsonProperty("email")
	private String email;

	@JsonProperty("address")
	private String address;

	@JsonProperty("city")
	private String city;

	@JsonProperty("pincode")
	private String pincode;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	@JsonProperty("latitude")
	private String latitude;

	@JsonProperty("longitude")
	private String longitude;

	@JsonProperty("isMultiSpeciality")
	private String isMultiSpeciality;

	@JsonProperty("isAmbulanceAvailable")
	private String isAmbulanceAvailable;

	@JsonProperty("isBloodBankAvailable")
	private String isBloodBankAvailable;
	
	@JsonProperty("isScanAvailable")
	private String isScanAvailable;
	
	@JsonProperty("isInsuranceAvailable")
	private String isInsuranceAvailable;
	
	@JsonProperty("bedCapacity")
	private String bedCapacity;
	
	@JsonProperty("bedAvailable")
	private String bedAvailable;
	
	@JsonProperty("isVentilatorAvailable")
	private String isVentilatorAvailable;

	@JsonProperty("ventilatorCapacity")
	private String ventilatorCapacity;
	
	@JsonProperty("ventilatorAvailable")
	private String ventilatorAvailable;
	
	@JsonProperty("covidSpeciality")
	private String covidSpeciality;

	@JsonProperty("heartSpeciality")
	private String heartSpeciality;

	@JsonProperty("accidentSpeciality")
	private String accidentSpeciality;
	
	@JsonProperty("orthoSpeciality")
	private String orthoSpeciality;

	@JsonProperty("neuroSpeciality")
	private String neuroSpeciality;

	@JsonProperty("lastUpdDt")
	private Date lastUpdDt;

}
