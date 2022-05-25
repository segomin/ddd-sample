package com.sshop.cart.domain;

import java.time.LocalDateTime;

public record CartRemovedEvent(
		Long cartId,
		LocalDateTime removedDate
) {
}
