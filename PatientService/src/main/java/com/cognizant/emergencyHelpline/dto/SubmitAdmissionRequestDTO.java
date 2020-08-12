package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubmitAdmissionRequestDTO implements Serializable {

	private static final long serialVersionUID = 1282274672333397263L;

	private String mobileNumber;
	private String hospitalRegnNo;

}
