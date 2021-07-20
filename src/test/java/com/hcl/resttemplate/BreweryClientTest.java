package com.hcl.resttemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.resttemplate.web.client.BreweryClient;
import com.hcl.resttemplate.web.model.BeerDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerById() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		
		assertNotNull(dto);
	}
	
	@Test
	void saveBeer() {
		BeerDto beerDto=BeerDto.builder().beerName("New beer").build();
		
		URI uri = client.saveBeer(beerDto);
		
		assertNotNull(uri);
		log.debug(uri.toString());
		System.out.println(uri.toString());
	}
	
	@Test
	void updateBeer() {
		BeerDto beerDto=BeerDto.builder().beerName("New beer").build();
		
		client.updateBeer(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void deleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}
	
}
