package com.example.eatyet.masterdata.endpoint;

import com.example.eatyet.masterdata.context.EndpointRoute;
import com.example.eatyet.core.RestApiEndpoint;
import com.example.eatyet.masterdata.model.Rate;
import com.example.eatyet.masterdata.repository.RateRepo;
import com.example.eatyet.masterdata.service.RateService;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(EndpointRoute.RATE)
public class RateEndpoint extends RestApiEndpoint<Rate, Long> {
    private final RateService rateService;
    private RateRepo rateRepo;

    public RateEndpoint(RateService service) {
        super(EndpointRoute.RATE, service);
        this.rateService = service;
    }

    @Autowired
    public void setRateRepo(RateRepo rateRepo) {
        this.rateRepo = rateRepo;
    }

    @GetMapping("/test")
    public void test() {
        List<Rate> rate = rateRepo.testSql();
        rateRepo.saveAll(rate);
        rate.forEach(r -> r.setId(r.getId()));
        Rate rate1 = new Rate();
        rate1.setId(rate.get(1).getId());
//        String newString = new String(rate.get(1).getName());
//        rate1.setName(newString);
        rate1.setCreatedBy(rate.get(1).getCreatedBy());
        rate1.setCreatedOn(rate.get(1).getCreatedOn());
        rate.add(rate1);
        rateRepo.saveAll(rate);
    }

    @GetMapping("/test2")
    public void test2() {
        Rate rate = new Rate();
        rate.setId(1l);
        rate.setName("test");
        rateRepo.save(rate);
    }

    @GetMapping("/test3")
    public void test3() {
        List<Rate> rate = rateRepo.testSql();
        rate.forEach(r -> r.setName(r.getName()+""));
        rateRepo.saveAll(rate);
        rate.forEach(r -> r.setName("wjat"));
        rateRepo.saveAll(rate);
    }

    @GetMapping("/ok")
    public void test5() {
        List<Rate> rate = rateRepo.testSql();
        String newString = "1 start ";
        rate.get(0).setName(newString);
        rateRepo.saveAll(rate);
    }

    @GetMapping("/fail")
    public void test4() {
        List<Rate> rate = rateRepo.testSql();
        String newString = "1 start";
        rate.get(0).setName(newString);
        rateRepo.saveAll(rate);
    }

    @GetMapping("/hacky")
    public void hackyShit() {
        List<Rate> rate = rateRepo.testSql();
        rate.forEach(r -> r.setName(r.getName().replace("#name#", ""))); // this is too hacky, they're gonna hate me for this
        rateRepo.saveAll(rate);
    }

    @GetMapping("/actual-understand")
    public void underStand() {
        List<Rate> rate = rateRepo.testSql();
        rate.forEach(r -> r.setCreatedBy("me")); // this is too hacky, they're gonna hate me for this
        rateRepo.saveAll(rate);
    }
}
