package fi.roha.carRental.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rent {
	
	private @Id @GeneratedValue Long rent_id;
	private int carId;
	private int customer_id;
	private Timestamp start_time;
	private Timestamp end_time;
	
	public Rent () {}

	public Rent(int carId, int customer_id, Timestamp start_time, Timestamp end_time) {
		this.carId = carId;
		this.customer_id = customer_id;
		this.start_time = start_time;
		this.end_time = end_time;
	}


	public Long getRent_id() {
		return rent_id;
	}



	public void setRent_id(Long rent_id) {
		this.rent_id = rent_id;
	}



	public int getCar_id() {
		return carId;
	}



	public void setCar_id(int carId) {
		this.carId = carId;
	}



	public int getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}



	public Timestamp getStart_time() {
		return start_time;
	}



	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}



	public Timestamp getEnd_time() {
		return end_time;
	}



	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}



	@Override
	public String toString() {
		return "Rent [rent_id=" + rent_id + ", carId=" + carId + ", customer_id=" + customer_id + ", start_time="
				+ start_time + ", end_time=" + end_time + "]";
	}
	
	
	
	

}
