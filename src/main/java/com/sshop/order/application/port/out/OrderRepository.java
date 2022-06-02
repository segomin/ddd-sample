package com.sshop.order.application.port.out;

import com.sshop.order.domain.Order;
import com.sshop.order.domain.OrderNo;
import com.sshop.order.domain.Orderer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public interface OrderRepository extends JpaRepository<Order, OrderNo> {

	List<Order> findByOrderer(Orderer orderer);

	default OrderNo nextOrderNo() {
		int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
		String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
		return new OrderNo(number);
	}

}
