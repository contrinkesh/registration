package com.example.registration.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.registration.model.CustomerEntity;

@Service
public class CustomerService {

	public ResponseEntity<CustomerEntity[]> getAllCustomers() {
		String url = "http://localhost:8080/dbs/customers";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<CustomerEntity[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				CustomerEntity[].class);
		CustomerEntity[] customers = responseEntity.getBody();
		return new ResponseEntity<CustomerEntity[]>(customers, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<CustomerEntity> getCustomerById(Long id) {
		String url = "http://localhost:8080/dbs/customer/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<CustomerEntity> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				CustomerEntity.class, id);
		CustomerEntity customer = responseEntity.getBody();
		return new ResponseEntity<CustomerEntity>(customer, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<CustomerEntity> createCustomer(CustomerEntity custEntity) {
		String url = "http://localhost:8080/dbs/customer";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CustomerEntity> requestEntity = new HttpEntity<CustomerEntity>(custEntity, headers);
		ResponseEntity<CustomerEntity> responseEntity = restTemplate.postForEntity(url, requestEntity,
				CustomerEntity.class);
		CustomerEntity customer = responseEntity.getBody();
		return new ResponseEntity<CustomerEntity>(customer, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<CustomerEntity> updateCustomer(CustomerEntity custEntity) {
		String url = "http://localhost:8080/dbs/customer";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CustomerEntity> requestEntity = new HttpEntity<CustomerEntity>(custEntity, headers);
		restTemplate.put(url, requestEntity);
		return new ResponseEntity<CustomerEntity>(custEntity, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Void> deleteCustomerById(Long id) {
		String url = "http://localhost:8080/dbs/customer/{id}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<CustomerEntity> requestEntity = new HttpEntity<CustomerEntity>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
