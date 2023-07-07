package com.commerce.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * PriceResponse
 * 
 * @author RenzoChia
 *
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class PriceResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer productId;
	
	private Integer brandId;
	
	private Integer priceList;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private LocalDateTime startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private LocalDateTime endDate;

	private Double price;

}
