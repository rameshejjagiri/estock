package com.estock.company.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estock.company.model.EStockCompany;

@Repository
@Transactional
public interface EStockCompanyRepository extends JpaRepository<EStockCompany, String> {

	EStockCompany findByCompanyCode(String companyCode);

	@Modifying
	@Query("delete from EStockCompany c where c.companyCode = :companyCode")
	int deleteByCompanyCode(@Param("companyCode") String companyCode);

}
