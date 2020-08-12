package com.cognizant.emergencyHelpline.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.emergencyHelpline.collections.HospitalDetails;

@Repository
public interface HospitalRepository extends MongoRepository<HospitalDetails, String> {	
	List<HospitalDetails> findAll();
	HospitalDetails findByHospitalRegnNo(String hospitalRegnNo);		
}
