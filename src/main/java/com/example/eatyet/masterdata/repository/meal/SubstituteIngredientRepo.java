package com.example.eatyet.masterdata.repository.meal;

import com.example.eatyet.masterdata.model.meal.SubstituteIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubstituteIngredientRepo extends JpaRepository<SubstituteIngredient, Long> {
}
