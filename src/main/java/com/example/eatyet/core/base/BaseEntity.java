package com.example.eatyet.core.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;

@MappedSuperclass
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class BaseEntity implements Serializable {

    private Long createdOn;

    private String createdBy;

    public Long getCreatedOn() {
        return createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
