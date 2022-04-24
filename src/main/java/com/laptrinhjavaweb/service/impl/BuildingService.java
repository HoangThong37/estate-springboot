package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.exception.FieldNullException;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.MapUtil;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentAreaService rentAreaService;

    @Autowired
    private RentAreaConverter rentAreaConverter;


    @Override
    public List<BuildingSearchReponse> findAll(Map<String, Object> params, List<String> types) {
        List<BuildingSearchReponse> result = new ArrayList<>();
        BuildingSearchBuilder buildingSearchBuilder = convertParamToBuilder(params, types);
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder);
        for (BuildingEntity item : buildingEntities) {
            result.add(buildingConverter.convertToBuildingSearchReponse(item));
        }
        return result;
/*        // java 8
        List<BuildingSearchReponse> buildingSearchReponses = buildingEntities.stream()
                                                                             .map(item -> buildingConverter.convertToBuildingSearchReponse(item))
                                                                             .collect(Collectors.toList());
        return buildingSearchReponses;*/
    }

    private BuildingSearchBuilder convertParamToBuilder(Map<String, Object> params, List<String> types) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private Map<String, Object> toLowerKey(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Object> item : params.entrySet()) {
            result.put(item.getKey().toLowerCase(), item.getValue());
        }
        return result;
    }

    @Override
    public List<BuildingSearchReponse> findFieldName(String name) {
        List<BuildingSearchReponse> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepository.findByNameContaining(name);
        for (BuildingEntity item : buildingEntities) {
            result.add(buildingConverter.convertToBuildingSearchReponse(item));
        }
        return result;
    }

    @Override
    public void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest, Long buildingId) {
        List<UserEntity> result = new ArrayList<>();
        for (Integer item : assignmentBuildingRequest.getStaffIds()) {
            result.add(userRepository.findOnedById(item.longValue()));
        }
        BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
        buildingRepository.assignmentBuilding(result, buildingEntity);
    }

    @Override
    public List<BuildingDTO> findBuildingByDTO(Map<String, Object> request, List<String> types) {
       /* Map<String, Object> validate = validateParams(request);
        List<BuildingDTO> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepository.getBuildings(validateParams, buildingTypes);
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = buildingConverter.convertToDto(item);
            result.add(buildingDTO);
        }
        return result;*/
        return null;
    }

    private Map<String, Object> validateParams(Map<String, Object> request) {
        /* Map<String, Object> validatePa*/
        return null;

    }


    @Override
    public BuildingDTO insert(BuildingDTO buildingDTO) {
        if (!ValidateUtils.isValid(buildingDTO.getName()) || !ValidateUtils.isValid(buildingDTO.getDistrict())) {
            throw new FieldNullException(SystemConstant.FIELD_IS_NULL_OR_EMPTY);
        } else {
            BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);

            String types = String.join(",", buildingDTO.getBuildingType());
        }
        return buildingDTO;
    }

    @Override
    public BuildingDTO update(Long id, BuildingDTO buildingDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id);
        if (buildingEntity != null) {
            buildingRepository.deleteBuilding(buildingEntity);
        }
    }

    // JAVA 7
 /*       List<BuildingSearchReponse> result = new ArrayList<>();
        List<BuildingEntity> buildingEntities = buildingRepositoryCustom.findAll(params, types);
        for (BuildingEntity item : buildingEntities) {
            BuildingSearchReponse model = buildingConverter.convertToBuildingSearchReponse(item);
            result.add(model);
        }
        List<BuildingSearchReponse> buildingSearchReponses = buildingEntities.stream()
                                                                             .map(item -> buildingConverter.convertToBuildingSearchReponse(item))
                                                                             .collect(Collectors.toList());
        return buildingSearchReponses;*/


    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.findById(id);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    public BuildingDTO save(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        try {
            BuildingEntity buildingGetIdAfterSave = buildingRepository.save(buildingEntity);
            if (buildingDTO.getRentArea() != null) {
                List<RentAreaDTO> rentAreaDTOS = rentAreaConverter.convertRentAreaToDto(buildingGetIdAfterSave.getId(), buildingDTO);
                rentAreaService.saveAllByBuilding(rentAreaDTOS, buildingDTO);
            }
            return buildingConverter.convertToDto(buildingGetIdAfterSave);
        } catch (Exception e) {
            System.out.println("Lỗi Building Service");
            e.printStackTrace();
            return null;
        }
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

  /*  @Override
    public String getDistrictByEnums(String value) {
        String district = "";
        for (DistrictsEnum item : DistrictsEnum.values()) {
            if (item.toString().equals(value)) {
                district += item.getDistrictValue();
            }
        }
        return district;
    }*/

}
