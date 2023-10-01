package com.undefitable.TrainingInstitute.Entities;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role_name;
    private String role_description;
    
    @ManyToMany(mappedBy = "roles")
    private Set<User> user = new HashSet<>();
    
    
    //getter setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_escription(String role_escription) {
		this.role_description = role_description;
	}

	public Set<User> getUsers() {
		return user;
	}

	public void setUsers(Set<User> users) {
		this.user = users;
	}

	public Role(Long id, String role_name, String role_escription, Set<User> user) {
		super();
		this.id = id;
		this.role_name = role_name;
		this.role_description = role_escription;
		this.user=user;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Getters and setters
    
    
}

