package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import com.example.eatyet.masterdata.model.Rate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "ingredient")
@Getter
@Setter
public class Ingredient extends AutoIdEntity {
    private String name;

    private String descr;
    private Double price;

    private String BannerUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private Rate rate;

//    @OneToOne
//    private Price price;
}
