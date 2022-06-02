package com.sshop.order.application.service;

import com.sshop.order.domain.Order;
import com.sshop.order.application.port.out.OrderRepository;
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
