package com.example.eatyet.masterdata.model.meal;

import com.example.eatyet.core.AutoIdEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "substitute_ingredient")
@Getter
@Setter
public class SubstituteIngredient extends AutoIdEntity {
    private Long originalId;
    private Long replacementId;
}
