package com.cognizant.emergencyHelpline.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.emergencyHelpline.dto.SubmitAdmissionRequestDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;

@Service
public interface AdmissionDetailsService {
		
	List<ViewAdmissionResponseDTO> viewAdmissionRequest(String HospitalRegnNo);
	SubmitAdmissionResponseDTO submitAdmissionDetails(SubmitAdmissionRequestDTO submitAdmission);

}
