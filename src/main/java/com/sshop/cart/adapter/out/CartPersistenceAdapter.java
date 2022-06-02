package com.sshop.cart.adapter.out;

import com.sshop.cart.application.port.out.CreateCartPort;
import com.sshop.cart.application.port.out.RemoveCartPort;
import com.sshop.cart.domain.Cart;
import com.sshop.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class CartPersistenceAdapter implements CreateCartPort, RemoveCartPort {

	private final CartJpaRepository cartJpaRepository;

	@Override
	public void createCart(Cart cart) {
		cartJpaRepository.save(cart);
	}

	@Override
	public void removeCart(Cart.CartId cartId) {
		cartJpaRepository.deleteById(cartId);
	}
}
