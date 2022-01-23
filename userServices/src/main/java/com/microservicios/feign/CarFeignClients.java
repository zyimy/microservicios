package com.microservicios.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservicios.modelo.Bike;
import com.microservicios.modelo.Cars;

@FeignClient(name="carServices",url="http://localhost:8003/car")
//@RequestMapping("/car")
public interface CarFeignClients {
	
	@PostMapping()
	Cars save(@RequestBody Cars cars);
	
	@GetMapping("/byUser/{userId}")
	List<Cars>getCars(@PathVariable("userId") int userId);

}
