package com.estock.company.utills;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.estock.company.model.Stock;

@FeignClient(name = "STOCK-SERVICE", url = "http://localhost:8082/api/v/1.0/market/stock")
public interface StockClient {

	@GetMapping("/add/{companyCode}")
	List<Stock> getStocksByCompanyId(@PathVariable String companyCode);

}
