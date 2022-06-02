package com.sshop.cart.application.service;

import com.sshop.cart.adapter.out.CartJpaRepository;
import com.sshop.cart.application.service.model.CartResponse;
import com.sshop.cart.domain.Cart;
import com.sshop.common.annotation.UseCase;
import com.sshop.member.domain.MemberId;
import com.sshop.task.service.model.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CartQueryService {
	private final CartJpaRepository loadCartPort;
	public List<Resource> findByMemberId(Long memeberId) {
		// domain 데이터에 맞게 변경
		var carts = loadCartPort.findByMemberId(MemberId.of(memeberId));
		return carts.stream().map(it -> CartResponse.of(it)).toList();
	}

	public List<Cart> findByIds(List<Cart.CartId> ids) {
		return loadCartPort.findAllById(ids);
	}
}
