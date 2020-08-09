package com.apprehension.midoricave.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apprehension.midoricave.Model.Bottle;


/**
 * A Repo for my Bottle class, using JPA repo to have everything at
 * my disposal
 * 
 * @author Midoriii
 *
 */

public interface BottleRepo extends JpaRepository<Bottle, Long> {
	public List<Bottle> findByType(String type);
	public List<Bottle> findByBrand(String brand);
	public List<Bottle> findByCountry(String country);
	public List<Bottle> findByTypeAndBrand(String type, String brand);
	// Probably the best way to search for a Bottle by name - return all that contain the substring
	public List<Bottle> findByNameIgnoreCaseContaining(String name);
}
