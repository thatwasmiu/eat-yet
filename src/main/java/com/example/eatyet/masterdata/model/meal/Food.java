package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.entity.FoodMarket;
import com.example.eatyet.masterdata.model.Rate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "food")
@Getter
@Setter
public class Food extends AutoIdEntity {
    private String name;

    private String bannerUrl;

    private Double estimateTime;

    private Double totalMaxPrice;

    private Double totalMinPrice;

    private String descr;

    @JsonManagedReference
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "food")
    private List<Step> steps = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "food_ingredient",
            joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private Set<Ingredient> ingredients = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    //    @OneToOne
//    private Price price;

//    @Transient
//    private List<FoodMarket> places = new ArrayList<>();
}
