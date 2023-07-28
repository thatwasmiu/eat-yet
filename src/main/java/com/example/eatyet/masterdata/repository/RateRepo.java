package com.example.eatyet.masterdata.repository;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.Rate;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepo extends BaseJpaRepository<Rate, Long> {
}
