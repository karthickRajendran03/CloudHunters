package com.cognizant.emergencyHelpline.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.emergencyHelpline.collections.AdmissionDetails;
import com.cognizant.emergencyHelpline.collections.HospitalDetails;
import com.cognizant.emergencyHelpline.collections.PatientDetails;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionRequestDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.repositories.AdmissionRepository;
import com.cognizant.emergencyHelpline.repositories.HospitalRepository;
import com.cognizant.emergencyHelpline.repositories.PatientRepository;
import com.cognizant.emergencyHelpline.services.AdmissionDetailsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdmissionDetailsServiceImpl implements AdmissionDetailsService{
	private static final Logger log = LoggerFactory.getLogger(AdmissionDetailsServiceImpl.class);

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private AdmissionRepository admissionRepository;	

	@Override
	public List<ViewAdmissionResponseDTO> viewAdmissionRequest(String mobileNumber) {
		log.info(String.format("Get patient Details by Mobile Number"));		
		List<ViewAdmissionResponseDTO> resp = new ArrayList<>(); 
		List<AdmissionDetails> viewAdmissionResponse =  admissionRepository.findByMobileNumber(mobileNumber);
		for(AdmissionDetails viewAdmissionResp : viewAdmissionResponse) {
		HospitalDetails hospitalDetail = hospitalRepository
				.findByHospitalRegnNo(viewAdmissionResp.getHospitalRegnNo());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String strDate = dateFormat.format(viewAdmissionResp.getRequestedDate());  				
		ViewAdmissionResponseDTO viewAdmissionDto = new ViewAdmissionResponseDTO(viewAdmissionResp.getRequestNumber(),
				strDate, hospitalDetail.getHospitalName(), viewAdmissionResp.getAdmissionStatus(), viewAdmissionResp.getComments());
		resp.add(viewAdmissionDto);
		}
		log.info(String.format("received patient details %s", viewAdmissionResponse.toString()));
		return resp;
	}

	@Override
	public SubmitAdmissionResponseDTO submitAdmissionDetails(SubmitAdmissionRequestDTO patientProfileDTO) {
		String message;
		log.info(String.format("Save Admission Details"));
		PatientDetails patientDetails =  patientRepository.findByMobileNumber(patientProfileDTO.getMobileNumber());
		HospitalDetails hospitalDetails =  hospitalRepository.findByHospitalRegnNo(patientProfileDTO.getHospitalRegnNo());
		AdmissionDetails details = new AdmissionDetails();
		details.setAdmissionStatus("Submitted");
		details.setComments("Please approve my request");
		details.setHospitalRegnNo(hospitalDetails.getHospitalRegnNo());
		details.setLastUpdDt(new Date());
		details.setMobileNumber(patientDetails.getMobileNumber());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = format.format(new Date());		
		details.setRequestedDate(new Date());		
		details.setRequestNumber(patientDetails.getMobileNumber()+ hospitalDetails.getHospitalRegnNo()+ dateString);
		try {
			admissionRepository.save(details);
			 message = "Request submitted Successfully";
			} catch (Exception e) {
				message = "Error during submission";
				e.printStackTrace();
			}
			log.info(String.format("save patient details %s", message));
			SubmitAdmissionResponseDTO submittedData = new SubmitAdmissionResponseDTO(details.getRequestNumber(), message);
		return submittedData;
	}


}
