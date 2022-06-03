package com.sshop.order.application.service;

import com.sshop.cart.domain.Cart;
import com.sshop.cart.application.service.edit.DeleteCartService;
import com.sshop.common.event.Events;
import com.sshop.member.application.service.MemberQueryService;
import com.sshop.cart.application.service.get.CartQueryService;
import com.sshop.member.domain.MemberId;
import com.sshop.order.domain.Order;
import com.sshop.order.domain.OrderCreatedEvent;
import com.sshop.order.domain.OrderItem;
import com.sshop.order.domain.OrderNo;
import com.sshop.order.application.port.out.OrderRepository;
import com.sshop.order.domain.OrderState;
import com.sshop.order.domain.Orderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateOrderService {
	@Autowired
	CartQueryService cartQueryService;

	@Autowired
	DeleteCartService deleteCartService;

	@Autowired
	MemberQueryService memberQueryService;

	@Autowired
	OrderRepository orderRepository;

	@Transactional
	public OrderNo create(CreateOrderRequest request, Long userId) {
		var carts = cartQueryService.findByIds(request.getCartIds().stream().map(Cart.CartId::of).toList());
		var projectId = carts.get(0).getProjectId();
		var orderItems = carts.stream().map(it ->
				new OrderItem(it.getPrice(), it.getSomeJson())).toList();
		OrderNo orderNo = orderRepository.nextOrderNo();
		var member = memberQueryService.findById(MemberId.of(userId)); // get from
		var order = new Order(orderNo, projectId, Orderer.of(member.getId().getId(), member.getName()), orderItems, OrderState.APPROVAL_WAITING);
		orderRepository.save(order);

		var cartIds = carts.stream().map(cart -> cart.getId().getValue()).toList();
		Events.raise(new OrderCreatedEvent(cartIds, order.getNo().getNumber(), order.getOrderer(), orderItems, order.getOrderDate()));
		return orderNo;
	}
}
