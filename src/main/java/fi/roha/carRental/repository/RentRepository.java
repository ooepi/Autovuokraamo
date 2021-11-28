package fi.roha.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.roha.carRental.model.Car;
import fi.roha.carRental.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>{
	
}
