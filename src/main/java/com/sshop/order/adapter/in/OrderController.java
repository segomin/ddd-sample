package com.sshop.order.adapter.in;

import com.sshop.order.application.service.CreateOrderRequest;
import com.sshop.cart.application.service.CartQueryService;
import com.sshop.task.service.model.Resource;
import com.sshop.order.application.service.CreateOrderService;
import com.sshop.order.domain.OrderNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/cmp/v1/work/shop/orders")
public class OrderController {
	@Autowired
	CreateOrderService createOrderService;

	@Autowired
	CartQueryService cartQueryService;


	@GetMapping ("")
	public List<Resource> findCartByMember() {
		Long memberId = 1L; // get from memeberId
		return cartQueryService.findByMemberId(memberId);
	}

	@PostMapping ("")
	public OrderNo createCartStorage(@RequestBody CreateOrderRequest createOrderRequest) {
		return createOrderService.create(createOrderRequest, 1L); // get memberId
	}
}
