package com.estock.company.model;

import java.time.LocalDate;

import lombok.Data;
@Data
public class Stock {
	private Integer stockId;
	private Float stockPrice;
	private LocalDate createdOn;
	private String companyCode;
}