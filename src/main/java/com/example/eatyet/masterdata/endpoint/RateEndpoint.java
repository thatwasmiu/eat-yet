package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.model.Rate;
import com.example.eatyet.masterdata.service.RateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointRoute.RATE)
public class RateEndpoint extends RestApiEndpoint<Rate, Long> {
    private RateService rateService;

    public RateEndpoint(RateService service) {
        super(EndpointRoute.RATE, service);
        this.rateService = service;
    }
}
