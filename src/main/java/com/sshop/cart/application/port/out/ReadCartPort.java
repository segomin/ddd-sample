package com.sshop.cart.application.port.out;

import com.sshop.cart.domain.Cart;

import java.util.Optional;

public interface ReadCartPort {
	Cart findByIdx(Long basketIdx);

	Optional<Cart> findByIdxOptional(Long basketIdx);
}
