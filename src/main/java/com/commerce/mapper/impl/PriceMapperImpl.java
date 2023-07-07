package com.commerce.mapper.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.commerce.dto.PriceResponse;
import com.commerce.entity.PriceEntity;
import com.commerce.mapper.IPriceMapper;

/**
 * 
 * PriceMapperImpl
 * 
 * @author RenzoChia
 *
 */
@Component
public class PriceMapperImpl implements IPriceMapper {

	@Override
	public PriceResponse priceEntityToPriceResponse(PriceEntity priceEntity) {
		if (Objects.isNull(priceEntity)) {
			return null;
		}
		
		return PriceResponse.builder()
				.productId(priceEntity.getProductId())
				.brandId(priceEntity.getBrand().getBrandId())
				.priceList(priceEntity.getPriceList())
				.startDate(priceEntity.getStartDate())
				.endDate(priceEntity.getEndDate())
				.price(priceEntity.getPrice())
				.build();
	}

}
