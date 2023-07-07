package com.commerce.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.commerce.dto.PriceResponse;
import com.commerce.entity.BrandEntity;
import com.commerce.entity.PriceEntity;


/**
 * CommerceMock
 * 
 * @author RenzoChia
 *
 */
public class CommerceMock {
	
	public static int BRAND_ID 	    = 1;
	public static int PRODUCT_ID    = 35455;
	public static String START_DATE	= "2020-06-14 21:00:00";
	public static String END_DATE	= "2020-12-31 23:59:59";
	public static DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	public static PriceResponse getPriceResponse(PriceEntity entity) {
		
		return PriceResponse.builder()
				.brandId(getBrandEntity().getBrandId())
				.productId(entity.getProductId())
				.priceList(entity.getPriceList())
				.startDate(entity.getStartDate())
				.endDate(entity.getEndDate())
				.price(entity.getPrice())
				.build();
	}
	
	public static PriceEntity getPriceEntity() {
		return PriceEntity.builder()
				.priceId(1)
				.brand(getBrandEntity())
				.productId(PRODUCT_ID)
				.priceList(1)
				.startDate(getStartDate(CommerceMock.START_DATE))
				.endDate(getEndDate())
				.price(35.5)
				.build();
	}
	
	public static BrandEntity getBrandEntity() {
		return BrandEntity.builder()
				.brandId(1)
				.name("ZARA")
				.build();
	}
	
	public static LocalDateTime getStartDate(String date) {
		return LocalDateTime.parse(date ,CommerceMock.FORMAT );
	}
	
	public static LocalDateTime getEndDate() {
		return LocalDateTime.parse(CommerceMock.END_DATE ,CommerceMock.FORMAT );
	}
	
	

}
