package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.model.Rate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
public class Ingredient extends AutoIdEntity {
    private String name;

//    @OneToOne
//    private Price price;
    private Double price;

    private String BannerUrl;

    @OneToOne
    @JoinTable(name = "ingredient_rate",
            joinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id"))
    private Rate rate;
}
