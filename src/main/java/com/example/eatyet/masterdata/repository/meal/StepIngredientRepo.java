package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.meal.StepIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepIngredientRepo extends JpaRepository<StepIngredient, Long> {
}
