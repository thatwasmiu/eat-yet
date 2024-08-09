package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "step_ingredient")
@Data
public class StepIngredient extends AutoIdEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "step_id")
    private Step step;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String descr;
}
