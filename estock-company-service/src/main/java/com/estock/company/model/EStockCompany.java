package com.estock.company.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyCode;
	private String companyName;
	private String companyCEO;
	private String companyTurnover;
	private String companyWebsite;
	private String stockEnlistedIn;
	@CreationTimestamp
	private LocalDateTime createdOn;

}
