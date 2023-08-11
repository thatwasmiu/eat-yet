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

    private String bannerUrl;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rate_id")
    private Rate rate;
}
