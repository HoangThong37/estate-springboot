package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types);
    List<BuildingSearchReponse> findFieldName(String name);
    void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingId);

    List<BuildingDTO> findBuildingByDTO(Map<String, Object> request, List<String> types);

    BuildingDTO insert(BuildingDTO buildingDTO);
    BuildingDTO update(Long id, BuildingDTO buildingDTO);
    void delete(Long id);
    BuildingDTO findById(long id);
    BuildingDTO save(BuildingDTO buildingDTO);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();

}
