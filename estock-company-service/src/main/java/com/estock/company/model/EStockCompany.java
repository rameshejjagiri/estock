package com.estock.company.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.estock.company.utills.CompanyCodeGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EStockCompany {
	@Id
	@GeneratedValue(generator = "companycode_seq_generator", strategy = GenerationType.SEQUENCE)
	@GenericGenerator(name = "companycode_seq_generator", strategy = "com.estock.company.utills.CompanyCodeGenerator", parameters = {
			@Parameter(name = CompanyCodeGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = CompanyCodeGenerator.VALUE_PREFIX_PARAMETER, value = "Comp"),
			@Parameter(name = CompanyCodeGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name = "company_code")
	private String companyCode;
	@NotEmpty(message = "Company name required")
	@Size(min = 1)
	private String companyName;
	@NotEmpty
	@Size(min = 1)
	private String companyCEO;
	@Min(value = 100000000, message = "Company Turnover must be greater than 10Cr.")
	private Integer companyTurnover;
	@NotEmpty
	@NotEmpty(message = "Company website required")
	@Size(min = 1)
	private String companyWebsite;
	@NotEmpty
	private String stockExlistedIn;
	@CreationTimestamp
	private LocalDate createdOn;

}
