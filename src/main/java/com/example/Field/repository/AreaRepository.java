package com.example.Field.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Field.Area;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    boolean existsByName(String name);
    boolean existBySoilType(String soilType);
    boolean existsByIdAndUserId(Integer areaId, Integer userId);
    List<Area> findAllByUserId(Integer userId);
}
