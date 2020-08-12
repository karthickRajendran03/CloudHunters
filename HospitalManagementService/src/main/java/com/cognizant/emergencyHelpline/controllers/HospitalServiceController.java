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

import com.cognizant.emergencyHelpline.dto.HospitalSearchRequestDTO;
import com.cognizant.emergencyHelpline.dto.HospitalSearchResponseDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionRequestDTO;
import com.cognizant.emergencyHelpline.dto.SubmitAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;
import com.cognizant.emergencyHelpline.services.AdmissionDetailsService;
import com.cognizant.emergencyHelpline.services.HospitalDetailsService;

@RestController
@RequestMapping("/hospital")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospitalServiceController {
	
	@Autowired
	private HospitalDetailsService hospitalService;
		
	@Autowired
	private AdmissionDetailsService admissionService;
	
	@PostMapping("/searchHospitals")
	public ResponseEntity<Object> searchHospitals(@RequestBody HospitalSearchRequestDTO searchData) {		
		List<HospitalSearchResponseDTO> hospitalSearchResponse = hospitalService.getHospitalDetails(searchData);
		return CollectionUtils.isEmpty(hospitalSearchResponse) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(hospitalSearchResponse, HttpStatus.OK);		
	}
	
	@GetMapping("/searchallHospitalsForAnalytics")
	public ResponseEntity<Object> searchallHospitalsForAnalytics() {		
		List<HospitalSearchResponseDTO> hospitalSearchResponse = hospitalService.getHospitalDetails();
		return CollectionUtils.isEmpty(hospitalSearchResponse) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(hospitalSearchResponse, HttpStatus.OK);		
	}
	
	@GetMapping("/viewFacility/{hosRegnNo}")
	public ResponseEntity<Object> viewFacility(@PathVariable("hosRegnNo") String hosRegnNo) {
		HospitalSearchResponseDTO viewHospitalData = hospitalService.findByHospitalRegnNo(hosRegnNo);
		return ObjectUtils.isEmpty(viewHospitalData)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(viewHospitalData, HttpStatus.OK);
	}
	
	@PostMapping("/updateFacility")
	public ResponseEntity<Object> updateFacility(@RequestBody HospitalSearchResponseDTO hospitalProfileDTO) {
		String saveHospitalDetails = hospitalService.saveHospitalDetails(hospitalProfileDTO);
		return ObjectUtils.isEmpty(saveHospitalDetails)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(saveHospitalDetails, HttpStatus.OK);
	}
	
	@GetMapping("/viewAdmission/{HospitalRegnNo}")
	public ResponseEntity<Object> viewAdmission(@PathVariable("HospitalRegnNo") String HospitalRegnNo) {
		List<ViewAdmissionResponseDTO> viewAdmissioRequest = admissionService.viewAdmissionRequest(HospitalRegnNo);
		return CollectionUtils.isEmpty(viewAdmissioRequest)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(viewAdmissioRequest, HttpStatus.OK);
	}
	
	@PostMapping("/ActionAdmissionRequest")
	public ResponseEntity<Object> ActionAdmissionRequest(@RequestBody SubmitAdmissionRequestDTO submitAdmission) {
		SubmitAdmissionResponseDTO submitAdmissionResponse = admissionService.submitAdmissionDetails(submitAdmission);
		return ObjectUtils.isEmpty(submitAdmissionResponse)
				? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(submitAdmissionResponse, HttpStatus.OK);
	}
}
