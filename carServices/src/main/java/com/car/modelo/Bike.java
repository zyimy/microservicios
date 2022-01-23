package com.car.modelo;

public class Bike {

	private String brand;

	private String model;

	public Bike() {

	}

	public Bike(String brand, String model) {

		this.brand = brand;
		this.model = model;
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
