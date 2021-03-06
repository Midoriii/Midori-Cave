package com.apprehension.midoricave.DTO;


import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A DTO for my Bottle class
 * 
 * Doesn't extend EntityModel since I have no interest in
 * creating HATEOAS, simple REST is enough
 * 
 * @author Midoriii
 *
 */

@Data 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottleDTO {

	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
	
	@NotNull
	private String brand;
	
	@NotNull
	@Positive
	private float percentage; 
	
	@NotNull
	@Positive
	private float volume; 
	
	@Size(max = 3)
	private String country;  
	
	@URL
	private String link;
	
	private String description;
	
	@URL
	private String img_url;
}
