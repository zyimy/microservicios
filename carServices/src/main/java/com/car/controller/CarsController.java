package com.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.modelo.Cars;
import com.car.service.CarsService;

@RestController
@RequestMapping("/car")
public class CarsController {
	
	@Autowired
	CarsService us;
	
	@GetMapping
	public ResponseEntity<List<Cars>> getAll(){
		List<Cars>users = us.getAll();
		
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(users);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Cars>getById(@PathVariable("id") int id){
		Cars users = us.getUserById(id);
		
		if(users== null) {
			return ResponseEntity.notFound().build();
		}else {
			
			return ResponseEntity.ok(users);
		}
	}
	
	@PostMapping
	public ResponseEntity<Cars>save(@RequestBody Cars user){
		Cars users = us.save(user);
		
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/byUser/{userId}")
	public ResponseEntity<List<Cars>>getUserId(@PathVariable("userId") int userId){
		List<Cars> cars = us.byUserId(userId);
		
			return ResponseEntity.ok(cars);
	}

}

