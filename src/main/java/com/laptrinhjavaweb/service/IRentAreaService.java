package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;

import java.util.List;

public interface IRentAreaService {
//   diện tích thuê
   void saveAllByBuilding(List<RentAreaDTO> rentAreaDTOS, BuildingDTO buildingDTO);



}
