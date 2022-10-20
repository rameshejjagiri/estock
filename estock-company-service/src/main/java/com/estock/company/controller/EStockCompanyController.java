package com.estock.company.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.company.model.EStockCompany;
import com.estock.company.model.Stock;
import com.estock.company.service.EStockCompanyService;
import com.estock.company.utills.StockClient;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class EStockCompanyController {
	@Autowired
	private EStockCompanyService eStockCompanyService;
	@Autowired
	private StockClient stockClient;

	@PostMapping(value = "/register")
	public ResponseEntity<EStockCompany> registerCompany(@Valid @RequestBody EStockCompany company) {
		EStockCompany registerCompany = eStockCompanyService.registerCompany(company);
		return new ResponseEntity<EStockCompany>(registerCompany, HttpStatus.OK);
	}

	/*
	 * @GetMapping(value = "/info/{companyCode}") public
	 * ResponseEntity<EStockCompany> companyInfo(@PathVariable Integer companyCode)
	 * {
	 * 
	 * return new
	 * ResponseEntity<EStockCompany>(eStockCompanyService.getCompanyByCode(
	 * companyCode), HttpStatus.OK); }
	 */

	@GetMapping(value = "/info/{companyCode}")
	public ResponseEntity<List<Stock>> companyInfo(@PathVariable String companyCode) {
		List<Stock> stocksByCompanyId = stockClient.getStocksByCompanyId(companyCode);
		System.err.println(stocksByCompanyId);
		return new ResponseEntity<List<Stock>>(stocksByCompanyId, HttpStatus.OK);
	}

}
