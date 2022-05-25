package com.sshop.cart.service;

import com.sshop.cart.service.model.CartResponse;
import com.sshop.task.service.model.Resource;
import com.sshop.cart.domain.Cart;
import com.sshop.cart.domain.CartId;
import com.sshop.cart.domain.CartRepository;
import com.sshop.member.MemberId;
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
