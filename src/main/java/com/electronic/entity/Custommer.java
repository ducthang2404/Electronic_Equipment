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
import lombok.Getter;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Custommer")
public class Custommer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String username;
	String password;
	String phone;
	String email;
	String address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "custommer")
	List<Order> order;
}
