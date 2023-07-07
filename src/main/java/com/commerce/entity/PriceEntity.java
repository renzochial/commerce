package com.commerce.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * PriceEntity
 * 
 * @author RenzoChia
 *
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
public class PriceEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "price_id", nullable = false)
	private Integer priceId;
	
	@ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
	private BrandEntity brand;
	
	@Column(name = "start_date", nullable = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private LocalDateTime startDate;
	
	@Column(name = "end_date", nullable = true)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-5")
	private LocalDateTime endDate;
	
	@Column(name = "price_list", nullable = true)
	private Integer priceList;
	
	@Column(name = "product_id", nullable = true)
	private Integer productId;
	
	@Column(name = "priority", nullable = true)
	private Integer priority;
	
	@Column(name = "price", nullable = true)
	private Double price;
	
	@Column(name = "curr", nullable = true)
	private String curr;

}
