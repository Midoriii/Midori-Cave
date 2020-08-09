package com.apprehension.midoricave.Service.Impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.apprehension.midoricave.Exception.MidoriCaveDataAccessException;
import com.apprehension.midoricave.Model.Bottle;
import com.apprehension.midoricave.Repository.BottleRepo;
import com.apprehension.midoricave.Service.BottleService;

//TODO add mapping DTO <-> POJO

@Service
public class BottleServiceImpl implements BottleService {
	
	private final BottleRepo repo;
	
	public BottleServiceImpl(BottleRepo repository) {
		this.repo = repository;
	}
	
	
	public Bottle getBottleById(Long Id) {
		return repo.findById(Id).orElseThrow(() -> new MidoriCaveDataAccessException("Bottle with Id " + Id + ""
				+ "cannot be found!"));
	}

	public List<Bottle> getAllBottles(){
		return repo.findAll();
	}
	
	public Bottle createBottle(Bottle bottle) {
		try {
			return repo.save(bottle);
		} catch (DataAccessException e) {
			throw new MidoriCaveDataAccessException("Cannot create Bottle", e);
		}
	}
	
	public Bottle updateBottle(Bottle bottle) {
		try {
			return repo.save(bottle);
		} catch (DataAccessException e) {
			throw new MidoriCaveDataAccessException("Cannot update Bottle", e);
		}
	}
	
	public void deleteBottle(Long Id) {
		if(repo.existsById(Id)) {
			repo.deleteById(Id);
		}
		else {
			throw new MidoriCaveDataAccessException("Cannot delete nonexisting Bottle with ID: " + Id);
		}
	}
	
	public List<Bottle> getBottleByName(String name){
		return repo.findByNameIgnoreCaseContaining(name);
	}
	
	public List<Bottle> getBottlesByType(String type){
		return repo.findByType(type);
	}
	
	public List<Bottle> getBottlesByBrand(String brand){
		return repo.findByBrand(brand);
	}
	
	public List<Bottle> getBottlesByCountry(String country_acronym){
		return repo.findByCountry(country_acronym);
	}
	
	public List<Bottle> getBottlesByTypeAndBrand(String type, String brand){
		return repo.findByTypeAndBrand(type, brand);
	}

}
