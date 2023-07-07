package com.commerce.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.commerce.mapper.IPriceMapper;
import com.commerce.repository.IPriceRepository;
import com.commerce.utils.CommerceMock;

/**
 * 
 * PriceServiceImplTest
 * 
 * @author RenzoChia
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class PriceServiceImplTest {
	
	@Mock
	private IPriceRepository repository;
	
	@Mock
	private IPriceMapper mapper;
	
	
	@InjectMocks
	private PriceServiceImpl service;
	
	@Test
	public void getPriceTest() throws Exception {
		final String starDate = "2020-06-14 21:00:00";
		
		when(repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate) ) )
		.thenReturn(CommerceMock.getPriceEntity());
		
		when(mapper.priceEntityToPriceResponse(CommerceMock.getPriceEntity()))
		.thenReturn(CommerceMock.getPriceResponse(CommerceMock.getPriceEntity()));
		
		var result = service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

		assertEquals(CommerceMock.BRAND_ID, result.getBrandId());
		assertEquals(CommerceMock.PRODUCT_ID, result.getProductId());
		assertEquals(CommerceMock.getStartDate(starDate), result.getStartDate());
	}

}
