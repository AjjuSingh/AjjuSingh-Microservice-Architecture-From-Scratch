package com.softai.cloud.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;

// The currency exchange service is running on port 8000
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
}
