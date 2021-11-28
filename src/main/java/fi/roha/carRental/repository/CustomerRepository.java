package fi.roha.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.roha.carRental.model.Car;
import fi.roha.carRental.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
