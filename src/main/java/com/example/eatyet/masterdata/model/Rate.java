package com.example.eatyet.masterdata.model;

import com.example.eatyet.core.AutoIdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rate")
@Getter
@Setter
public class Rate extends AutoIdEntity {

    private String name;
    private Integer evaluationPoint;
}
