package com.commerce.service;

import java.time.LocalDateTime;

import com.commerce.dto.PriceResponse;

/**
 * IPriceService
 * 
 * @author RenzoChia
 *
 */
public interface IPriceService {

	PriceResponse getPrice(Integer brandId, Integer productId, LocalDateTime startDate);
}
