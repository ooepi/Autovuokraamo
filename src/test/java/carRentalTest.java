import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.roha.carRental.controller.CarController;
import fi.roha.carRental.model.Car;
import fi.roha.carRental.repository.CarRepository;

@DataJpaTest
public class carRentalTest {
	
	@Autowired
	CarRepository carRepository;
	
	
	@Test
	public void addCarIntoDataBaseTest() {
		Car car = new Car("test", "model", "type", 5, 23.0);
		carRepository.save(car);
		
		List<Car> cars = carRepository.findAll();
		boolean found = false;
		
		for (Car c : cars) {
			if (c.getMake().equals("test")) {
				found = true;
			}
		}
		
		assertTrue(found);
	}
	
	
	@Test
	public void getACarFromDataBaseByIdTest() {
		Car car = carRepository.findById(2L).orElseThrow();
		assertEquals(2L, car.getCar_id());
	}
	
	
	@Test
	public void getAllCarsFromDatabaseAndCompareAmountTest() {
		List<Car> cars = carRepository.findAll();
		assertEquals(cars.size(), carRepository.count());
	}
	
	@Test
	public void restfulApiGetOneTest() {
		CarController carController = new CarController();
		Car car = carController.GetCarById(2L);
		assertEquals(2L, car.getCar_id());
	}
	
	
	@Test
	public void restfulApiPostTest() {
		CarController carController = new CarController();
		carController.createCar(new Car("test2", "model", "type", 5, 25.0));
		
		List<Car> cars = carRepository.findAll();
		boolean found = false;
		
		for (Car c : cars) {
			if (c.getMake().equals("test")) {
				found = true;
			}
		}
		
		assertTrue(found);
		
	}
	
}