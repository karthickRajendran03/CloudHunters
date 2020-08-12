package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewAdmissionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1438262088903709116L;

	private String requestNumber;
	private String mobileNumber;
	private String requestedDate;
	private String hospitalName;
	private String admissionStatus;
	private String comments;
	private String email;
	private String address;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String insuranceProvider;
	private String insuranceTpaName;
	private String insuranceId;
	private String bloodGroup;
	private String gender;
	private Date dob;
	private String maritalStatus;
	private String idProofType;
	private String idProofNumber;
	private String medicalHistory;	
	
	
}
