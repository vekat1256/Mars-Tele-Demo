package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//id, street, city, state,postalCode
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long addressId;
	
	@Column(name="street", nullable=false)
	private String street;
	
	@Column(name="city", nullable=false)
	private String city;
	
	
	@Column(name="state", nullable=false)
	private String state;
	
	@Column(name="postalCode", nullable=false)
	private String postalCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personId", nullable = false)
    private Person person;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public Address() {	}
	
	public Address(String street, String city, String state, String postalCode) {
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person2) {
		this.person = person2;
	}
	
	
	

}
