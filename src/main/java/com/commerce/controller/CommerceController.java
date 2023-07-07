package com.commerce.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.dto.PriceResponse;
import com.commerce.service.IPriceService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * CommerceController
 * 
 * @author RenzoChia
 *
 */
@RestController
@Slf4j
public class CommerceController {

	@Autowired
	private IPriceService priceService;

	@RequestMapping(value = "/price/{startDate}/{brandId}/{productId}", method = RequestMethod.GET)
	public ResponseEntity<PriceResponse> getPrice(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startDate,
			@PathVariable Integer brandId, @PathVariable Integer productId) {
		log.info("Entering getPrice [startDate]: {}: ", startDate);
		PriceResponse response = priceService.getPrice(brandId, productId, startDate);

		return new ResponseEntity<>(response, response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);

	}

}
