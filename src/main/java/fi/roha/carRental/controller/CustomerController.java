package fi.roha.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import fi.roha.carRental.exception.CarNotFoundException;
import fi.roha.carRental.repository.CarRepository;
import fi.roha.carRental.repository.CustomerRepository;
import fi.roha.carRental.repository.RentRepository;
import fi.roha.carRental.model.Car;
import fi.roha.carRental.model.Customer;
import fi.roha.carRental.model.Rent;

@RestController
public class CustomerController {
	
	 private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerRepository customerRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/customers/{customer_id}")
	public Customer GetLicense(@PathVariable Long customer_id) {
		Customer customer = customerRepository.findById(customer_id).orElseThrow(() -> new CarNotFoundException(customer_id));
		return customer;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@PostMapping("/customers")
	public void createCustomer(@Valid @RequestBody Customer customer) {
		customerRepository.save(customer);
		logger.info("New customer: " + customer);
	}
	/*
	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long car_id) throws CarNotFoundException{
		Car car = rentRepository.findById(car_id)
				.orElseThrow(() -> new CarNotFoundException(car_id));
		
		rentRepository.delete(car);
		logger.info("Deleted car: " + car_id );
		
		return ResponseEntity.ok().build();
	}
	*/
}
