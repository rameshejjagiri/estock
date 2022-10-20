
package com.estock.stock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estock.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByCompanyCodeEquals(String companyCode);

}
