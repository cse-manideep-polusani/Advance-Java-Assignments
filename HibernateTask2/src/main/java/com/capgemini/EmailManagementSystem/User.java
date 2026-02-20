package com.capgemini.EmailManagementSystem;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(nullable = false)
	private String username;
	
    @ElementCollection
    @CollectionTable(
        name = "user_emails",
        joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "email", unique = true)
	private Set<String> emails;
	
	public User() {
		
	}

	public User(String username, Set<String> emails) {
		super();
		this.username = username;
		this.emails = emails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", emails=" + emails + "]";
	}
}
