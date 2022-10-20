package com.estock.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.company.model.EStockCompany;
import com.estock.company.repository.EStockCompanyRepository;

@Service
public class EStockCompanyService {
	@Autowired
	private EStockCompanyRepository eStockCompanyRepository;

	public EStockCompany registerCompany(EStockCompany company) {
		return eStockCompanyRepository.save(company);
	}

	/*
	 * public EStockCompany getCompanyByCode(Integer companyCode) {
	 * Optional<EStockCompany> findById =
	 * eStockCompanyRepository.findById(companyCode); return findById.get(); }
	 */

}
