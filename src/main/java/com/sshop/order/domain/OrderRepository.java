package com.sshop.order.domain;

import com.sshop.member.MemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public interface OrderRepository extends JpaRepository<Order, OrderNo> {

	List<Order> findByMemberId(MemberId memberId);

	default OrderNo nextOrderNo() {
		int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
		String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
		return new OrderNo(number);
	}

}
