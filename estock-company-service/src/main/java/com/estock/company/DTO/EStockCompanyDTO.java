package com.estock.company.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.estock.company.model.Stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EStockCompanyDTO {
	private String companyCode;
	@NotEmpty(message = "Company name required")
	@Size(min = 1,message = "Company name required")
	private String companyName;
	@NotEmpty(message = "Company CEO name required")
	@Size(min = 1,message = "Company CEO name required")
	private String companyCEO;
	@Min(value = 100000000, message = "Company Turnover must be greater than 10Cr.")
	private BigDecimal companyTurnover;
	@NotEmpty
	@NotEmpty(message = "Company website required")
	@Size(min = 1)
	private String companyWebsite;
	@NotEmpty
	private String stockExchange;
	@CreationTimestamp
	private LocalDate createdOn;
	private Float stockPrice;
	private List<Stock> stocks;

	
}
