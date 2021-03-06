package com.microservicios.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.entity.Users;
import com.microservicios.modelo.Bike;
import com.microservicios.modelo.Cars;
import com.microservicios.service.UserService;

@RestController()
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService us;
	
	
	@GetMapping
	public ResponseEntity<List<Users>> getAll(){
		List<Users>users = us.getAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(users);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Users>getById(@PathVariable("id") int id){
		Users users = us.getUserById(id);
		
		if(users== null) {
			return ResponseEntity.notFound().build();
		}else {
			
			return ResponseEntity.ok(users);
		}
	}
	
	@PostMapping
	public ResponseEntity<Users>save(@RequestBody Users user){
		Users users = us.save(user);
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/car/{userId}")
	public ResponseEntity<List<Cars>>getCars(@PathVariable("userId") int id){
		Users users =us.getUserById(id);
		
		if(users == null) {
			return ResponseEntity.notFound().build();
		}else {
			List<Cars>cars=us.getCars(id);
			
			return ResponseEntity.ok(cars);
		}
	}
	
	@GetMapping("/bike/{userId}")
	public ResponseEntity<List<Bike>>getBikes(@PathVariable("userId") int id){
		Users users =us.getUserById(id);
		
		if(users == null) {
			return ResponseEntity.notFound().build();
		}else {
			List<Bike>bikes=us.getBike(id);
			
			return ResponseEntity.ok(bikes);
			
		}
	}
	
	@PostMapping("/savecar/{userId}")
	public ResponseEntity<Cars> saveCar(@PathVariable("userId") int userId, @RequestBody Cars car){
		if(us.getUserById(userId)==null) 
		return ResponseEntity.notFound().build();	
		
		Cars cars = us.saveCar(userId,car);
		return ResponseEntity.ok(car);
	}
	
	@PostMapping("/savebike/{userId}")
	public ResponseEntity<Bike> saveBike(@PathVariable("userId") int userId, @RequestBody Bike bike){
		if(us.getUserById(userId)==null) 
			return ResponseEntity.notFound().build();	
		Bike bikes = us.saveBike(userId,bike);
		return ResponseEntity.ok(bike);
	}
	
	@GetMapping("/getAll/{userId}")
	public ResponseEntity<Map<String,Object>>getAllVehicles(@PathVariable("userId") int userId){
		Map<String,Object>result = us.getUsersAndVehicles(userId);
		return ResponseEntity.ok(result);
		
	}

}
