package fi.roha.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.roha.carRental.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{
	
}
