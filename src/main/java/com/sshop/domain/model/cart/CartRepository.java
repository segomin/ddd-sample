package com.sshop.domain.model.cart;

import com.sshop.domain.model.member.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, CartId> {

	List<Cart> findByMemberId(MemberId memberId);
}
