package com.sshop.order.infra;

import com.sshop.cart.domain.Cart;
import com.sshop.cart.application.service.edit.DeleteCartService;
import com.sshop.cart.application.handler.OrderCreatedEventHandler;
import com.sshop.order.domain.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class OrderCreatedEventHandlerTest {
	private final ApplicationContextRunner runner = new ApplicationContextRunner();

	@Test
	void testEventHandle() {
		var deleteCartService = mock(DeleteCartService.class);
		var event = sampleOrderCreateEvent(10L);

		runner.withBean(OrderCreatedEventHandler.class, deleteCartService)
			  .run(context -> {
				  context.publishEvent(event);
				  verify(deleteCartService).deleteCart(Cart.CartId.of(10L));
			  });
	}

	private OrderCreatedEvent sampleOrderCreateEvent(Long cartId) {
		return new OrderCreatedEvent(List.of(cartId), "orderNo", null, null, null);
	}
}