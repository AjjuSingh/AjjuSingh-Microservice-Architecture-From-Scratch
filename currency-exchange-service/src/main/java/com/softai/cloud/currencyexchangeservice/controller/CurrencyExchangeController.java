package com.softai.cloud.currencyexchangeservice.controller;

import com.softai.cloud.currencyexchangeservice.model.ExchangeValue;
import com.softai.cloud.currencyexchangeservice.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository valueRepository;

    /// Convert from USD to INR
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue value = valueRepository.findByFromAndTo(from, to);
        value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return value;
    }


}
