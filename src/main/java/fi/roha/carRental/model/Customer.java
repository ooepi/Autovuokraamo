package fi.roha.carRental.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	private @Id @GeneratedValue Long customer_id;
	private String name;
	private String email;
	private int number;
	private String address;
	
	public Customer () {}

	public Customer(String name, String email, int number, String address) {
		super();
		this.name = name;
		this.email = email;
		this.number = number;
		this.address = address;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", email=" + email + ", number=" + number
				+ ", address=" + address + "]";
	}
	
	
	
}
