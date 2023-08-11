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
    private Set<Ingredient> ingredients = new HashSet<>();

//    @Transient
//    private List<Ingredient> substitutes = new ArrayList<>();
    private Double timeEst;
    private String descr;

    @Override
    public boolean equals(Object o) {
        System.out.println("used");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return name.equals(step.name);
    }

    @Override
    public int hashCode() {
        System.out.println("used");
        return Objects.hash(name);
    }
}
