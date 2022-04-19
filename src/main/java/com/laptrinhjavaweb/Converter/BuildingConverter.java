package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

   @Autowired 
   private BuildingService buildingService;



    public BuildingDTO convertToDto(BuildingEntity entity) {
        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        result.setAddress(entity.getStreet() + entity.getWard() + buildingService.getDistrictByEnums(entity.getDistrict()));
        result.setRentArea(entity.getRentAreas().stream()
                                                .map(item -> item.getValue()).map(item -> item.toString()).collect(Collectors.joining()));
        return result;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
        return result;
    }

    // convert từ Entity qua Reponse
    public BuildingSearchReponse convertToBuildingSearchReponse(BuildingEntity buildingEntity) {
        BuildingSearchReponse building = modelMapper.map(buildingEntity, BuildingSearchReponse.class);
        building.setAddress(buildingEntity.getStreet() + "_" + buildingEntity.getWard() + "_"
                + buildingService.getDistrictByEnums(buildingEntity.getDistrict()));
        return building;
    }

    public BuildingSearchRequest toBuildingSearchRequest(BuildingSearchRequest buildingSearchRequest){
        if(buildingSearchRequest.getTypes() != null){
            List<String> result = new ArrayList<>();
            for(String item : buildingSearchRequest.getTypes()){
                result.add("'"+ item + "'");
            }
            buildingSearchRequest.setTypes(result);
        }

        return buildingSearchRequest;
    }

    public BuildingEntity convertToUpdate(BuildingEntity entity, BuildingDTO dto) {
        entity.setName(dto.getName());
        entity.setStreet(dto.getStreet());
        entity.setWard(dto.getWard());
        entity.setDistrict(dto.getDistrict());
        entity.setStructure(dto.getStructure());
        entity.setNumberOfBasement(dto.getNumberOfBasement());
        entity.setFloorArea(dto.getFloorArea());
        entity.setDirection(dto.getDirection());
        entity.setLevel(dto.getLevel());
        entity.setRentPrice(dto.getRentPrice());
        entity.setRentPriceDescription(dto.getRentPriceDescription());
//        entity.setType(dto.getBuildingType());
        entity.setManagerName(dto.getManagerName());
        entity.setManagerPhone(dto.getManagerPhone());
        return entity;
    }
    
}

