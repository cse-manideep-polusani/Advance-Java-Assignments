package com.capgemini.PersonAndPassportBidirectionalOneToOneMapping;

import jakarta.persistence.*;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long passportNumber;
	private String issueDate;
	private String expiryDate;
	
	@OneToOne(mappedBy = "passport")
	private Person person;
	
	public Passport() {
		
	}

	public Passport(Long passportNumber, String issueDate, String expiryDate) {
		this.passportNumber = passportNumber;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", issueDate=" + issueDate
				+ ", expiryDate=" + expiryDate + ", person=" + person + "]";
	}
		
}
