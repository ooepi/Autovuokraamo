package fi.roha.carRental;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid; 


import java.util.List;

@RestController
public class CarController {
	
	//Bring the local database
	private final CarRepository carRepository;
	
	CarController(CarRepository repository) {
		this.carRepository = repository;
	}
	
	
	@GetMapping("/api/cars")
	public List<Car> getAllCars(){
		return carRepository.findAll();
	}
	
	/*
	@GetMapping("/api/cars/{car_id}")
	Car GetLicense(@PathVariable Long car_id) {
		Car car = carRepository.findById(car_id).orElseThrow(() -> new CarNotFoundException(car_id));
		return car;
	}
	
	@PostMapping("/api/cars")
	public Car createCar(@Valid @ModelAttribute Car car) {
		return carRepository.save(car);
	}
	
	/*
	@PostMapping("/api/cars")
	public Car createCar(@Valid @RequestBody Car car) {
		return carRepository.save(car);
	}
	
	@DeleteMapping("/api/cars/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long car_id) throws CarNotFoundException{
		Car car = carRepository.findById(car_id)
				.orElseThrow(() -> new CarNotFoundException(car_id));
		
		carRepository.delete(car);
		
		return ResponseEntity.ok().build();
	}
	*/
}
