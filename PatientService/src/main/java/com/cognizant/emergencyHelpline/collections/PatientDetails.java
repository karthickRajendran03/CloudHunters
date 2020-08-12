package com.cognizant.emergencyHelpline.collections;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PatientDetails")
public class PatientDetails {

	@Id
	@JsonProperty("mobileNumber")
	private String mobileNumber;

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

	@JsonProperty("insuranceProvider")
	private String insuranceProvider;
	
	@JsonProperty("insuranceTpaName")
	private String insuranceTpaName;
	
	@JsonProperty("insuranceId")
	private String insuranceId;

	@JsonProperty("bloodGroup")
	private String bloodGroup;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("dob")
	private Date dob;

	@JsonProperty("maritalStatus")
	private String maritalStatus;

	@JsonProperty("idProofType")
	private String idProofType;

	@JsonProperty("idProofNumber")
	private String idProofNumber;

	@JsonProperty("medicalHistory")
	private String medicalHistory;
	
	@JsonProperty("lastUpdDt")
	private Date lastUpdDt;

}
