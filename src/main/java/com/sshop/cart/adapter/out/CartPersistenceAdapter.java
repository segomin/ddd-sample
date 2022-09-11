package com.sshop.cart.adapter.out;

import com.sshop.cart.application.port.out.CreateCartPort;
import com.sshop.cart.application.port.out.ReadCartPort;
import com.sshop.cart.application.port.out.RemoveCartPort;
import com.sshop.cart.domain.Cart;
import com.sshop.common.annotation.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class CartPersistenceAdapter implements CreateCartPort, RemoveCartPort, ReadCartPort {

	private final CartJpaRepository cartJpaRepository;

	@Override
	public void saveCart(Cart cart) {
		cartJpaRepository.save(cart);
	}

	@Override
	public void removeCart(Cart.CartId cartId) {
		cartJpaRepository.deleteById(cartId);
	}

	@Override
	public Cart findByIdx(Long basketIdx) {
		return cartJpaRepository.findById(Cart.CartId.of(basketIdx)).orElseThrow();
	}

	@Override
	public Optional<Cart> findByIdxOptional(Long basketIdx) {
		return cartJpaRepository.findById(Cart.CartId.of(basketIdx));
	}
}
