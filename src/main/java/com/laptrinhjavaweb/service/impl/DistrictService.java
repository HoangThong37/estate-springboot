package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.reponse.DistrictReponse;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.service.IDistrictService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService implements IDistrictService {

    @Override
    public List<DistrictReponse> getAll() {
        List<DistrictReponse> result = new ArrayList<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            DistrictReponse districtReponse = new DistrictReponse();
            districtReponse.setCode(item.name());
            districtReponse.setName(item.getDistrictValue());
            result.add(districtReponse);
        }
        return result;
    }

    @Override
    public List<DistrictReponse> getDistrictByBuilding(BuildingDTO buildingDTO) {
        List<DistrictReponse> result = new ArrayList<>();
        try {
            for (DistrictsEnum item : DistrictsEnum.values()) {
                DistrictReponse districtReponse = new DistrictReponse();
                districtReponse.setCode(item.name());
                districtReponse.setName(item.getDistrictValue());
                if (buildingDTO.getDistrict() != null && buildingDTO.getDistrict().equals(item.name())) {
                    districtReponse.setSelected("selected");
                    result.add(districtReponse);
                }
            }
            return result;
        } catch (Exception e) {
            System.out.println("Lỗi ở DistrictService");
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
