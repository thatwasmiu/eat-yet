package com.example.eatyet.masterdata.service;

import com.example.eatyet.core.CrudService;
import com.example.eatyet.masterdata.repository.MarketPlaceRepo;
import com.example.eatyet.masterdata.model.MarketPlace;
import org.springframework.stereotype.Service;

@Service
public class MarketPlaceService extends CrudService<MarketPlace, Long> {
    private MarketPlaceRepo marketPlaceRepo;


    public MarketPlaceService(MarketPlaceRepo repo) {
        super(repo);
        this.marketPlaceRepo = repo;
    }
}
