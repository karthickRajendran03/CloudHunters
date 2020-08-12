package com.cognizant.emergencyHelpline.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.collections.PatientDetails;

@Repository
public interface PatientRepository extends MongoRepository<PatientDetails, String>{	
	PatientDetails findByMobileNumber(String mobileNumber);	
}
