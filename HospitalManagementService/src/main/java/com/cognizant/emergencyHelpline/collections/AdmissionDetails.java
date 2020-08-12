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
@Document(collection = "AdmissionDetails")
public class AdmissionDetails{

	@Id
	@JsonProperty("requestNumber")
	private String requestNumber;
	
	@JsonProperty("mobileNumber")
	private String mobileNumber;
	
	@JsonProperty("hospitalRegnNo")
	private String hospitalRegnNo;

	@JsonProperty("admissionStatus")
	private String admissionStatus;

	@JsonProperty("comments")
	private String comments;

	@JsonProperty("requestedDate")
	private Date requestedDate;
	
	@JsonProperty("lastUpdDt")
	private Date lastUpdDt;

	

}
