package fi.roha.carRental.exception;

public class CarNotFoundException extends RuntimeException{
	public CarNotFoundException(Long car_id) {
		super("Car " + car_id + " not found");
	}
}
