package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.BuildingTypeReponse;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.service.IBuildingTypeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class BuildingTypesService implements IBuildingTypeService {
    @Override
    public List<BuildingTypeReponse> getAll() {
        List<BuildingTypeReponse> result = new ArrayList<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            BuildingTypeReponse buildingTypeReponse = new BuildingTypeReponse();
            buildingTypeReponse.setCode(item.name());
            buildingTypeReponse.setName(item.getBuildingTypeValue());
            result.add(buildingTypeReponse);
        }
        return result;
    }

    @Override
    public List<BuildingTypeReponse> getAllByBuilding(BuildingDTO buildingDTO) {
        List<BuildingTypeReponse> result = new ArrayList<>();
        for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
            BuildingTypeReponse buildingTypeReponse = new BuildingTypeReponse();
            buildingTypeReponse.setCode(item.name());
            buildingTypeReponse.setName(item.getBuildingTypeValue());
            if (buildingDTO.getType() != null) {
                for (String check : buildingDTO.getType()) {
                    if (check.equals(item.name())) {
                        buildingTypeReponse.setChecked("checked");
                    }
                }
            }
            result.add(buildingTypeReponse);
        }
        return result;
    }
}
