package com.sshop.cart.application.port.out;

import com.sshop.cart.domain.Cart;

public interface CreateCartPort {
	void saveCart(Cart cart);
}
