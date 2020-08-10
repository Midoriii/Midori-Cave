package com.apprehension.midoricave.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
	public void createBottleTest() {
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
}
