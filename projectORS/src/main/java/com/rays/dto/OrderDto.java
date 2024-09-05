package com.rays.dto;


import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_ORDER")

public class OrderDTO extends BaseDTO {

	
	
	@Column(name = "QUANTITY",length = 50)
	private Long quantity;
		
		
		@Column(name = "DOB")
		private Date date;
		
		@Column(name = "AMOUNT",length = 50)
		private Long amount;
		
		

		@Column(name = "PRODUCT",length = 50)
		private String product;
		
		

		

		

		
		public Long getQuantity() {
			return quantity;
		}

		public void setQuantity(Long quantity) {
			this.quantity = quantity;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		

		public Long getAmount() {
			return amount;
		}

		public void setAmount(Long amount) {
			this.amount = amount;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
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
			map.put("product", "product");
			return map;
		}

		@Override
		public LinkedHashMap<String, Object> uniqueKeys() {
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("product", product);
			return map;
		}

	}

	
	
	

