package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom  {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Override
    @Transactional
    public void saveAllByBuilding(List<RentAreaEntity> rentAreaEntities, BuildingEntity buildingEntity) {
        List<RentAreaEntity> rentAreaEntityListByBuilding  = new ArrayList<>();
        if (buildingEntity.getRentAreas().size() > 0) {
            rentAreaEntityListByBuilding = rentAreaRepository.findByBuildingEntity(buildingEntity);
        }
        if (rentAreaEntities.size() > 0) {
            rentAreaEntityListByBuilding.forEach(item -> { entityManager.remove(item);});
            rentAreaEntities.forEach(item -> {entityManager.persist(item);});
        }
    }
}
