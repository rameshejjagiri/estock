
package com.estock.stock.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.estock.stock.model.Stock;

@Repository
@Transactional
public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByCompanyCodeEquals(String companyCode);

	List<Stock> findAllByCreatedOnGreaterThanEqualAndCreatedOnLessThanEqual(LocalDate startDate, LocalDate endDate);

	List<Stock> findAllByCreatedOnGreaterThanEqualAndCreatedOnLessThanEqualAndCompanyCode(LocalDate startDate,
			LocalDate endDate, String companyCode);

	@Modifying
	Integer deleteByCompanyCode(String companyCode);

}
