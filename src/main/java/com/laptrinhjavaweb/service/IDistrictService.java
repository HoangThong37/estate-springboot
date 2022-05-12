package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.DistrictReponse;

import java.util.List;

public interface IDistrictService {
    List<DistrictReponse> getAll();
    List<DistrictReponse> getDistrictByBuilding(BuildingDTO buildingDTO);
}
