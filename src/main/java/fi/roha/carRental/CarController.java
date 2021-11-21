package fi.roha.carRental;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	@GetMapping("/api/cars/{car_id}")
	Car GetLicense(@PathVariable Long car_id) {
		Car car = carRepository.findById(car_id).orElseThrow(() -> new CarNotFoundException(car_id));
		return car;
	}
	
}
