package com.aba.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aba.currencyexchangeservice.repository.CurrencyExchengeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private Environment environment;
    private CurrencyExchengeRepository repo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange convert(@PathVariable("from") String from, @PathVariable("to") String to) {
        CurrencyExchange currencyExchange = repo.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("data not found");
        }
        // currencyExchange.setEnvironment(environment.getProperty("server.port"));
        return currencyExchange;
    }

}
