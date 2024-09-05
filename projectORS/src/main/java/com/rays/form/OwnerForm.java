package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.dto.OwnerDTO;
import com.rays.dto.OwnerDTO;

public class OwnerForm extends BaseForm {

	@NotEmpty(message = "Please enter name")
	// @ValidAlphabetic(message = "Please type alphabets")
	@Pattern(regexp = "^[a-zA-Z]*$", message = "Please enter alphabetic characters only")
	private String name; 

	@NotNull(message = "dob is required")
	private String dob;

	@NotEmpty(message = "insuranceAmount is required")
	private String insuranceAmount;

	@NotEmpty(message = "vehicleId is required")
	private String vehicleId;

	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public String getInsuranceAmount() {
		return insuranceAmount;
	}



	public void setInsuranceAmount(String insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}



	public String getVehicleId() {
		return vehicleId;
	}



	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}



	@Override
	public BaseDTO getDto() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		OwnerDTO dto = initDTO(new OwnerDTO());
		if (insuranceAmount != null && !insuranceAmount.isEmpty()) {
			dto.setInsuranceAmount(Long.valueOf(insuranceAmount));
		}
		dto.setVehicleId(vehicleId);;
		if (dob != null && !dob.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(dob);
				dto.setDob(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}
		dto.setName(name);

		return dto;
	}

}
