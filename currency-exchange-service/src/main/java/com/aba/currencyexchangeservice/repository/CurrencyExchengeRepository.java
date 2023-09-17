package com.aba.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aba.currencyexchangeservice.controller.CurrencyExchange;

public interface CurrencyExchengeRepository extends JpaRepository<CurrencyExchange, Long> {

    public CurrencyExchange findByFromAndTo(String from, String to);

}
