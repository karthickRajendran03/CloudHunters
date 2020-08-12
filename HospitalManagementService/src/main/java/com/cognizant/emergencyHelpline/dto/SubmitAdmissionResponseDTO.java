package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SubmitAdmissionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1438262088903709116L;

	private String RequestNumber;
	private String message;	
}
