package com.estock.company.model;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Stock {
	private Integer stockId;
	private Float stockPrice;
	private LocalDateTime createdOn;
	private String companyCode;
}