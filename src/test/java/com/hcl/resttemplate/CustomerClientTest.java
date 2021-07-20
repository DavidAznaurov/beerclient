package com.hcl.resttemplate;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.hcl.resttemplate.web.client.CustomerClient;
import com.hcl.resttemplate.web.model.CustomerDto;


@SpringBootTest
public class CustomerClientTest {
	
	@Autowired
	CustomerClient customerClient;
	
	@Test
	void getCustomerById() {
		CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDto);
	}
	
	@Test
	void createCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("David").build();
		
		URI uri = customerClient.saveCustomer(customerDto);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}
	
	@Test
	void updateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("Anthony").build();
		customerClient.updateCustomer(UUID.randomUUID(), customerDto);
	}
	
	@Test
	void deleteCustomer() {
		customerClient.deleteCustomer(UUID.randomUUID());
	}

}
