package com.cognizant.emergencyHelpline.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.emergencyHelpline.collections.PatientDetails;
import com.cognizant.emergencyHelpline.dto.PatientProfileDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionRequestDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.services.AdmissionDetailsService;
import com.cognizant.emergencyHelpline.services.PatientDetailsService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PatientServiceController {
	
	@Autowired
	private PatientDetailsService patientService;
		
	@Autowired
	private AdmissionDetailsService admissionService;
							
	@GetMapping("/searchPatientsForAnalytics")
	public ResponseEntity<Object> getPatientDetailsForAnalytics() {		
		List<PatientDetails> patientSearchResponse = patientService.getPatientDetails();
		return CollectionUtils.isEmpty(patientSearchResponse) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(patientSearchResponse, HttpStatus.OK);		
	}
	
	@PostMapping("/submitAdmission")
	public ResponseEntity<Object> submitAdmission(@RequestBody SubmitAdmissionRequestDTO submitAdmission) {
		SubmitAdmissionResponseDTO submitAdmissionResponse = admissionService.submitAdmissionDetails(submitAdmission);
		return ObjectUtils.isEmpty(submitAdmissionResponse)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(submitAdmissionResponse, HttpStatus.OK);
	}
	@GetMapping("/viewAdmission/{mobileNumber}")
	public ResponseEntity<Object> viewAdmission(@PathVariable("mobileNumber") String mobileNumber) {
		List<ViewAdmissionResponseDTO> viewAdmission = admissionService.viewAdmissionRequest(mobileNumber);
		return ObjectUtils.isEmpty(viewAdmission)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(viewAdmission, HttpStatus.OK);
	}
	
	@GetMapping("/viewPatientProfile/{mobileNumber}")
	public ResponseEntity<Object> viewPatientProfile(@PathVariable("mobileNumber") String mobileNumber) {
		PatientProfileDTO patientDetail = patientService.findByMobileNumber(mobileNumber);
		return ObjectUtils.isEmpty(patientDetail)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(patientDetail, HttpStatus.OK);
	}
	
	@PostMapping("/updateProfile")
	public ResponseEntity<Object> updatePatientProfile(@RequestBody PatientProfileDTO patientProfileDTO) {
		String saveMessage = patientService.savePatientDetails(patientProfileDTO);
		
		return ObjectUtils.isEmpty(saveMessage)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(saveMessage, HttpStatus.OK);
	}
}
