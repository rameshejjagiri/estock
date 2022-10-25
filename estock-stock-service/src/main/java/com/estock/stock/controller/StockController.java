package com.estock.stock.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stock.model.Stock;
import com.estock.stock.service.StockService;

@RestController
@RequestMapping("/api/v/1.0/market/stock")
public class StockController {
	@Autowired
	private StockService stockService;

	@GetMapping(value = "/get/{companyCode}/{startDate}/{endDate}")
	public ResponseEntity<List<Stock>> getStock(@PathVariable String companyCode,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

		List<Stock> stockList = stockService.getStockByCompanyCodeAndBetweenDates(companyCode, startDate, endDate);

		System.out.println(stockList);
		return new ResponseEntity<List<Stock>>(stockList, HttpStatus.OK);
	}

	@GetMapping(value = "/getall/{companyCode}")
	public ResponseEntity<List<Stock>> getStock(@PathVariable String companyCode) {

		List<Stock> stockListByCompanyCode = stockService.getStockByCompanyCode(companyCode);

		System.out.println(stockListByCompanyCode);
		return new ResponseEntity<List<Stock>>(stockListByCompanyCode, HttpStatus.OK);
	}

	@PostMapping(value = "/add/{companyCode}")
	public ResponseEntity<Boolean> addStock(@RequestBody Stock stock) {
		System.err.println("Stock price is " + stock.getStockPrice());
		Boolean isStockSaved = stockService.saveStock("Comp006", stock);

		return new ResponseEntity<>(isStockSaved, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{companyCode}")
	public ResponseEntity<Boolean> deleteStock(@PathVariable String companyCode) {
		Boolean isStocksDeleted = stockService.deleteAllStocksByCompanyCode(companyCode);
		return new ResponseEntity<>(isStocksDeleted, HttpStatus.OK);
	}
}
