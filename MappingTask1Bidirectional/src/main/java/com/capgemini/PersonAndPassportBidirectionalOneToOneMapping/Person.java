package com.capgemini.PersonAndPassportBidirectionalOneToOneMapping;

import jakarta.persistence.*;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String dateOfBirth;
	@OneToOne(cascade = CascadeType.ALL)
	private Passport passport;
	
	public Person() {
		
	}

	public Person(String name, String dateOfBirth, Passport passport) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.passport = passport;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", passport=" + passport + "]";
	}
	
}
