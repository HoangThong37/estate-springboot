package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingRepository extends BuildingRepsitoryCustom, JpaRepository<BuildingEntity, Long> {
    List<BuildingEntity> findByNameContaining(String name); // truy vấn like
    BuildingEntity findById(Long id);
    Long countByIdIn(List<Long> ids); // ĐẾM
    void deleteByIdIn(List<Long> ids);
    void deleteById(List<Long> id);
}
