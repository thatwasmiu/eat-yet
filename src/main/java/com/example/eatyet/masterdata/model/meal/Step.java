package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "step")
@Getter
@Setter
public class Step extends AutoIdEntity {
    private String name;

    @ManyToMany
    private List<Ingredient> ingredientList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "step_substitute_ingredient",
            joinColumns = @JoinColumn(name = "step_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "substitute_ingredient_id", referencedColumnName = "id"))
    private List<SubstituteIngredient> substituteList;

    @Transient
    private List<Ingredient> substitutes;
    private Double timeEst;
    private String descr;
}
