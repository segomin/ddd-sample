package com.sshop.domain.model.order;

import java.time.LocalDateTime;
import java.util.List;

public record OrderPlacedEvent(
		String orderNo,
		Orderer orderer,
		List<OrderItem> orderItems,
		LocalDateTime orderDate
) {
}
