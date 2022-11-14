package com.estock.company.utills;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estock.company.model.Stock;

@FeignClient(name = "ESTOCK-STOCK-SERVICE", url = "http://estock-stock-service.eba-cgr2kbrf.ap-northeast-1.elasticbeanstalk.com/api/v/1.0/market/stock")
public interface StockClient {

	@PostMapping("/add/{companyCode}")
	Boolean addStocksByCompanyCode(@PathVariable("companyCode") String companyCode, @RequestBody Stock stock);

	@GetMapping("/delete/{companyCode}")
	Boolean deleteAllStocByCompanyCode(@PathVariable String companyCode);

	@GetMapping(value = "/getall/{companyCode}")
	List<Stock> getStocksByCompanyId(@PathVariable("companyCode")String companyCode);

}
