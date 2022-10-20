package com.estock.stock.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;
	private Float stockPrice;
	@CreationTimestamp
	private LocalDate createdOn;
	private String companyCode;

}
