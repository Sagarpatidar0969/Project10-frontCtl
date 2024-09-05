package com.rays.dto;


import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_OWNER")

public class OwnerDTO extends BaseDTO {

	
	
	
		
		@Column(name = "NAME",length = 50)
		private String name;
		
		@Column(name = "DOB")
		private Date dob;
		
		@Column(name = "INSURANCEAMOUNTt",length = 50)
		private Long insuranceAmount;
		
		public Long getInsuranceAmount() {
			return insuranceAmount;
		}

		public void setInsuranceAmount(Long insuranceAmount) {
			this.insuranceAmount = insuranceAmount;
		}

		@Column(name = "VECHILEID",length = 50)
		private String vehicleId;
		
		

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public String getVehicleId() {
			return vehicleId;
		}

		public void setVehicleId(String vehicleId) {
			this.vehicleId = vehicleId;
		}

		
		@Override
		public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
		}

		@Override
		public String getValue() {
			// TODO Auto-generated method stub
			return "orgName";
		}

		@Override
		public String getUniqueKey() {
			// TODO Auto-generated method stub
			return "orgName";
		}

		@Override
		public String getUniqueValue() {
			// TODO Auto-generated method stub
			return "orgName";
		}

		@Override
		public String getLabel() {
			// TODO Auto-generated method stub
			return "orgName";
		}

		@Override
		public LinkedHashMap<String, String> orderBY() {
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			map.put("name", "asc");
			return map;
		}

		@Override
		public LinkedHashMap<String, Object> uniqueKeys() {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("vehicleId", vehicleId);
			return map;
		}

	}

	
	
	

