package com.cognizant.emergencyHelpline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class HospitalManagementService {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementService.class, args);
	}

}
