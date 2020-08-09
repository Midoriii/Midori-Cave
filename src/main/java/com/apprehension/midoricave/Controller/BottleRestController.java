package com.apprehension.midoricave.Controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apprehension.midoricave.Model.Bottle;
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
	
	@GetMapping("/all")
	public Collection<Bottle> all(){
		return service.getAllBottles();
	}
	
	
}
