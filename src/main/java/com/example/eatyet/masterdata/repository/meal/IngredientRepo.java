package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.meal.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends BaseJpaRepository<Ingredient, Long> {
}
