package com.sshop.cart.command.domain;

import com.sshop.cart.command.application.CreateCartRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddCartService {
	CartRepository cartRepository;

	/**
	 * 단순 CRUD 에서는 별다른 Domain 로직이 없음
	 * 이런경우 repository 도 JpaRepository 를 그대로 사용해도 좋음
	 * Domain 내에서 validation check 가 가능한 경우 Domain 객체 내부에서 check
	 */
	@Transactional
	public CartId addToCart(CreateCartRequest request) {
		var cart = new Cart(request.getUserId(), request.getCategoryNo(), request.getResourceNo(), request.getQuantity());
		Cart newCart = cartRepository.save(cart);
		return newCart.getId();
	}
}
