package com.springmvc.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findByName(String name);

	
//	Optional<Student> findByNameAndCity(String name, String city);
	
	
	

}