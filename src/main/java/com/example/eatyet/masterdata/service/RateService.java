package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.repository.RateRepo;
import com.example.eatyet.masterdata.model.Rate;
import org.springframework.stereotype.Service;

@Service
public class RateService extends CrudService<Rate, Long> {
    private RateRepo rateRepo;

    public RateService(RateRepo repo) {
        super(repo);
        this.rateRepo = repo;
    }
}
