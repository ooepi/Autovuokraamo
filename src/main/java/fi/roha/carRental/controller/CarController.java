package fi.roha.carRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import fi.roha.carRental.exception.CarNotFoundException;
import fi.roha.carRental.repository.CarRepository;
import fi.roha.carRental.model.Car;

@RestController
public class CarController {
	
	 private static final Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@Autowired
	CarRepository carRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/cars/{car_id}")
	public Car GetCarById(@PathVariable Long car_id) {
		Car car = carRepository.findById(car_id).orElseThrow(() -> new CarNotFoundException(car_id));
		return car;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/cars")
	public void createCar(@Valid @RequestBody Car car) {
		carRepository.save(car);
		logger.info("New car: " + car);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long car_id) throws CarNotFoundException{
		Car car = carRepository.findById(car_id)
				.orElseThrow(() -> new CarNotFoundException(car_id));
		
		carRepository.delete(car);
		logger.info("Deleted car: " + car_id );
		
		return ResponseEntity.ok().build();
	}
	
}
