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

import com.estock.company.DTO.EStockCompanyDTO;
import com.estock.company.model.EStockCompany;
import com.estock.company.model.Stock;
import com.estock.company.service.EStockCompanyService;
import com.estock.company.utills.StockClient;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class EStockCompanyController {
	@Autowired
	private EStockCompanyService eStockCompanyService;

	@PostMapping(value = "/register")
	public ResponseEntity<EStockCompany> registerCompany(@Valid @RequestBody EStockCompanyDTO company) {
		EStockCompany registerCompany = eStockCompanyService.registerCompany(company);
		return new ResponseEntity<EStockCompany>(registerCompany, HttpStatus.OK);
	}

	@GetMapping(value = "/info/{companyCode}")
	public ResponseEntity<EStockCompanyDTO> companyInfo(@PathVariable String companyCode) {

		System.err.println(companyCode);

		EStockCompanyDTO companyByCode = eStockCompanyService.getCompanyByCode(companyCode);
		System.err.println(companyByCode);
		return new ResponseEntity<EStockCompanyDTO>(companyByCode, HttpStatus.OK);
	}

	@GetMapping(value = "/getall")
	public ResponseEntity<List<EStockCompanyDTO>> getAllCompanies() {
		List<EStockCompanyDTO> allCompanies = eStockCompanyService.getAllCompanies();
		System.err.println(allCompanies);
		return new ResponseEntity<List<EStockCompanyDTO>>(allCompanies, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{companyCode}")
	public ResponseEntity<Boolean> deleteCompany(@PathVariable String companyCode) {
		Integer isDeleted = eStockCompanyService.deleteBYCOmpanyCode(companyCode);
		System.err.println(isDeleted);
		return new ResponseEntity<Boolean>(isDeleted==1?true:false, HttpStatus.OK);
	}

}
