package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingDeleteRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import javassist.NotFoundException;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types);
    List<BuildingSearchReponse> findAll(BuildingSearchRequest buildingSearchRequest);
    List<BuildingSearchReponse> findFieldName(String name);
    void assignmentBuildingWithCascade(List<Long> staffId, Long buildingId);

    BuildingDTO insert(BuildingDTO buildingDTO);
    BuildingDTO update(Long id, BuildingDTO buildingDTO);
    /*void delete(BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException;*/
    void deleteWithCascade(BuildingDeleteRequest buildingDeleteRequest);
    void delete(BuildingDeleteRequest buildingDeleteRequest) throws NotFoundException;

    BuildingDTO findById(long id);
    BuildingDTO save(BuildingDTO buildingDTO);

    BuildingDTO saveWithCascade(BuildingDTO buildingDTO);

    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
}
