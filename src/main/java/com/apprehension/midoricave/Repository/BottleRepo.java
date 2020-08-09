package com.apprehension.midoricave.Repository;

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

}
