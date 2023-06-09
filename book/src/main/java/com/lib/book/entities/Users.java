package com.lib.book.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public class Users {

    private Long id;

    
    private String firstName;

    
//    private String lastName;

    
    private String email;

    
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // constructors, getters, setters, etc.
    public enum Role {
        USER, OPERATOR, ADMIN
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    
    
    
    
}
