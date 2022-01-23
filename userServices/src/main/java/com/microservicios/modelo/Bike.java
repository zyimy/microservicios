package com.microservicios.modelo;

public class Bike {
	

	private String brand;

	private String model;
	
	private int userId;

	public Bike() {

	}

	public Bike(String brand, String model) {

		this.brand = brand;
		this.model = model;
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
