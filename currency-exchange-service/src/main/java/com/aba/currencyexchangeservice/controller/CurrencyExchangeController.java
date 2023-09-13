package com.aba.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-excgange/from/{from}/to/{to}")
    public CurrencyExchange convert(@PathVariable("from") String from, @PathVariable("to") String to) {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setId(Long.valueOf(1200));
        currencyExchange.setFrom(from);
        currencyExchange.setTo(to);
        currencyExchange.setConversionMultiple(BigDecimal.valueOf(11));
        return currencyExchange;
    }

}
