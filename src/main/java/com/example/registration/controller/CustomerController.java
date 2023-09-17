package com.example.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.registration.model.CustomerEntity;
import com.example.registration.service.CustomerService;

@RestController
@RequestMapping("/registration")
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService custService;

	@GetMapping("customers")
	public ResponseEntity<CustomerEntity[]> getAllCustomers() {
		logger.info("######## REGISTRATION CustomerController.getAllCustomers() STARTED ########");
		return custService.getAllCustomers();
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id) {
		logger.info("######## REGISTRATION CustomerController.getCustomerById() STARTED ########");
		return custService.getCustomerById(id);
	}

	@PostMapping("customer")
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity custEntity) {
		logger.info("######## REGISTRATION CustomerController.createCustomer() STARTED ########");
		return custService.createCustomer(custEntity);
	}

	@PutMapping("customer")
	public ResponseEntity<CustomerEntity> updateCustomer(@RequestBody CustomerEntity custEntity) {
		logger.info("######## REGISTRATION CustomerController.updateCustomer() STARTED ########");
		return custService.updateCustomer(custEntity);
	}

	@DeleteMapping("customer/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
		logger.info("######## REGISTRATION CustomerController.deleteCustomerById() STARTED ########");
		return custService.deleteCustomerById(id);
	}
}
