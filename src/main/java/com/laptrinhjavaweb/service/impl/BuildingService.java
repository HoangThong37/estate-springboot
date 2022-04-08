package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.exception.FieldNullException;
import com.laptrinhjavaweb.exception.FieldRequireException;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.ValidateUtils;
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

//    @Autowired
//    private UserRepository userRepository;

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
        for (Long item : ids) {
            BuildingEntity buildingEntity = buildingRepository.findOne(item);
            buildingEntity.setId(0L);
            buildingRepository.save(buildingEntity);
        }
    }

    @Override
    @Transactional
    public BuildingDTO update(Long id, BuildingDTO buildingDTO) {
        if (!ValidateUtils.isValid(buildingDTO.getName()) || !ValidateUtils.isValid(buildingDTO.getDistrict())) {
            throw new FieldNullException(SystemConstant.FIELD_IS_NULL_OR_EMPTY);
        } else {
            BuildingEntity oldBuilding = buildingRepository.findOne(id);
            BuildingEntity buildingEntity = buildingConverter.convertToUpdate(oldBuilding, buildingDTO);
            if (buildingDTO.getBuildingType().length() > 0) {
                String types = String.join(",", buildingDTO.getBuildingType());
                buildingEntity.setType(types);
            }
            return buildingConverter.convertToDto(buildingRepository.save(buildingEntity));
        }
    }

    @Override
    @Transactional
    public BuildingDTO insert(BuildingDTO newBuilding) {
        if (newBuilding.getName() == null) {
            throw new FieldRequireException("Name is require");
        } else  {
           BuildingEntity buildingEntity = buildingConverter.convertToEntity(newBuilding);
           buildingRepository.save(buildingEntity);
        }
        return newBuilding;
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
