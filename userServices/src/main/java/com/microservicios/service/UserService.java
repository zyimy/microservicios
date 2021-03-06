package com.microservicios.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservicios.entity.Users;
import com.microservicios.feign.BikeFeignClients;
import com.microservicios.feign.CarFeignClients;
//import com.microservicios.feign.CarFeignClients;
import com.microservicios.modelo.Bike;
import com.microservicios.modelo.Cars;
import com.microservicios.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CarFeignClients cc;

	@Autowired
	BikeFeignClients bk;

	public List<Users> getAll() {

		return ur.findAll();
	}

	public Users getUserById(int id) {
		return ur.findById(id).orElse(null);
	}

	public Users save(Users users) {
		Users user = ur.save(users);

		return users;
	}

	public List<Cars> getCars(int userId) {
		List<Cars> cars = restTemplate.getForObject("http://localhost:8003/car/byUser/" + userId, List.class);

		return cars;
	}

	public List<Bike> getBike(int userId) {
		List<Bike> bikes = restTemplate.getForObject("http://localhost:8002/bike/byUser/" + userId, List.class);

		return bikes;
	}

	public Cars saveCar(int userId, Cars cars) {
		cars.setUserId(userId);
		Cars car = cc.save(cars);

		return car;
	}

	public Bike saveBike(int userId, Bike bikes) {
		bikes.setUserId(userId);
		Bike bike = bk.save(bikes);

		return bike;
	}

	public Map<String, Object> getUsersAndVehicles(int userId) {
		Map<String, Object> result = new HashMap<>();
		Users user = ur.findById(userId).orElse(null);
		if (user == null) {
			result.put("Mensaje", "No existe el usuario");
			return result;
		}
		result.put("Users", user);
		List<Cars> cars = cc.getCars(userId);

		if (cars.isEmpty())
			result.put("Cars", "El usuario: "+userId+" no tiene coches");

		else
			result.put("Cars", cars);
		List<Bike> bikes = bk.getBikes(userId);

		if (bikes.isEmpty())
			result.put("Bikes", "El usuario: "+userId+" no tiene bikes");
		else
			result.put("Bike", bikes);

		return result;
	}

}
