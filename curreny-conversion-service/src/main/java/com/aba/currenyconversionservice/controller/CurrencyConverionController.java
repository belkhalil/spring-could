package com.aba.currenyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aba.currenyconversionservice.CurrenctExchangeProxy;

@RestController
public class CurrencyConverionController {

    @Autowired
    private CurrenctExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrency(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") BigDecimal quantity) {
        HashMap<String, Object> pathVariables = new HashMap<>();
        pathVariables.put("from", from);
        pathVariables.put("to", to);
        CurrencyConversion currencyConversionResponce = proxy.retreiveExchnageValue(from, to);

        return new CurrencyConversion(
                currencyConversionResponce.getId(),
                from, to, quantity,
                currencyConversionResponce.getConversionMultiple(),
                quantity.multiply(currencyConversionResponce.getConversionMultiple()),
                currencyConversionResponce.getEnvironment());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyFeign(
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("quantity") BigDecimal quantity) {
        HashMap<String, Object> pathVariables = new HashMap<>();
        pathVariables.put("from", from);
        pathVariables.put("to", to);
        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, pathVariables);
        CurrencyConversion currencyConversionResponce = responseEntity.getBody();

        return new CurrencyConversion(
                currencyConversionResponce.getId(),
                from, to, quantity,
                currencyConversionResponce.getConversionMultiple(),
                quantity.multiply(currencyConversionResponce.getConversionMultiple()),
                currencyConversionResponce.getEnvironment());
    }
}
