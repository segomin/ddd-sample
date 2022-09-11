package com.sshop.cart.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class CartRemovedEvent {
	private final Long cartId;
	private final LocalDateTime removedDate;

	public CartRemovedEvent(
			Long cartId,
			LocalDateTime removedDate
	) {
		this.cartId = cartId;
		this.removedDate = removedDate;
	}

	public Long cartId() {return cartId;}

	public LocalDateTime removedDate() {return removedDate;}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (CartRemovedEvent) obj;
		return Objects.equals(this.cartId, that.cartId) &&
				Objects.equals(this.removedDate, that.removedDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, removedDate);
	}

	@Override
	public String toString() {
		return "CartRemovedEvent[" +
				"cartId=" + cartId + ", " +
				"removedDate=" + removedDate + ']';
	}

}
