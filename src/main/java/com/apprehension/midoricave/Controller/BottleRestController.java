package com.apprehension.midoricave.Controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apprehension.midoricave.DTO.BottleDTO;
import com.apprehension.midoricave.Service.BottleService;
import com.apprehension.midoricave.Service.Impl.BottleServiceImpl;

/**
 * A simple REST Controller providing only GET methods, since I don't want
 * anyone to tinker with the spirits
 * 
 * @author Midoriii
 *
 */

@RestController
@RequestMapping("/bottles")
public class BottleRestController {
	
	private final BottleService service;
	
	public BottleRestController(BottleServiceImpl srv) {
		this.service = srv;
	}
	
	@GetMapping("/all/brand/{brand}")
	public Collection<BottleDTO> allByBrand(@PathVariable String brand){
		return service.getBottlesByBrand(brand);
	}
	
	@GetMapping("/all/type/{type}")
	public Collection<BottleDTO> allByType(@PathVariable String type){
		return service.getBottlesByType(type);
	}
	
	@GetMapping("/all/name/{name}")
	public Collection<BottleDTO> allByName(@PathVariable String name){
		return service.getBottleByName(name);
	}
	
	@GetMapping("/all/country/{country}")
	public Collection<BottleDTO> allByCountry(@PathVariable String country){
		return service.getBottlesByCountry(country);
	}
	
	@GetMapping("/all")
	public Collection<BottleDTO> all(){
		return service.getAllBottles();
	}
	
	@GetMapping("/{id}")
	public BottleDTO getSingleBottle(@PathVariable Long id) {
		return service.getBottleById(id);
	}
	
	
}
