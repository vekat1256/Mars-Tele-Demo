package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Person;
import com.example.repository.PersonRepository;

@Transactional
@Service
public class PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPersons() {
		List<Person> listPerson = new ArrayList<>();
		personRepository.findAll().forEach(persons1 -> listPerson.add(persons1));
		return listPerson;
	}
	
	public Optional<Person> getPersonById(long personId) {
		return personRepository.findById(personId);
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public void deletebyId(long personId) {
		personRepository.deleteById(personId);
	}
	
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}
	
	
	public List<Person> findByName(String name) {
		return personRepository.findByFirstName(name);
	}


}
