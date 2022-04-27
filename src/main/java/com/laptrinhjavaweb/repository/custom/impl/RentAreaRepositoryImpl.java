package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom  {
    @Override
    public void saveAllByBuilding(List<RentAreaEntity> rentAreaEntitis, BuildingEntity buildingEntity) {

    }

//    @PersistenceContext
//    EntityManager entityManager;
//    @Autowired
//    RentAreaRepository rentAreaRepository;
//
//    @Transactional
//    @Override
//    public void saveAllByBuilding(List<RentAreaEntity> rentAreaEntitis, BuildingEntity buildingEntity) {
//        List<RentAreaEntity> rentAreaEntityListByBuilding = new ArrayList<>();
//        if (buildingEntity.getRentAreaEntities().size()>0){
//            rentAreaEntityListByBuilding = rentAreaRepository.findByBuildingEntity(buildingEntity);
//        }
//
//        if(rentAreaEntitis.size() > 0){
//            rentAreaEntityListByBuilding.forEach(item->{
//                entityManager.remove(item);
//            });
//            rentAreaEntitis.forEach(item->{
//                entityManager.persist(item);
//            });
//        }
//    }

}

