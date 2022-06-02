package com.sshop.cart.adapter.out;

import com.sshop.cart.domain.Cart;
import com.sshop.member.domain.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartJpaRepository extends JpaRepository<Cart, Cart.CartId> {

	List<Cart> findByMemberId(MemberId memberId);
}
