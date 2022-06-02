package com.sshop.cart.application.port.out;

import com.sshop.cart.domain.Cart;

public interface CreateCartPort {
	void createCart(Cart cart);
}
