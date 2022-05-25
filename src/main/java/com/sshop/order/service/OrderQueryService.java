package com.sshop.order.service;

import com.sshop.order.domain.Order;
import com.sshop.order.domain.OrderRepository;
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
