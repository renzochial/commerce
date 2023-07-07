package com.commerce.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.dto.PriceResponse;
import com.commerce.entity.PriceEntity;
import com.commerce.mapper.IPriceMapper;
import com.commerce.repository.IPriceRepository;
import com.commerce.service.IPriceService;

/**
 * 
 * PriceServiceImpl
 * 
 * @author RenzoChia
 *
 */

@Service
public class PriceServiceImpl implements IPriceService {

	@Autowired
	private IPriceRepository priceRepository;

	@Autowired
	private IPriceMapper priceMapper;

	@Override
	public PriceResponse getPrice(Integer brandId, Integer productId, LocalDateTime startDate) {

		PriceEntity priceEntity = priceRepository.findPriceByStartDateAndBrandIdAndProductId(brandId, productId,
				startDate);

		PriceResponse priceResponse = priceMapper.priceEntityToPriceResponse(priceEntity);

		return priceResponse;
	}

}
