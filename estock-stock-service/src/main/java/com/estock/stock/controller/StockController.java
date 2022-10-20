package com.estock.stock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v/1.0/market/stock")
public class StockController {

	/*
	 * public ResponseEntity<CompanyStock> addStock(){
	 * 
	 * return }
	 */
	@GetMapping(value = "/add/{companyCode}")
	public String addStock(@PathVariable Integer companyCode) {

		return "add requestr is working Company code is " + companyCode;
	}
}
