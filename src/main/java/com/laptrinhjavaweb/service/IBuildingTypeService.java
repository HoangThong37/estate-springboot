package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingTypeReponse;

import java.util.List;

public interface IBuildingTypeService {
    List<BuildingTypeReponse> getAll();
    List<BuildingTypeReponse> getAllByBuilding(BuildingDTO buildingDTO);
}
