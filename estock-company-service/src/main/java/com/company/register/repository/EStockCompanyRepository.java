package com.company.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.register.model.EStockCompany;
@Repository
public interface EStockCompanyRepository extends JpaRepository<EStockCompany, Integer> {

}
