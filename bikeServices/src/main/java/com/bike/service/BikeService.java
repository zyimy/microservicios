package com.bike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.modelo.Bike;
import com.bike.repository.BikeRepository;

@Service
public class BikeService {
	
	@Autowired
	BikeRepository ur;
	
	public List<Bike>getAll(){
		
		return ur.findAll();
	}
	
	public Bike getUserById(int id) {
		return ur.findById(id).orElse(null);
	}
	
	public Bike save(Bike users) {
		Bike user = ur.save(users);
		
		return user;
	}
	
	public List<Bike>byUserId(int userId){
		return ur.findByUserId(userId);
	}

}
