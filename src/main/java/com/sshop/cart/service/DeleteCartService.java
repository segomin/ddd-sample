package com.sshop.cart.service;

import com.sshop.cart.domain.CartId;
import com.sshop.cart.domain.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteCartService {
	@Autowired
	CartRepository cartRepository;

	@Transactional
	public void deleteCart(CartId cartId) {
		cartRepository.deleteById(cartId);
	}
}
