package co.edu.unbosque.DressCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_customer;
	private String document;
	private String name;
	private String address;
	private String phone_number;
	private String email;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String document, String name, String address, String phone_number,
			String email) {
		this.document = document;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.email = email;
	}

	public Integer getId_customer() {
		return id_customer;
	}
	public void setId_customer(Integer id_customer) {
		this.id_customer = id_customer;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
