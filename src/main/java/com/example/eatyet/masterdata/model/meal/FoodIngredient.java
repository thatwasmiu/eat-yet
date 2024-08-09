package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.model.Rate;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "food_ingredient")
@Getter
@Setter
public class FoodIngredient extends AutoIdEntity {
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    private Food food;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private Ingredient ingredient;

    private Double amount;


}
