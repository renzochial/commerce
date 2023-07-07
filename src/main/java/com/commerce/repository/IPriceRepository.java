package com.commerce.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.commerce.entity.PriceEntity;

/**
 * 
 * IPrecioRepository
 * 
 * @author RenzoChia
 *
 */
@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Integer> {

	@Query(value = " SELECT * FROM PRICES" 
				+ " WHERE BRAND_ID = ?1 AND PRODUCT_ID = ?2"
				+ " AND ?3 BETWEEN START_DATE AND END_DATE" 
				+ " ORDER BY PRIORITY DESC" 
				+ " LIMIT 1"
				,nativeQuery = true)
	PriceEntity findPriceByStartDateAndBrandIdAndProductId(Integer brandId, Integer productId, LocalDateTime startDate);

}
