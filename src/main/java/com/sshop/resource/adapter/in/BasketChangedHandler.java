package com.sshop.resource.adapter.in;

import com.sshop.cart.domain.BasketChangedEvent;
import com.sshop.cart.domain.BasketCreatedEvent;
import com.sshop.resource.application.service.ResourceSimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@RequiredArgsConstructor
@Component
public class BasketChangedHandler {
	ResourceSimulationService resourceSimulationService;

	@TransactionalEventListener
	public void basketCreatedListener(BasketCreatedEvent event) {
		resourceSimulationService.simulateBasketResource(event.getBasketId());
	}

	@TransactionalEventListener
	public void basketChangedListener(BasketChangedEvent event) {
		resourceSimulationService.simulateBasketResource(event.getBasketId());
	}
}
