package com.estock.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stock.model.Stock;
import com.estock.stock.repository.StockRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v/1.0/market/stock")
public class StockController {
	@Autowired
	private StockRepository stockRepo;

	@GetMapping(value = "/add/{companyCode}")
	public ResponseEntity<List<Stock>> getStock(@PathVariable String companyCode) {
		List<Stock> findByCompanyCode = stockRepo.findByCompanyCodeEquals(companyCode);
		System.out.println(findByCompanyCode);
		return new ResponseEntity<List<Stock>>(findByCompanyCode, HttpStatus.OK);
	}

	@PostMapping(value = "/add/{companyCode}")
	public String addStock(@PathVariable String companyCode, @RequestBody Stock stock) {
		stock.setCompanyCode(companyCode);
		stock.setStockPrice(stock.getStockPrice());
		stockRepo.save(stock);
		return "add requestr is working Company code is " + companyCode;
	}

	@GetMapping(value = "/delete/{companyCode}")
	public String deleteStock(@PathVariable Integer companyCode) {

		return "add requestr is working Company code is " + companyCode;
	}
}
