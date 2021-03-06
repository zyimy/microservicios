package com.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.modelo.Cars;
import com.car.repository.CarsRepository;

@Service
public class CarsService {
	
	@Autowired
	CarsRepository ur;
	
	public List<Cars>getAll(){
		
		return ur.findAll();
	}
	
	public Cars getUserById(int id) {
		return ur.findById(id).orElse(null);
	}
	
	public Cars save(Cars users) {
		Cars user = ur.save(users);
		
		return user;
	}
	
	public List<Cars>byUserId(int userId){
		return ur.findByUserId(userId);
	}

}
