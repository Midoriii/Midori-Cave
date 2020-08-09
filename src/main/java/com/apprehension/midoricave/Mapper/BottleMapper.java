package com.apprehension.midoricave.Mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.apprehension.midoricave.DTO.BottleDTO;
import com.apprehension.midoricave.Model.Bottle;

/**
 * Mapstruct Mapper for Bottle DAO <-> DTO
 * @author Midoriii
 *
 */

@Mapper(componentModel = "spring")
public interface BottleMapper {
	Bottle dtoToBottle(BottleDTO bottle);
	List<Bottle> dtoToBottle(List<BottleDTO> bottles);
	BottleDTO bottleToDTO(Bottle bottle);
	List<BottleDTO> bottleToDTO(List<Bottle> bottles);
}
