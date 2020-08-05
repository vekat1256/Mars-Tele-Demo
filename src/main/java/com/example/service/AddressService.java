package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Address;
import com.example.repository.AddressRepository;

@Transactional
@Service
public class AddressService {
	
	@Autowired
	AddressRepository addressRepository;
	
	public List<Address> getPersonById(long personId) {
		return addressRepository.findByPerson(personId);
	}
	
	public Optional<Address> getAddressById(long addressId) {
		return addressRepository.findById(addressId);
	}
	
	public List<Address> getAddressByPostalCodeAndPersonId(String postalCode, long personId) {
		return addressRepository.findByPostalCodeAndPerson(postalCode, personId);
	}
	
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
}
