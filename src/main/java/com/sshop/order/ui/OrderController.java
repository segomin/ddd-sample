package com.sshop.order.ui;


import com.sshop.order.command.application.CreateOrderRequest;
import com.sshop.order.command.application.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cmp/v1/work/orders")
public class OrderController {

	@Autowired
	CreateOrderService createOrderService;


	@PostMapping(value = "/")
	public void createOrder(@RequestBody CreateOrderRequest request) {
		createOrderService.createOrder(request);
	}
}
