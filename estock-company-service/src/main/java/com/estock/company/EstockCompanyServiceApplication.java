package com.estock.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EstockCompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstockCompanyServiceApplication.class, args);
	}

}
