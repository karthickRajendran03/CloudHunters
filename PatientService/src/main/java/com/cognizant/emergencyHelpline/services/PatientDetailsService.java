package com.cognizant.emergencyHelpline.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.emergencyHelpline.collections.PatientDetails;
import com.cognizant.emergencyHelpline.dto.PatientProfileDTO;

@Service
public interface PatientDetailsService {
	
	List<PatientDetails> getPatientDetails();
	PatientProfileDTO findByMobileNumber(String mobileNumber);
	String savePatientDetails(PatientProfileDTO patientProfileDTO);
	
}
