package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;

import com.rays.dto.OrderDTO;
import com.rays.dto.OrderDTO;

public class OrderForm extends BaseForm {

	@NotNull(message = "date is required")
	private String date;

	@NotEmpty(message = "Amount is required")
	private String amount;

	@NotEmpty(message = "Quantity is required")
	private String quantity;

	@NotEmpty(message = "product is required")
	private String product;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public BaseDTO getDto() {
		
		OrderDTO dto = initDTO(new OrderDTO());
		if (amount != null && !amount.isEmpty()) {
			dto.setAmount(Long.valueOf(amount));
		}
		dto.setProduct(product);
		;
		if (date != null && !date.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(date);
				dto.setDate(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}
		
		if (quantity != null && !quantity.isEmpty()) {
			dto.setQuantity(Long.valueOf(quantity));
		}
		

		return dto;
	}

}
