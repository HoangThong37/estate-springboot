package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepsitoryCustom buildingRepositoryCustom;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Override
    public List<BuildingDTO> fillAll() {
        List<BuildingDTO> result = new ArrayList<>();
        List<BuildingEntity> entities = buildingRepository.findAll();
        for (BuildingEntity item : entities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;
    }

    @Override
    @Transactional
    public void save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public BuildingDTO update(Long id, BuildingDTO buildingDTO) {
        return null;
    }

    @Override
    public BuildingDTO insert(BuildingDTO newBuilding) {
        return null;
    }

    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.getOne(id);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> districts = new HashMap<>();
        for (DistrictsEnum item: DistrictsEnum.values()) {
            districts.put(item.toString(), item.getDistrictValue());
        }
        return districts;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> buildingTypes = new HashMap<>();
        for (BuildingTypesEnum item: BuildingTypesEnum.values()) {
            buildingTypes.put(item.toString(), item.getBuildingTypeValue());
        }
        return buildingTypes;
    }

    @Override
    public String getDistrictByEnums(String value) {
        String district = "";
        for (DistrictsEnum item : DistrictsEnum.values()) {
            if (item.toString().equals(value)) {
                district += item.getDistrictValue();
            }
        }
        return district;
    }

    @Override
    public List<BuildingSearchReponse> buildingSearch(Map<String, String> params, List<String> types) {
        List<BuildingSearchReponse> buildingResponses = new ArrayList<>();
        if (!params.isEmpty() || !types.isEmpty()) {
            List<BuildingEntity> buildingEntities = buildingRepositoryCustom.buildingSearch(params, types);
            for (BuildingEntity entity : buildingEntities) {
                BuildingSearchReponse model = buildingConverter.convertToBuildingSearchReponse(entity);
                buildingResponses.add(model);
            }
        }
        return buildingResponses;
    }

    @Override
    public List<BuildingSearchRequest> findBuildingByDT(Map<String, Object> request, List<String> types) {
        return null;
    }


}
