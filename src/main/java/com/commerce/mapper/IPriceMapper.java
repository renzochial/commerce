package com.commerce.mapper;

import com.commerce.dto.PriceResponse;
import com.commerce.entity.PriceEntity;

/**
 * 
 * IPriceMapper
 * 
 * @author RenzoChia
 *
 */
public interface IPriceMapper {
	
	PriceResponse priceEntityToPriceResponse(PriceEntity priceEntity);

}
