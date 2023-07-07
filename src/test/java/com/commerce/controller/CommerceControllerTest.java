package com.commerce.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.commerce.repository.IPriceRepository;
import com.commerce.service.IPriceService;
import com.commerce.utils.CommerceMock;

/**
 * CommerceControllerTest
 * 
 * @author RenzoChia
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@Slf4j
@Import(CommerceController.class)
class CommerceControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private IPriceRepository repository;

	@MockBean
	private IPriceService service;

	private static String urlGet = "/price/";
	
	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPriceTestOne() throws Exception {
		
		final String starDate = "2020-06-14 10:00:00";
		var entity = repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));
		
		when(service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate)))
				.thenReturn(CommerceMock.getPriceResponse(entity));

		mvc.perform(get(urlGet + starDate + "/" + CommerceMock.BRAND_ID + "/" + CommerceMock.PRODUCT_ID)
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14 00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31 23:59:59"))
				.andExpect(jsonPath("$.price").value(35.5));

		verify(service).getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

	}
	
	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPriceTestTwo() throws Exception {
		
		final String starDate = "2020-06-14 16:00:00";
		var entity = repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));
		
		when(service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate)))
				.thenReturn(CommerceMock.getPriceResponse(entity));

		mvc.perform(get(urlGet + starDate + "/" + CommerceMock.BRAND_ID + "/" + CommerceMock.PRODUCT_ID)
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(2))
				.andExpect(jsonPath("$.startDate").value("2020-06-14 15:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-14 18:30:00"))
				.andExpect(jsonPath("$.price").value(25.45));

		verify(service).getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

	}
	
	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPriceTestThree() throws Exception {
		
		final String starDate = "2020-06-14 21:00:00";
		var entity = repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));
		
		when(service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate)))
				.thenReturn(CommerceMock.getPriceResponse(entity));

		mvc.perform(get(urlGet + starDate + "/" + CommerceMock.BRAND_ID + "/" + CommerceMock.PRODUCT_ID)
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(1))
				.andExpect(jsonPath("$.startDate").value("2020-06-14 00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31 23:59:59"))
				.andExpect(jsonPath("$.price").value(35.5));

		verify(service).getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

	}
	
	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPriceTestFour() throws Exception {
		
		final String starDate = "2020-06-15 10:00:00";
		var entity = repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));
		
		when(service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate)))
				.thenReturn(CommerceMock.getPriceResponse(entity));

		mvc.perform(get(urlGet + starDate + "/" + CommerceMock.BRAND_ID + "/" + CommerceMock.PRODUCT_ID)
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(3))
				.andExpect(jsonPath("$.startDate").value("2020-06-15 00:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-06-15 11:00:00"))
				.andExpect(jsonPath("$.price").value(30.5));

		verify(service).getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

	}
	
	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 * 
	 * 
	 * @throws Exception
	 */
	@Test
	public void getPriceTestFive() throws Exception {
		
		final String starDate = "2020-06-16 21:00:00";
		var entity = repository.findPriceByStartDateAndBrandIdAndProductId(CommerceMock.BRAND_ID,
				CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));
		
		when(service.getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate)))
				.thenReturn(CommerceMock.getPriceResponse(entity));

		mvc.perform(get(urlGet + starDate + "/" + CommerceMock.BRAND_ID + "/" + CommerceMock.PRODUCT_ID)
				.contentType(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.productId").value(35455))
				.andExpect(jsonPath("$.brandId").value(1))
				.andExpect(jsonPath("$.priceList").value(4))
				.andExpect(jsonPath("$.startDate").value("2020-06-15 16:00:00"))
				.andExpect(jsonPath("$.endDate").value("2020-12-31 23:59:59"))
				.andExpect(jsonPath("$.price").value(38.95));

		verify(service).getPrice(CommerceMock.BRAND_ID, CommerceMock.PRODUCT_ID, CommerceMock.getStartDate(starDate));

	}


}
