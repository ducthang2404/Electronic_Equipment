package com.electronic.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "OrdersDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Integer quantily;
	Double price;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	Product product;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	Order order;
}
