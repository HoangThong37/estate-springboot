package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.utils.ParseIntUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserConverter userConverter;



//    @Autowired
//    private BuildingService buildingService;

    // cv từ DTO <<- ENTITY
    public BuildingDTO convertToDto(BuildingEntity entity) {
        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        List<String> rentAreas = new ArrayList<>();
        for (RentAreaEntity item : entity.getRentAreaEntities()) {
            rentAreas.add(String.valueOf(item.getValue()));
        }
        String rentArea = String.join(",", rentAreas); // join tách bằng dấu ,
        result.setRentArea(rentArea);
        if (entity.getType() != null) {
            List<String> arrayList = new ArrayList<>();
            String[] types = entity.getType().trim().split(",");
            for (String item : types) {
                arrayList.add(item);
            }
            result.setType(arrayList);
         }


       /* result.setAddress(entity.getStreet() + entity.getWard() + buildingService.getDistrictByEnums(entity.getDistrict()));
        result.setRentArea(entity.getRentAreas().stream()
                .map(item -> item.getValue()).map(item -> item.toString()).collect(Collectors.joining()));*/
        return result;
    }

    // cv từ DTO -> Entity
    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
        if (dto.getType() != null) {
            String type = String.join(",", dto.getType());
            result.setType(type);
        }
        // update 27/4
        if (dto.getRentArea() != null) {
            List<RentAreaEntity> rentAreaEntities = new ArrayList<>();
            String[] renAreaValue = dto.getRentArea().trim().split(",");
            for (String item : renAreaValue) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setBuildingEntity(result);
                rentAreaEntity.setValue(ParseIntUtil.getValue(item));
                rentAreaEntities.add(rentAreaEntity);
            }
            result.setRentAreaEntities(rentAreaEntities);
        }
        return result;
    }

    // convert từ Entity qua Reponse
    public BuildingSearchReponse convertToBuildingSearchReponse(BuildingEntity buildingEntity) {
        BuildingSearchReponse building = modelMapper.map(buildingEntity, BuildingSearchReponse.class);
        String districtName = "";
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districtName = item.getDistrictValue();
            break;
        }
        building.setAddress(buildingEntity.getStreet() + "_" + buildingEntity.getWard() + "_"
                + districtName);
        return building;
    }


    public BuildingSearchRequest convertToBuildingSearchRequest(BuildingSearchRequest buildingSearchRequest) {
        if (buildingSearchRequest.getTypes() != null) {
            List<String> result = new ArrayList<>();
            for (String item : buildingSearchRequest.getTypes()) {
                result.add("'" + item + "'");
            }
        }
        return buildingSearchRequest;
    }
}

