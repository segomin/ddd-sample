package com.sshop.cart.application.service.edit;

import com.sshop.cart.application.port.out.RemoveCartPort;
import com.sshop.cart.domain.Cart;
import com.sshop.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteCartService {
	private final RemoveCartPort removeCartPort;


	@Transactional
	public void deleteCart(Cart.CartId cartId) {
		removeCartPort.removeCart(cartId);
	}
}
