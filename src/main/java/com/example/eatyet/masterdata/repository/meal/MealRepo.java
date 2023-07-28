package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.meal.Meal;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends BaseJpaRepository<Meal, Long> {
}
