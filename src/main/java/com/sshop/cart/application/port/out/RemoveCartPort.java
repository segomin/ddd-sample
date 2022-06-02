package com.sshop.cart.application.port.out;

import com.sshop.cart.domain.Cart;

public interface RemoveCartPort {
	void removeCart(Cart.CartId cartId);
}
