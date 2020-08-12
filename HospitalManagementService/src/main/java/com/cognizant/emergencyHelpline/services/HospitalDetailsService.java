package com.cognizant.emergencyHelpline.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.emergencyHelpline.dto.HospitalSearchRequestDTO;
import com.cognizant.emergencyHelpline.dto.HospitalSearchResponseDTO;

@Service
public interface HospitalDetailsService {
	
	List<HospitalSearchResponseDTO> getHospitalDetails(HospitalSearchRequestDTO searchData);
	List<HospitalSearchResponseDTO> getHospitalDetails();
	HospitalSearchResponseDTO findByHospitalRegnNo(String hosRegnNo);		
	String saveHospitalDetails(HospitalSearchResponseDTO hospitalProfileDTO);
}
