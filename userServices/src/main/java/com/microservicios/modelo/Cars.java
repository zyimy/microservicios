package com.microservicios.modelo;

import javax.persistence.Column;

public class Cars {

	private String brand;

	private String model;
	
	private int userId;
	
	
	

	public Cars() {

	}

	public Cars(String brand, String model,int userId) {

		this.brand = brand;
		this.model = model;
		this.userId=userId;
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
