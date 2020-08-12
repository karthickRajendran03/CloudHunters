package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class HospitalSearchRequestDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1774463984135020277L;
	
	private String state;
	private String city;
	private String pincode;
	private String speciality;
	
}
