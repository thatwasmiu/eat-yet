package com.example.eatyet.masterdata.model;

import com.example.eatyet.core.AutoIdEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "market_place")
@Getter
@Setter
public class MarketPlace extends AutoIdEntity {

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "market_place_rate",
            joinColumns = @JoinColumn(name = "market_place_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "rate_id", referencedColumnName = "id"))
    private Rate rate;
}
