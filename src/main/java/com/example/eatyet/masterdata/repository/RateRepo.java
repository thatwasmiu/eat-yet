package com.example.eatyet.masterdata.repository;

import com.example.eatyet.core.base.BaseJpaRepository;
import com.example.eatyet.masterdata.model.Rate;
import com.example.eatyet.sql.SQLTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepo extends BaseJpaRepository<Rate, Long> {
    @Query(nativeQuery = true, value = SQLTest.test)
    List<Rate> testSql();
}
