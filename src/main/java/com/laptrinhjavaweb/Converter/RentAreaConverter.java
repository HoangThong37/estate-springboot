package com.laptrinhjavaweb.converter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;

import com.laptrinhjavaweb.service.impl.RentAreaService;
import com.laptrinhjavaweb.utils.ParseIntUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentAreaConverter {

   @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private RentAreaService rentAreaService;

    public RentAreaDTO convertToDto(RentAreaEntity entity) {
        RentAreaDTO result = modelMapper.map(entity, RentAreaDTO.class);
        return result;
    }

    public RentAreaEntity convertToRentAreaEntity(RentAreaDTO rentAreaDTO) {
        RentAreaEntity result = modelMapper.map(rentAreaDTO, RentAreaEntity.class);
        result.setBuildingEntity(buildingRepository.findById(rentAreaDTO.getBuildingid()));
        return result;
    }

    public List<RentAreaDTO> convertRentAreaToDto(Long buildingIdAfterSave, BuildingDTO buildingDTO) {
        List<RentAreaDTO> rentAreaDTOS = new ArrayList<>();
        BuildingDTO buildingDTOGetRentArea = buildingConverter.convertToDto(buildingRepository.findById(buildingIdAfterSave));
        if (buildingDTOGetRentArea.getRentArea().equals(buildingDTO.getRentArea())) {
            return new ArrayList<>();
        }
        String[] rentArea = buildingDTO.getRentArea() != null ? buildingDTO.getRentArea().trim().split(",") : null;
        if (rentArea != null) {
            for (String item : rentArea) {
                RentAreaDTO rentAreaDTO = new RentAreaDTO();
                rentAreaDTO.setBuildingid(buildingIdAfterSave);
                rentAreaDTO.setValue(ParseIntUtil.getValue(item));
                rentAreaDTOS.add(rentAreaDTO);
            }
            return rentAreaDTOS;
        } else {
            return new ArrayList<>();
        }
    }
}
