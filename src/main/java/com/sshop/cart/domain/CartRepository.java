package com.sshop.cart.domain;

import com.sshop.member.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {

	List<Cart> findByMemberId(MemberId memberId);
}
