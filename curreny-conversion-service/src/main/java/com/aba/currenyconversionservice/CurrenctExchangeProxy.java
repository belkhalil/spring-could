package com.aba.currenyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aba.currenyconversionservice.controller.CurrencyConversion;

@FeignClient(name = "current-exchange", url = "localhost:8000")
public interface CurrenctExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retreiveExchnageValue(
            @PathVariable String from,
            @PathVariable String to);
}
