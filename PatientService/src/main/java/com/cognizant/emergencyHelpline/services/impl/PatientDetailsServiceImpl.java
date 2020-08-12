package com.cognizant.emergencyHelpline.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.emergencyHelpline.collections.PatientDetails;
import com.cognizant.emergencyHelpline.dto.PatientProfileDTO;
import com.cognizant.emergencyHelpline.repositories.PatientRepository;
import com.cognizant.emergencyHelpline.services.PatientDetailsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientDetailsServiceImpl implements PatientDetailsService{
	private static final Logger log = LoggerFactory.getLogger(PatientDetailsServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<PatientDetails> getPatientDetails() {
		log.info(String.format("Get all patient Details"));
		List<PatientDetails> patientListDetails =  patientRepository.findAll();
		log.info(String.format("received list of Patient details :  %s", patientListDetails));
		return patientListDetails;
	}

	@Override
	public PatientProfileDTO findByMobileNumber(String mobileNumber) {
		log.info(String.format("Get patient Details by Mobile Number"));
		PatientDetails patientDetails =  patientRepository.findByMobileNumber(mobileNumber);
		PatientProfileDTO patientData = new PatientProfileDTO(patientDetails.getMobileNumber(),
				patientDetails.getEmail(), patientDetails.getAddress(), patientDetails.getCity(),
				patientDetails.getPincode(), patientDetails.getState(), patientDetails.getCountry(),
				patientDetails.getInsuranceProvider(), patientDetails.getInsuranceTpaName(),
				patientDetails.getInsuranceId(), patientDetails.getBloodGroup(), patientDetails.getGender(),
				patientDetails.getDob(), patientDetails.getMaritalStatus(), patientDetails.getIdProofType(),
				patientDetails.getIdProofNumber(), patientDetails.getMedicalHistory());
		log.info(String.format("received patient details %s", patientDetails));
		return patientData;
	}
	
	@Override
	public String savePatientDetails(PatientProfileDTO patientProfileDTO) {
		String message;
		log.info(String.format("Save Patient Details"));
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setAddress(patientProfileDTO.getAddress());
		patientDetails.setBloodGroup(patientProfileDTO.getBloodGroup());
		patientDetails.setCity(patientProfileDTO.getCity());
		patientDetails.setCountry(patientProfileDTO.getCountry());
		patientDetails.setDob(patientProfileDTO.getDob());
		patientDetails.setEmail(patientProfileDTO.getEmail());
		patientDetails.setGender(patientProfileDTO.getGender());
		patientDetails.setIdProofNumber(patientProfileDTO.getIdProofNumber());
		patientDetails.setIdProofType(patientProfileDTO.getIdProofType());
		patientDetails.setInsuranceId(patientProfileDTO.getInsuranceId());
		patientDetails.setInsuranceProvider(patientProfileDTO.getInsuranceProvider());
		patientDetails.setInsuranceTpaName(patientProfileDTO.getInsuranceTpaName());
		patientDetails.setLastUpdDt(new Date());
		patientDetails.setMaritalStatus(patientProfileDTO.getMaritalStatus());
		patientDetails.setMedicalHistory(patientProfileDTO.getMedicalHistory());
		patientDetails.setMobileNumber(patientProfileDTO.getMobileNumber());
		patientDetails.setPincode(patientProfileDTO.getPincode());
		patientDetails.setState(patientProfileDTO.getState());
		try {
		 patientRepository.save(patientDetails);
		 message = "Profile updated Successfully";
		} catch (Exception e) {
			message = "Error during saving data";
			e.printStackTrace();
		}
		log.info(String.format("save patient details %s", message));
		return message;
	}
	
}
