package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepsitoryCustom buildingRepositoryCustom;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserRepository userRepository;

/*   @Override
    public List<BuildingDTO> fillAll() {
        List<BuildingDTO> result = new ArrayList<>();
        List<BuildingEntity> entities = buildingRepository.findAll();
        for (BuildingEntity item : entities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;
    }*/
    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        buildingRepository.save(buildingEntity);
        return buildingDTO;
    }

    @Override
    public List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types) {
        BuildingSearchBuilder buildingSearchBuilder = convertParamToBuilder(params, types);
        List<BuildingEntity> buildingEntities = buildingRepositoryCustom.findAll(buildingSearchBuilder);
        List<BuildingSearchReponse> buildingSearchReponses = buildingEntities.stream()
                                                                             .map(item -> buildingConverter.convertToBuildingSearchReponse(item))
                                                                             .collect(Collectors.toList());
        return buildingSearchReponses;
    }

    @Override
    public void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingID) {
        List<UserEntity> userEntities = new ArrayList<>();
        for (Integer item : assignmentBuildingRequest.getStaffIds()) {
            userEntities.add(userRepository.findOneById(item.longValue()));
        }
     /*   BuildingEntity buildingEntity = buildingRepository.findById(buildingID);*/

    }

    // JAVA 7
/*        List<BuildingSearchReponse> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepositoryCustom.findAll(params, types);
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchReponse model = buildingConverter.convertToBuildingSearchReponse(item);
            result.add(model);
        }
        List<BuildingSearchReponse> buildingSearchReponses = buildingEntities.stream()
                                                                             .map(item -> buildingConverter.convertToBuildingSearchReponse(item))
                                                                             .collect(Collectors.toList());
        return buildingSearchReponses;*/
   // sử dụng builder pattern
    private BuildingSearchBuilder convertParamToBuilder(Map<String, Object> params, List<String> types) {
        Map<String, Object> paramsLowerKey = toLowerKey(params);
        BuildingSearchBuilder result = new BuildingSearchBuilder.Builder()
                .name(MapUtil.getObject(paramsLowerKey, "name", String.class))
                .floorArea(MapUtil.getObject(paramsLowerKey, "floorarea", Integer.class))
                .district(MapUtil.getObject(paramsLowerKey, "districtcode", String.class))
                .ward(MapUtil.getObject(paramsLowerKey, "ward", String.class))
                .street(MapUtil.getObject(paramsLowerKey, "street", String.class))
                .numberOfBasement(MapUtil.getObject(paramsLowerKey, "numberofbasement", Integer.class))
                .direction(MapUtil.getObject(paramsLowerKey, "direction", String.class))
                .level(MapUtil.getObject(paramsLowerKey, "level", String.class))
                .rentAreaFrom(MapUtil.getObject(paramsLowerKey, "rentareafrom", Integer.class))
                .rentAreaTo(MapUtil.getObject(paramsLowerKey, "rentareato", Integer.class))
                .rentPriceFrom(MapUtil.getObject(paramsLowerKey, "rentpricefrom", Integer.class))
                .rentPriceTo(MapUtil.getObject(paramsLowerKey, "rentpriceto", Integer.class))
                .managerName(MapUtil.getObject(paramsLowerKey, "managername", String.class))
                .managerPhone(MapUtil.getObject(paramsLowerKey, "managerphone", String.class))
                .staffID(MapUtil.getObject(paramsLowerKey, "staffid", Integer.class))
                .types(types)
                .build();

        return result;
    }

    private Map<String, Object> toLowerKey(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> item : params.entrySet()) {
            result.put(item.getKey().toLowerCase(), item.getValue());
        }
        return result;
    }

    @Override
    public void delete(Long ids) {
            BuildingEntity buildingEntity = buildingRepository.findById(ids);
            if (buildingEntity != null) {
                buildingRepository.deleteBuilding(buildingEntity);
        }
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
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.getOne(id);
        return buildingConverter.convertToDto(buildingEntity);
    }
//
//    @Override
//    @Transactional
//    public BuildingDTO update(Long id, BuildingDTO buildingDTO) {
//        if (!ValidateUtils.isValid(buildingDTO.getName()) || !ValidateUtils.isValid(buildingDTO.getDistrict())) {
//            throw new FieldNullException(SystemConstant.FIELD_IS_NULL_OR_EMPTY);
//        } else {
//            BuildingEntity oldBuilding = buildingRepository.findOne(id);
//            BuildingEntity buildingEntity = buildingConverter.convertToUpdate(oldBuilding, buildingDTO);
//            if (buildingDTO.getBuildingType().length > 0) {
//                String types = String.join(",", buildingDTO.getBuildingType());
//                buildingEntity.setType(types);
//            }
//            return buildingConverter.convertToDto(buildingRepository.save(buildingEntity));
//        }
//    }
//
//    @Override
//    @Transactional
//    public BuildingDTO insert(BuildingDTO newBuilding) {
//        if (newBuilding.getName() == null) {
//            throw new FieldRequireException("Name is require");
//        } else  {
//           BuildingEntity buildingEntity = buildingConverter.convertToEntity(newBuilding);
//           buildingRepository.save(buildingEntity);
//        }
//        return newBuilding;
//    }
//

//
//    @Override
//    public Map<String, String> getDistricts() {
//        Map<String, String> districts = new HashMap<>();
//        for (DistrictsEnum item: DistrictsEnum.values()) {
//            districts.put(item.toString(), item.getDistrictValue());
//        }
//        return districts;
//    }
//
//    @Override
//    public Map<String, String> getBuildingTypes() {
//        Map<String, String> buildingTypes = new HashMap<>();
//        for (BuildingTypesEnum item: BuildingTypesEnum.values()) {
//            buildingTypes.put(item.toString(), item.getBuildingTypeValue());
//        }
//        return buildingTypes;
//    }
//
//    @Override
//    public String getDistrictByEnums(String value) {
//        String district = "";
//        for (DistrictsEnum item : DistrictsEnum.values()) {
//            if (item.toString().equals(value)) {
//                district += item.getDistrictValue();
//            }
//        }
//        return district;
//    }
//
//    @Override
//    public List<BuildingSearchReponse> buildingSearch(Map<String, String> params, List<String> types) {
//        List<BuildingSearchReponse> buildingResponses = new ArrayList<>();
//        if (!params.isEmpty() || !types.isEmpty()) {
//            List<BuildingEntity> buildingEntities = buildingRepositoryCustom.buildingSearch(params, types);
//            for (BuildingEntity entity : buildingEntities) {
//                BuildingSearchReponse model = buildingConverter.convertToBuildingSearchReponse(entity);
//                buildingResponses.add(model);
//            }
//        }
//        return buildingResponses;
//    }
//
//  @Override
//    public List<BuildingSearchRequest> findBuildingByDT(Map<String, Object> request, List<String> types) {
//        return null;
//    }



}
