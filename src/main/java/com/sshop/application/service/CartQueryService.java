package com.sshop.application.service;

import com.sshop.application.model.cart.CartResponse;
import com.sshop.application.model.resource.Resource;
import com.sshop.domain.model.cart.Cart;
import com.sshop.domain.model.cart.CartId;
import com.sshop.domain.model.cart.CartRepository;
import com.sshop.domain.model.member.MemberId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartQueryService {
	@Autowired
	CartRepository cartRepository;
	public List<Resource> findByMemberId(Long memeberId) {
		// domain 데이터에 맞게 변경
		var carts = cartRepository.findByMemberId(MemberId.of(memeberId));
		return carts.stream().map(it -> CartResponse.of(it)).toList();
	}

	public List<Cart> findByIds(List<CartId> ids) {
		return cartRepository.findAllById(ids);
	}
}
