package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.exception.MyException;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> fillAll();
    void save(BuildingDTO buildingDTO);
    List<BuildingSearchReponse> buildingSearch(Map<String, String> params, List<String> types);
    List<BuildingSearchRequest> findBuildingByDT(Map<String, Object> request, List<String> types);
    void delete(Long[] ids);
    BuildingDTO update(Long id, BuildingDTO buildingDTO);
    BuildingDTO insert(BuildingDTO newBuilding);
    BuildingDTO findById(long id);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
    String getDistrictByEnums(String value);
}