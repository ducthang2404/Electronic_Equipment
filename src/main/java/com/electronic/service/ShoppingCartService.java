package com.electronic.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.electronic.dao.ProductDAO;
import com.electronic.entity.Product;

@SessionScope
@Service
public class ShoppingCartService {
	@Autowired 
	ProductDAO productDAO;
	
Map<Integer, Product> map = new HashMap<>();
	
	public void add(Integer id) {
		if(map.containsKey(id)) {
			Product item = map.get(id);
			item.setQuantily(1 + item.getQuantily());
		} else {
			Product item = productDAO.findById(id).get();
			item.setQuantily(1);
			map.put(id, item);
		}
	}
	
	public void remove(Integer id) {
		map.remove(id);
	}
	
	public void update(Integer id, Integer qty) {
		Product item = map.get(id);
		item.setQuantily(qty);
	}

	public Object getInfo() {
		int count = 0;
		double amount = 0;
		for(Product p: map.values()) {
			count += p.getQuantily();
			amount += p.getQuantily() * p.getPrice() * (1 - p.getDiscount());
		}
		return Map.of("count", count, "amount", amount);
	}
	
	public Collection<Product> getItems(){
		return map.values();
	}

	public void clear() {
		map.clear();
	}
}
