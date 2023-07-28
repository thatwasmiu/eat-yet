package com.example.eatyet.masterdata.repository;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.MarketPlace;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketPlaceRepo extends BaseJpaRepository<MarketPlace, Long> {
}
