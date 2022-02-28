package com.electronic.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String username;
	String password;
	String phone;
	String email;
	String address;
	String images;
	Boolean gender;
	Boolean isAdmin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "staff")
	List<Order> order;
	
}
