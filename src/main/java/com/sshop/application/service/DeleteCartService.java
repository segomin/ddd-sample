package com.sshop.application.service;

import com.sshop.domain.model.cart.CartId;
import com.sshop.domain.model.cart.CartRepository;
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
