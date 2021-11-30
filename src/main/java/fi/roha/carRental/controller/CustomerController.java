package fi.roha.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import fi.roha.carRental.exception.CarNotFoundException;
import fi.roha.carRental.repository.CustomerRepository;
import fi.roha.carRental.model.Customer;

@RestController
public class CustomerController {
	
	 private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/customers/{customer_id}")
	public Customer GetLicense(@PathVariable Long customer_id) {
		Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new CarNotFoundException(customer_id));
		return customer;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/customers")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		customerRepository.save(customer);
		logger.info("New customer: " + customer);
		return customer;
		
	}
}
