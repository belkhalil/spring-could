package com.aba.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aba.limitsservice.bean.Limits;
import com.aba.limitsservice.configuration.Configuration;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class limitController {

    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
