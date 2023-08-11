package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_ingredient")
@Getter
@Setter
public class FoodIngredient extends AutoIdEntity {
    @Column(name = "food_id")
    private Long foodId;
    @Column(name = "ingredient_id")
    private Long ingredientId;
}
