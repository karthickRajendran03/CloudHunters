package com.cognizant.emergencyHelpline.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.collections.AdmissionDetails;
import com.cognizant.emergencyHelpline.dto.ViewAdmissionResponseDTO;

@Repository
public interface AdmissionRepository extends MongoRepository<AdmissionDetails, String>{
	List<AdmissionDetails> findAll();
	List<AdmissionDetails> findByMobileNumber(String mobileNumber);
	String save(ViewAdmissionResponseDTO admissionDetails);	
}
