package com.apprehension.midoricave.Service;

import java.util.List;

import com.apprehension.midoricave.DTO.BottleDTO;

/**
 * An Interface for the Bottle Service, self-explanatory really
 * 
 * @author Midoriii
 *
 */

//TODO Add proper types when mapping DTO <-> POJO is added

public interface BottleService {
	/**
	 * 
	 * @param Id - Id of the Bottle we're trying to find
	 * @return - found Bottle or exception
	 */
	BottleDTO getBottleById(Long Id);
	
	/**
	 * 
	 * @return - a List of all Bottles
	 */
	List<BottleDTO> getAllBottles();
	
	/**
	 * 
	 * @param bottle - Bottle DTO ready to be persisted
	 * @return - created Bottle
	 */
	BottleDTO createBottle(BottleDTO bottle);
	
	/**
	 * 
	 * @param bottle - updated Bottle DTO to be persisted
	 * @return - updated Bottle
	 */
	BottleDTO updateBottle(BottleDTO bottle);
	
	/**
	 * 
	 * @param Id - Id of the Bottle to be removed
	 */
	void deleteBottle(Long Id);
	
	/**
	 * 
	 * @param name - full Name or a substring by which we're searching for one or more Bottles
	 * @return - a List of found bottles that contain given substring in their name
	 */
	List<BottleDTO> getBottleByName(String name);
	
	/**
	 * 
	 * @param type - the Type we're searching for (e.g. Gin, Whiskey,..)
	 * @return - a List of found bottles that satisfy the condition
	 */
	List<BottleDTO> getBottlesByType(String type); 
	
	/**
	 * 
	 * @param brand - the Brand of bottles we're searching for (e.g. Beefeater, Santos Dumont,..)
	 * @return - a List of found bottles that satisfy the condition
	 */
	List<BottleDTO> getBottlesByBrand(String brand);
	
	/**
	 * 
	 * @param country_acronym - String in the form of an acronym of a country (3 letters max)
	 * @return - a List of found bottles that satisfy the condition
	 */
	List<BottleDTO> getBottlesByCountry(String country_acronym);
	
	/**
	 * 
	 * @param type - the Type we're searching (e.g Gin, Whiskey,..)
	 * @param brand - name of the Brand (e.g. Beefeater, Johnnie Walker,..)
	 * @return - a List of found bottles that satisfy both
	 */
	List<BottleDTO> getBottlesByTypeAndBrand(String type, String brand);
}
