package com.rm.spring.finalex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.spring.finalex.model.Customer;
import com.rm.spring.finalex.repository.CustomerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Mono<Customer> addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Flux<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Mono<Customer> getCustomerById(String id) {
		return customerRepository.findById(id);
	}

	public Mono<Customer> updateCustomer(String id, Customer updatedCustomer) {
		return customerRepository.findById(id).flatMap(existing -> {
			updatedCustomer.setCustomerId(id);
			return customerRepository.save(updatedCustomer);
		});
	}

	public Mono<Void> deleteCustomer(String id) {
		return customerRepository.deleteById(id);
	}
}
