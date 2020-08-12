package com.cognizant.emergencyHelpline.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.collections.PatientDetails;

@Repository
public interface PatientRepository extends MongoRepository<PatientDetails, String>{
	List<PatientDetails> findAll();
	PatientDetails findByMobileNumber(String mobileNumber);	
}
