package com.laptrinhjavaweb.dto.request;

import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;

public class BuildingDeleteRequest {
    private  List<Long> buildingIDs;

    public List<Long> getBuildingIDs() {
        return buildingIDs;
    }

    public void setBuildingIDs(List<Long> buildingIDs) {
        this.buildingIDs = buildingIDs;
    }
}
