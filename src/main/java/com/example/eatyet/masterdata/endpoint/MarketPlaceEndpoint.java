package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.service.MarketPlaceService;
import com.example.eatyet.masterdata.model.MarketPlace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointRoute.MARKET_PLACE)
public class MarketPlaceEndpoint extends RestApiEndpoint<MarketPlace, Long> {
    private final MarketPlaceService marketPlaceService;

    public MarketPlaceEndpoint(MarketPlaceService service) {
        super(EndpointRoute.MARKET_PLACE, service);
        this.marketPlaceService = service;
    }
}
