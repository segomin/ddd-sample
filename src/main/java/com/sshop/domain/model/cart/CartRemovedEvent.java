package com.sshop.domain.model.cart;

import java.time.LocalDateTime;

public record CartRemovedEvent(
		Long cartId,
		LocalDateTime removedDate
) {
}
