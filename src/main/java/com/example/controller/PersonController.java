package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired  
	PersonService personService;  
	
	@GetMapping("/persons")  
	private List<Person> getAllPersons()   
	{  
	return personService.getAllPersons();  
	}  
	
	@GetMapping("/person/{personid}")  
	private Optional<Person> getPerson(@PathVariable("personid") long personid)   
	{  
	return personService.getPersonById(personid);  
	} 
	
	@DeleteMapping("/person/{personid}")  
	private void deleteBook(@PathVariable("personid") long personid)   
	{  
		personService.deletebyId(personid);  
	}  
	
	@PostMapping("/person")  
	private long savePerson(@RequestBody Person person)   
	{  
		personService.savePerson(person);  
		return person.getPersonId();  
	}  
	
	@PutMapping("/books")  
	private Person updatePerson(@RequestBody Person person)   
	{  
		personService.updatePerson(person);  
		return person;  
	}  
	
	@GetMapping(value = "/personByName/{firstName}")
	public List<Person> getPersoneByName(@PathVariable String firstName) {
		return personService.findByName(firstName);
	}
}
