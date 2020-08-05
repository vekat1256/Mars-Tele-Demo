package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	List<Person> findByFirstName(String firstName);
	
	List<Person> findByFirstNameAndLastName(String firstName);
	

}
