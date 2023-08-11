package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.entity.FoodGeneralInfo;
import com.example.eatyet.masterdata.model.meal.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends BaseJpaRepository<Food, Long> {
    List<FoodGeneralInfo> findAllBy();

//    StepList findBy();
}
