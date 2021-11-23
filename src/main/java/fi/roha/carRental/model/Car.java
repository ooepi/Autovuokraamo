package fi.roha.carRental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	
	private @Id @GeneratedValue Long car_id;
	private String mark;
	private String model;
	private String type;
	private int seats;
	private Double price;
	
	
	
	public Car () {}
	
	public Car(String mark, String model, String type, int seats, Double price) {
		this.mark = mark;
		this.model = model;
		this.type = type;
		this.seats = seats;
		this.price = price;
	}

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [car_id=" + car_id + ", mark=" + mark + ", model=" + model + ", type=" + type + ", seats=" + seats
				+ ", price=" + price + "]";
	}
}
