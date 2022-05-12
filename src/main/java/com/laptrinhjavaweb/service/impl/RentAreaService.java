package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.service.IRentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RentAreaService implements IRentAreaService {

    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private RentAreaConverter rentAreaConverter;
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public void saveAllByBuilding(List<RentAreaDTO> rentAreaDTOS, BuildingDTO buildingDTO) {
        List<RentAreaEntity> result = new ArrayList<>();
        for (RentAreaDTO item : rentAreaDTOS) {
            RentAreaEntity rentAreaEntity = rentAreaConverter.convertToRentAreaEntity(item);
            result.add(rentAreaEntity);
        }

        if (buildingDTO.getId() != null) {
            BuildingEntity buildingEntity = buildingRepository.findById(buildingDTO.getId());
            rentAreaRepository.saveAllByBuilding(result, buildingEntity);
        } else {
            BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
            rentAreaRepository.saveAllByBuilding(result, buildingEntity);
        }
    }
}





