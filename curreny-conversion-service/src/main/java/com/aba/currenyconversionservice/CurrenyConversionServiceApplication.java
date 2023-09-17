package com.aba.currenyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrenyConversionServiceApplication {
	/*
	 * {
	 * "id": 10001,
	 * "from": "USD",
	 * "to": "INR",
	 * "conversionMultiple": 65.00,
	 * "quantity": 10,
	 * "totalCalculatedAmount": 650.00,
	 * "environment": "8000 instance-id"
	 * }
	 */
	public static void main(String[] args) {
		SpringApplication.run(CurrenyConversionServiceApplication.class, args);
	}

}
