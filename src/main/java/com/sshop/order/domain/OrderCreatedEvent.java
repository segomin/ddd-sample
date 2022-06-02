package com.sshop.order.domain;

import java.time.LocalDateTime;
import java.util.List;

public record OrderCreatedEvent(
		List<Long> causeCartIds,
		String orderNo,
		Orderer orderer,
		List<OrderItem> orderItems,
		LocalDateTime orderDate
) {
}
