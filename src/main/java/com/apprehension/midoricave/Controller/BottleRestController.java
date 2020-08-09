package com.apprehension.midoricave.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/rest/bottles")
public class BottleRestController {
	
	private final BottleService service;
	
	public BottleRestController(BottleServiceImpl srv) {
		this.service = srv;
	}
}
