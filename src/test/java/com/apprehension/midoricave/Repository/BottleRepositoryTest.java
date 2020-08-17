package com.apprehension.midoricave.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.apprehension.midoricave.Model.Bottle;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class BottleRepositoryTest {

	@Autowired
	private BottleRepo repo;
	
	private Bottle bottle1;
	private Bottle bottle2;
	
	/**
	 * Notes to Self:
	 * This, coupled with @saveInitData and @Transactional is probably the best way
	 * to ensure that data is created and deleted before and after each test.
	 * Creating all the data would be possible, but then it'd be difficult to test the
	 * creation itself. Perhaps when testing a different stuff than CRUD Repo.
	 */
	
	@BeforeEach
	public void init() {
		bottle1 = Bottle.builder()
				.name("Dori's Gin")
				.brand("Midoriii")
				.type("Gin")
				.country("CZE")
				.volume(0.7f)
				.percentage(37.5f)
				.description("Premium Fake Gin!")
				.build();
		
		bottle2 = Bottle.builder()
				.name("Navy Rum")
				.brand("Yarr")
				.type("Rum")
				.country("JAM")
				.volume(1.0f)
				.percentage(32.5f)
				.description("Avast me mateyyy!")
				.build();
	}
	
	public void saveInitData() {
		repo.save(bottle1);
		repo.save(bottle2);
	}
	
	@Test
	public void createBottleAndFindByIdTest() {
		repo.save(bottle1);
		
		assertThat(bottle1.getId()).isNotNull();
		assertThat(repo.findById(bottle1.getId()).orElse(null)).isEqualTo(bottle1);
	}
	
	@Test
	public void getAllBottlesTest() {
		saveInitData();
		
		assertThat(repo.findAll()).containsExactlyInAnyOrder(bottle1, bottle2);
	}
	
	@Test 
	public void updateBottleTest() {
		saveInitData();
		
		bottle1.setCountry("FAO");
		repo.save(bottle1);
		
		assertThat(repo.findById(bottle1.getId()).orElse(null).getCountry()).isEqualTo("FAO");
	}
	
	@Test 
	public void deleteBottle() {
		saveInitData();
		
		repo.delete(bottle2);
		
		assertThat(repo.findAll()).containsExactly(bottle1);
	}
	
	@Test 
	public void findByBrandTest() {
		saveInitData();
		
		assertThat(repo.findByBrandIgnoreCase("Yarr")).containsExactly(bottle2);
	}
	
	@Test 
	public void findByCountryTest() {
		saveInitData();
		
		assertThat(repo.findByCountryIgnoreCase("JAM")).containsExactly(bottle2);
	}
	
	@Test 
	public void findByTypeTest() {
		saveInitData();
		
		assertThat(repo.findByTypeIgnoreCase("gin")).containsExactly(bottle1);
	}
	
	@Test 
	public void findByNameTest() {
		saveInitData();
		
		assertThat(repo.findByNameIgnoreCaseContaining("Navy")).containsExactly(bottle2);
	}
	
	@Test 
	public void findByTypeAndBrandTest() {
		saveInitData();
		
		assertThat(repo.findByTypeIgnoreCaseAndBrandIgnoreCase("gin", "MidOrIii")).containsExactly(bottle1);
	}
	
	@Test 
	public void addingIdenticalBottleNameTest() {
		saveInitData();
		
		Bottle bottle3 = Bottle.builder()
				.name("Navy Rum")
				.brand("Arrgh")
				.type("Rum")
				.country("JAM")
				.volume(1.0f)
				.percentage(35.5f)
				.description("Totally not a knockoff")
				.build();
		
		assertThatThrownBy(() -> repo.save(bottle3)).isInstanceOf(DataIntegrityViolationException.class);
	}
	
	@Test 
	public void addingBottleWithoutTypeTest() {
		Bottle bottle4 = Bottle.builder()
				.name("Strange moonshine")
				.brand("X")
				.country("USA")
				.volume(1.5f)
				.percentage(85.0f)
				.description("What is this swill")
				.build();
		
		assertThatThrownBy(() -> repo.save(bottle4)).isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test 
	public void wronglyUpdatingBottleTest() {
		bottle1.setCountry("TORILE");
		assertThatThrownBy(() -> repo.save(bottle1)).isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test 
	public void wronglyUpdatingBottleWithNullTest() {
		bottle1.setBrand(null);
		assertThatThrownBy(() -> repo.save(bottle1)).isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test 
	public void wronglyUpdatingBottleUrlException() {
		bottle1.setImg_url("lalallala]]45345***3");
		assertThatThrownBy(() -> repo.save(bottle1)).isInstanceOf(ConstraintViolationException.class);
	}
	
	@Test 
	public void deletingNonexistentBottlebyIdTest() {
		assertThatThrownBy(() -> repo.deleteById(2l)).isInstanceOf(EmptyResultDataAccessException.class);
	}
}
