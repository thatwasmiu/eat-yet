package com.example.eatyet.masterdata.model;

import jakarta.persistence.*;
import lombok.Data;

//@Entity
//@Table(name = "price")
@Data
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valueInVND;
    private Double valueInUSD;

}
