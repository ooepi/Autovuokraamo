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
import fi.roha.carRental.repository.RentRepository;
import fi.roha.carRental.model.Car;
import fi.roha.carRental.model.Rent;

@RestController
public class RentController {
	
	 private static final Logger logger = LoggerFactory.getLogger(RentController.class);
	
	@Autowired
	RentRepository rentRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/rents")
	public List<Rent> getAllRents() {
		return rentRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@GetMapping("/rents/{rent_id}")
	public Rent GetLicense(@PathVariable Long rent_id) {
		Rent rent = rentRepository.findById(rent_id).orElseThrow(() -> new CarNotFoundException(rent_id));
		return rent;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	//@CrossOrigin(origins = "http://localhost:8082")
	@PostMapping("/rents")
	public void createRent(@Valid @RequestBody Rent rent) {
		rentRepository.save(rent);
		logger.info("New rental: " + rent);
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
