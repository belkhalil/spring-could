package com.aba.currencyexchangeservice.controller;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange {
    @Id
    @GeneratedValue
    private Long identifier;
    @Column(name = "toto")
    private String from;
    @Column(name = "tata")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

}
