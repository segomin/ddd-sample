package com.sshop.cart.command.domain;

import com.sshop.cart.command.application.CreateCartRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditCartService {
	@Transactional
	public CartId changeCart(CreateCartRequest request) {
		return CartId.of(123L);
	}
}
