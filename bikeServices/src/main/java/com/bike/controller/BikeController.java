package com.bike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.modelo.Bike;
import com.bike.service.BikeService;

@RestController
@RequestMapping("/bike")
public class BikeController {
	
	@Autowired
	BikeService us;
	
	@GetMapping
	public ResponseEntity<List<Bike>> getAll(){
		List<Bike>users = us.getAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(users);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Bike>getById(@PathVariable("id") int id){
		Bike users = us.getUserById(id);
		
		if(users== null) {
			return ResponseEntity.notFound().build();
		}else {
			
			return ResponseEntity.ok(users);
		}
	}
	
	@PostMapping
	public ResponseEntity<Bike>save(@RequestBody Bike user){
		Bike users = us.save(user);
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Bike>>getUserId(@PathVariable("userId") int userId){
		List<Bike> cars = us.byUserId(userId);

			return ResponseEntity.ok(cars);
		
	}

}
