package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.entity.Person;
import com.example.exception.ResourceNotFoundException;
import com.example.service.AddressService;
import com.example.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Autowired  
	PersonService personService; 
	
	//GetAddressBypersonId
	@GetMapping("/person/{personId}/address")
    public List<Address> getAddressByPersonId(@PathVariable(value = "personId") long personId) {
        return addressService.getPersonById(personId);
    }
	
	//Adding address
    @PostMapping("/person/{personId}/address")
    public Address createAddress(@PathVariable(value = "personId") Long personId,
        @Valid @RequestBody Address address) throws ResourceNotFoundException {
        
    	Optional<Person> person = personService.getPersonById(personId);
    	
    	if(person.isPresent()) {
    		address.setPerson(person.get());
            return addressService.saveAddress(address);
    	} else {
    		throw new ResourceNotFoundException("Person not found");
    	}
    	
    }
    
    //Update Address
    @PutMapping("/person/{personId}/address/{addressId}")
    public Address updateAddress(@PathVariable(value = "personId") long personId,
        @PathVariable(value = "addressId") long addressId, @Valid @RequestBody Address address)
    
       throws ResourceNotFoundException {
    	
    	Optional<Person> person = personService.getPersonById(personId);
    	Optional<Address> addressOrginal = addressService.getAddressById(addressId);
    	
    	if(person.isPresent()) {
    		address.setPerson(person.get());
    		if(addressOrginal.isPresent()) {
    			addressService.saveAddress(address);
    		} else {
    			throw new ResourceNotFoundException("Address not found");
    		}
    		
            return addressService.saveAddress(address);
    	} else {
    		throw new ResourceNotFoundException("Person not found");
    	}
    }

    

}
