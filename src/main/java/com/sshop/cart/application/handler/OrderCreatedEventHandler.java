package com.sshop.cart.application.handler;

import com.sshop.cart.application.service.edit.DeleteCartService;
import com.sshop.cart.domain.Cart;
import com.sshop.order.domain.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * https://dev.to/peholmst/handling-domain-events-with-spring-2bmm
 * a domain event is published because something has happened, not because something will or might happen.
 * 도메인 이벤트는 발생한 내용에 대한 결과이지 발생하게 하는 원인이 아님!
 * 따라서 도메인 이벤트를 처리하는 곳에서 발생하는 오류가 이벤트를 발생한 곳까지 영향을 미치면 안됨..
 * --> 이는 도메인 이벤트를 처리하는 곳까지 @Transaction 이 전파되는게 그리 좋지 않다는 말...
 * @EventListener 대신 @TransactionalEventListener 을 사용할 경우 이벤트를 발행한 transaction 과 별도로 실행 가능
 * 	BEFORE_COMMIT, AFTER_COMMIT, AFTER_ROLLBACK, AFTER_COMPLETION
 */
@Component
public class OrderCreatedEventHandler {
	DeleteCartService deleteCartService;

	public OrderCreatedEventHandler(DeleteCartService deleteCartService) {
		this.deleteCartService = deleteCartService;
	}

	@EventListener (OrderCreatedEvent.class)
//	@TransactionalEventListener (classes = OrderCreatedEvent.class, phase = TransactionPhase.AFTER_COMMIT)
	public void handle(OrderCreatedEvent event) {
		event.causeCartIds().forEach(it -> {
			deleteCartService.deleteCart(Cart.CartId.of(it));
		});
	}
}
