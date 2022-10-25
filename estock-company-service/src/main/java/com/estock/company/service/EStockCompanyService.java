package com.estock.company.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.company.DTO.EStockCompanyDTO;
import com.estock.company.model.EStockCompany;
import com.estock.company.model.Stock;
import com.estock.company.repository.EStockCompanyRepository;
import com.estock.company.utills.StockClient;

@Service
public class EStockCompanyService {
	@Autowired
	private EStockCompanyRepository eStockCompanyRepository;
	@Autowired
	private StockClient stockClient;

	public EStockCompany registerCompany(@Valid EStockCompanyDTO company) {

		return eStockCompanyRepository.save(new EStockCompany(company.getCompanyName(), company.getCompanyCEO(),
				company.getCompanyTurnover(), company.getCompanyWebsite(), company.getStockExchange()));
	}

	public EStockCompanyDTO getCompanyByCode(String companyCode) {
		EStockCompany company = eStockCompanyRepository.findByCompanyCode(companyCode);

		// List<Stock> stocksByCompanyId =
		// stockClient.getStocksByCompanyId(companyCode);

		EStockCompanyDTO eStockCompanyDTO = new EStockCompanyDTO(company.getCompanyCode(), company.getCompanyName(),
				company.getCompanyCEO(), company.getCompanyTurnover(), company.getCompanyWebsite(),
				company.getStockExlistedIn(), null, null, new ArrayList<Stock>());
		return eStockCompanyDTO;
	}

	public List<EStockCompanyDTO> getAllCompanies() {
		List<EStockCompanyDTO> eStockCompanyDTO = new ArrayList<>();

		for (EStockCompany company : eStockCompanyRepository.findAll()) {

			eStockCompanyDTO.add(new EStockCompanyDTO(company.getCompanyCode(), company.getCompanyName(),
					company.getCompanyCEO(), company.getCompanyTurnover(), company.getCompanyWebsite(),
					company.getStockExlistedIn(), null, null, new ArrayList<Stock>()));
		}

		return eStockCompanyDTO;
	}

	@Transactional
	public Integer deleteBYCOmpanyCode(String companyCode) {
		// Delete teh companies from the Companies table
		int deleteByCompanyCode = eStockCompanyRepository.deleteByCompanyCode(companyCode);
		// eStockCompanyRepository.deleteById(companyCode);

		// Delete all Stocks with Company Code
		//Boolean deleteAllStocByCompanyCode = stockClient.deleteAllStocByCompanyCode(companyCode);

		return deleteByCompanyCode;
	}

}
