package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.PasswordDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.exception.MyException;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types);

    void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingID);
    void delete(Long[] ids);
    BuildingDTO findById(long id);
    void save(BuildingDTO buildingDTO);

    String getDistrictByEnums(String value);
/*    Map<String, String> getDistricts();
    Map<String, String> getBuildingTypes();
 List<BuildingSearchRequest> findBuildingByDTO(Map<String, Object> request, List<String> types);
    BuildingDTO update(Long id, BuildingDTO buildingDTO);
    BuildingDTO insert(BuildingDTO newBuilding);
    List<BuildingDTO> fillAll();*/
}
