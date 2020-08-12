package com.cognizant.emergencyHelpline.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewAdmissionResponseDTO implements Serializable {

	private static final long serialVersionUID = 1438262088903709116L;

	private String requestNumber;
	private String requestedDate;
	private String hospitalName;
	private String admissionStatus;
	private String comments;
}
