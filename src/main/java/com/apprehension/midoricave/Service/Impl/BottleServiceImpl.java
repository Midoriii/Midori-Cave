package com.apprehension.midoricave.Service.Impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.apprehension.midoricave.DTO.BottleDTO;
import com.apprehension.midoricave.Exception.MidoriCaveDataAccessException;
import com.apprehension.midoricave.Mapper.BottleMapper;
import com.apprehension.midoricave.Repository.BottleRepo;
import com.apprehension.midoricave.Service.BottleService;

//TODO add mapping DTO <-> POJO

@Service
public class BottleServiceImpl implements BottleService {
	
	private final BottleRepo repo;
	private final BottleMapper mapper;
	
	public BottleServiceImpl(BottleRepo repository, BottleMapper mapper) {
		this.repo = repository;
		this.mapper = mapper;
	}
	
	
	public BottleDTO getBottleById(Long Id) {
		return mapper.bottleToDTO(repo.findById(Id).orElseThrow(() -> new MidoriCaveDataAccessException("Bottle with Id " + Id + ""
				+ "cannot be found!")));
	}

	public List<BottleDTO> getAllBottles(){
		return mapper.bottleToDTO(repo.findAll());
	}
	
	public BottleDTO createBottle(BottleDTO bottle) {
		try {
			return mapper.bottleToDTO(repo.save(mapper.dtoToBottle(bottle)));
		} catch (DataAccessException e) {
			throw new MidoriCaveDataAccessException("Cannot create Bottle", e);
		}
	}
	
	public BottleDTO updateBottle(BottleDTO bottle) {
		try {
			return mapper.bottleToDTO(repo.save(mapper.dtoToBottle(bottle)));
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
	
	public List<BottleDTO> getBottleByName(String name){
		return mapper.bottleToDTO(repo.findByNameIgnoreCaseContaining(name));
	}
	
	public List<BottleDTO> getBottlesByType(String type){
		return mapper.bottleToDTO(repo.findByType(type));
	}
	
	public List<BottleDTO> getBottlesByBrand(String brand){
		return mapper.bottleToDTO(repo.findByBrand(brand));
	}
	
	public List<BottleDTO> getBottlesByCountry(String country_acronym){
		return mapper.bottleToDTO(repo.findByCountry(country_acronym));
	}
	
	public List<BottleDTO> getBottlesByTypeAndBrand(String type, String brand){
		return mapper.bottleToDTO(repo.findByTypeAndBrand(type, brand));
	}

}
