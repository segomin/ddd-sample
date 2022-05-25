package com.sshop.adapter.in.rest;

import com.sshop.application.model.order.CreateOrderRequest;
import com.sshop.application.service.CartQueryService;
import com.sshop.application.service.CreateCartService;
import com.sshop.application.model.cart.CreateCartComputeRequest;
import com.sshop.application.model.cart.CreateCartStorageRequest;
import com.sshop.application.model.resource.Resource;
import com.sshop.application.service.CreateOrderService;
import com.sshop.domain.model.cart.CartId;
import com.sshop.domain.model.order.OrderNo;
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
