package com.apprehension.midoricave.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.sun.istack.NotNull;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data class of a Spirit, the basis of this project, so I can keep
 * ledgers on spirits I'd love to try
 * 
 * @author Midoriii
 * 
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bottles")
public class Bottle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@NotNull
	@Column(nullable = false, unique = true)
	private String name;
	
	@NotNull
	@Column(nullable = false)
	private String type;
	
	@NotNull
	@Column(nullable = false)
	private String volume;
	
	@NotNull
	@Column(nullable = false)
	private float percentage;
	
	@NotNull
	@Column(nullable = false)
	private String brand;
	
	@Column(name = "country_acronym" , length = 3)
	@Size(max = 3)
	private String country;
	
	// A Link to a shop where it can be bought
	@Column
	@URL
	private String link;
	
	@Column
	private String description;
	
	// A link to the url of an image of the bottle
	@Column
	@URL
	private String img_url;
	
}
