package com.sshop.cart.adapter.in;

import com.sshop.cart.application.service.DeleteCartService;
import com.sshop.cart.domain.Cart;
import com.sshop.order.domain.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedEventHandler {
	DeleteCartService deleteCartService;

	public OrderCreatedEventHandler(DeleteCartService deleteCartService) {
		this.deleteCartService = deleteCartService;
	}

	@EventListener (OrderCreatedEvent.class)
	public void handle(OrderCreatedEvent event) {
		event.causeCartIds().forEach(it -> {
			deleteCartService.deleteCart(Cart.CartId.of(it));
		});
	}
}
