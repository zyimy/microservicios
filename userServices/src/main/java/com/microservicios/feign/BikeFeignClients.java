package com.microservicios.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.microservicios.modelo.Bike;


@FeignClient(name="bikeServices",url="http://localhost:8002/bike")
//@RequestMapping("/car")
public interface BikeFeignClients {
	@PostMapping()
	Bike save(@RequestBody Bike bikes);
	
	@GetMapping("/byUser/{userId}")
	List<Bike>getBikes(@PathVariable("userId") int userId);

}
