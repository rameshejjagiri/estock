package com.estock.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estock.company.model.EStockCompany;

@Repository
public interface EStockCompanyRepository extends JpaRepository<EStockCompany, String> {


	boolean findByCompanyCodeEquals(String email);

}
