package com.cognizant.emergencyHelpline.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.collections.AdmissionDetails;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;

@Repository
public interface AdmissionRepository extends MongoRepository<AdmissionDetails, String>{
	List<AdmissionDetails> findAll();
	AdmissionDetails findByRequestNumber(String requestNumber);
	String save(ViewAdmissionResponseDTO admissionDetails);
	List<AdmissionDetails> findByHospitalRegnNo(String hospitalRegnNo);	
}
