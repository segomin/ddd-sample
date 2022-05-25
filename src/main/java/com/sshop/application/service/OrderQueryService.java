package com.sshop.application.service;

import com.sshop.domain.model.cart.CartRepository;
import com.sshop.domain.model.order.Order;
import com.sshop.domain.model.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderQueryService {
	@Autowired
	OrderRepository orderRepository;

	public List<Order> findBySomething() {
		return List.of();
	}
}
