package com.cognizant.emergencyHelpline.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	private HospitalRepository hospitalRepository;

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AdmissionRepository admissionRepository;	

	@Override
	public List<ViewAdmissionResponseDTO> viewAdmissionRequest(String HospitalRegnNo) {
		log.info(String.format("Get patient Details by Mobile Number"));
		List<ViewAdmissionResponseDTO> dto = new ArrayList<>();
		List<AdmissionDetails> viewAdmissionRespList = admissionRepository.findByHospitalRegnNo(HospitalRegnNo);
		for(AdmissionDetails viewAdmissionResp: viewAdmissionRespList) {
		HospitalDetails hospitalDetail = hospitalRepository.findByHospitalRegnNo(viewAdmissionResp.getHospitalRegnNo());
		PatientDetails patientDetails = patientRepository.findByMobileNumber(viewAdmissionResp.getMobileNumber());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		String strDate = dateFormat.format(viewAdmissionResp.getRequestedDate());
		ViewAdmissionResponseDTO viewAdmissionDto = new ViewAdmissionResponseDTO(viewAdmissionResp.getRequestNumber(), patientDetails.getMobileNumber(),
				strDate, hospitalDetail.getHospitalName(),
				viewAdmissionResp.getAdmissionStatus(), viewAdmissionResp.getComments(),
				patientDetails.getEmail(), patientDetails.getAddress(),
				patientDetails.getCity(), patientDetails.getPincode(), patientDetails.getState(),
				patientDetails.getCountry(), patientDetails.getInsuranceProvider(),
				patientDetails.getInsuranceTpaName(), patientDetails.getInsuranceId(), patientDetails.getBloodGroup(),
				patientDetails.getGender(), patientDetails.getDob(), patientDetails.getMaritalStatus(),
				patientDetails.getIdProofType(), patientDetails.getIdProofNumber(), patientDetails.getMedicalHistory());
		dto.add(viewAdmissionDto);
		}
		log.info(String.format("received patient details %s", dto));
		return dto;
	}

	@Override
	public SubmitAdmissionResponseDTO submitAdmissionDetails(SubmitAdmissionRequestDTO adminHospAubmitReq) {
		String message;
		log.info(String.format("Save Admission Details"));
		AdmissionDetails viewAdmissionResp =  admissionRepository.findByRequestNumber(adminHospAubmitReq.getRequestNumber());
		viewAdmissionResp.setAdmissionStatus(adminHospAubmitReq.getAdmissionStatus());
		viewAdmissionResp.setComments(adminHospAubmitReq.getComments());
		try {
			admissionRepository.save(viewAdmissionResp);
			 message = "Request submitted Successfully";
			} catch (Exception e) {
				message = "Error during submission";
				e.printStackTrace();
			}
			log.info(String.format("save patient details %s", message));
			SubmitAdmissionResponseDTO submittedData = new SubmitAdmissionResponseDTO(adminHospAubmitReq.getRequestNumber(), message);
		return submittedData;
	}


}
