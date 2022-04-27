package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types);
    List<BuildingSearchReponse> findAll(BuildingSearchRequest buildingSearchRequest);
    List<BuildingSearchReponse> findFieldName(String name);
    void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingId);

    BuildingDTO insert(BuildingDTO buildingDTO);
    BuildingDTO update(Long id, BuildingDTO buildingDTO);
    void delete(Long id);
    BuildingDTO findById(long id);
    BuildingDTO save(BuildingDTO buildingDTO);
    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();

    /* List<BuildingDTO> findBuildingByDTO(Map<String, Object> request, List<String> types);*/
}
