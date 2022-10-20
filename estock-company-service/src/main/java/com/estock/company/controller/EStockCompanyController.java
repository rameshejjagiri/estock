package com.estock.company.controller;

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
import com.estock.company.service.EStockCompanyService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class EStockCompanyController {
	@Autowired
	private EStockCompanyService eStockCompanyService;

	@PostMapping(value = "/register")
	public ResponseEntity<EStockCompany> registerCompany(@RequestBody EStockCompany company) {
		EStockCompany registerCompany = eStockCompanyService.registerCompany(company);
		return new ResponseEntity<EStockCompany>(registerCompany, HttpStatus.OK);
	}

	@GetMapping(value = "/info/{companyCode}")
	public ResponseEntity<EStockCompany> companyInfo(@PathVariable Integer companyCode) {

		return new ResponseEntity<EStockCompany>(eStockCompanyService.getCompanyByCode(companyCode), HttpStatus.OK);
	}

}
