package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingSearchReponse;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingService buildingService;


    public BuildingDTO convertToDto(BuildingEntity entity) {
        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        return result;
    }

    public BuildingEntity convertToEntity(BuildingDTO dto) {
        BuildingEntity result = modelMapper.map(dto, BuildingEntity.class);
        return result;
    }

    // convert từ Entity qua Reponse
    public BuildingSearchReponse convertToBuildingSearchReponse(BuildingEntity buildingEntity) {
        BuildingSearchReponse building = modelMapper.map(buildingEntity, BuildingSearchReponse.class);
        building.setAddress(buildingEntity.getStreet() + buildingEntity.getWard()
                + buildingService.getDistrictByEnums(buildingEntity.getDistrict()));
        return building;
    }


}

