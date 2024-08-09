package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.model.Rate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "food")
    private List<FoodIngredient> foodIngredients = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private Rate rate;

    //    @OneToOne
//    private Price price;

//    @Transient
//    private List<FoodMarket> places = new ArrayList<>();
}
