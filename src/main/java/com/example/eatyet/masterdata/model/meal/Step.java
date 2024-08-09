package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "step")
@Getter
@Setter
public class Step extends AutoIdEntity {
    private String name;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    private Food food;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "step_ingredient",
            joinColumns = @JoinColumn(name = "step_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<Ingredient> stepIngredients = new HashSet<>();

//    @Transient
//    private List<Ingredient> substitutes = new ArrayList<>();
    private Double timeEst;
    private String descr;

    @Transient
    private Double amount;
}
