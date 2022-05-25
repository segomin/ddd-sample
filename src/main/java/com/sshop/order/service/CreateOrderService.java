package com.sshop.order.service;

import com.sshop.cart.service.DeleteCartService;
import com.sshop.member.service.MemberQueryService;
import com.sshop.cart.service.CartQueryService;
import com.sshop.order.service.model.CreateOrderRequest;
import com.sshop.cart.domain.CartId;
import com.sshop.member.MemberId;
import com.sshop.order.domain.Order;
import com.sshop.order.domain.OrderItem;
import com.sshop.order.domain.OrderNo;
import com.sshop.order.domain.OrderRepository;
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
		var carts = cartQueryService.findByIds(request.getCartIds().stream().map(CartId::of).toList());
		var projectId = carts.get(0).getProjectId();
		var orderItems = carts.stream().map(it ->
				new OrderItem(it.getPrice(), it.getSomeJson())).toList();
		OrderNo orderNo = orderRepository.nextOrderNo();
		var member = memberQueryService.findById(MemberId.of(userId)); // get from
		var order = new Order(orderNo, projectId, Orderer.of(member.getId().getId(), member.getName()), orderItems, OrderState.APPROVAL_WAITING);
		orderRepository.save(order);

		// 다른 service 에 요청시 직접 service 호출 혹은 event 사용
		// carts.forEach(it -> Events.raise(new CartRemovedEvent(it.getId().getId(), LocalDateTime.now())));
		carts.forEach(it -> deleteCartService.deleteCart(it.getId()));
		return orderNo;
	}
}
