package com.estock.stock.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.stock.model.Stock;
import com.estock.stock.repository.StockRepository;

@Service

public class StockService {
	@Autowired
	private StockRepository stackRepository;

	public List<Stock> getStockByCompanyCode(String companyCode) {
		List<Stock> findByCompanyCodeEquals = stackRepository.findByCompanyCodeEquals(companyCode);
		return findByCompanyCodeEquals;
	}

	public Boolean saveStock(String companyCode, Stock stock) {
		stock.setCompanyCode(companyCode);
		Stock saved = stackRepository.save(stock);
		return saved != null ? true : false;
	}

	public List<Stock> getStockByCompanyCodeAndBetweenDates(String companyCode, LocalDate startDate,
			LocalDate endDate) {
		List<Stock> stocks = stackRepository.findAllByCreatedOnGreaterThanEqualAndCreatedOnLessThanEqualAndCompanyCode(
				startDate, endDate, companyCode);
		return stocks;
	}

	public Boolean deleteAllStocksByCompanyCode(String companyCode) {
		Integer isdeleted = stackRepository.deleteByCompanyCode(companyCode);
		return isdeleted == 0 ? false : true;
	}

}
