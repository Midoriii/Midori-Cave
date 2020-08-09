package com.apprehension.midoricave.DTO;


import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A DTO for my Bottle class
 * 
 * @author Midoriii
 *
 */

@Data 
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BottleDTO {

	private long Id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
}
