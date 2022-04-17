package fi.roha.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import fi.roha.carRental.exception.CarNotFoundException;
import fi.roha.carRental.repository.RentRepository;
import fi.roha.carRental.model.Rent;

@RestController
public class RentController {
	
	 private static final Logger logger = LoggerFactory.getLogger(RentController.class);
	
	@Autowired
	RentRepository rentRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/rents")
	public List<Rent> getAllRents() {
		return rentRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/rents/{rent_id}")
	public Rent GetLicense(@PathVariable Long rent_id) {
		Rent rent = rentRepository.findById(rent_id).orElseThrow(() -> new CarNotFoundException(rent_id));
		return rent;
	}
	

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/rents")
	public Rent createRent(@Valid @RequestBody Rent rent) {
		rentRepository.save(rent);
		logger.info("New rental: " + rent);
		return rent;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/rentscar/{carId}")
	public List<Rent> getAllRentsForCar(@PathVariable int carId) {
		return rentRepository.findAllBycarId(carId);
	}

}
