package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.entity.FoodMarket;
import com.example.eatyet.masterdata.model.Rate;
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

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "food_step",
            joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "step_id", referencedColumnName = "id"))
    private List<Step> steps = new ArrayList<>();

//    @OneToOne
//    private Price price;

    @OneToOne
    @JoinTable(name = "food_rate",
            joinColumns = @JoinColumn(name = "food_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id"))
    private Rate rate;

    @Transient
    private List<FoodMarket> places = new ArrayList<>();
}
