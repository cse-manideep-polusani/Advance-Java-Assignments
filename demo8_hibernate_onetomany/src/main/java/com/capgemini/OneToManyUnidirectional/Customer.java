package com.capgemini.OneToManyUnidirectional;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="account_id", referencedColumnName = "id")
	private List<Account> accounts;
	
	public Customer(){
		
	}

	public Customer(String name,List<Account> accounts) {
		this.name = name;
		this.accounts=accounts;
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

	public List<Account> getAccount() {
		return accounts;
	}

	public void setAccount(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accounts=" + accounts + "]";
	}	
}
