package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.WishListDTO;

public class WishListForm extends BaseForm {

	@NotEmpty(message = "please enter product")
	private String product;

	@NotNull(message = "please enter date")
	private Date date;

	@NotEmpty(message = "please enter userName")
	private String userName;

	@NotEmpty(message = "please enter remark")
	private String remark;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public BaseDTO getDto() {
		WishListDTO dto = initDTO(new WishListDTO());
		dto.setProduct(product);
		dto.setDate(date);
		dto.setUserName(userName);
		dto.setRemark(remark);
		return dto;
	}

}
