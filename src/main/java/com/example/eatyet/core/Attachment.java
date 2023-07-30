package com.example.eatyet.core;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "attachment")
@Setter
@Getter
public class Attachment extends AutoIdEntity {
    private String name;
    private String url;
    private Long parentId;
    private String model;
    private Integer type;
    private String description;
}
