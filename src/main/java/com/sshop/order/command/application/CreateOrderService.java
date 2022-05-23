package com.sshop.order.command.application;

import com.sshop.asset.command.domain.resource.ResourceRepository;
import com.sshop.asset.query.resource.ResourceDataDao;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService {
	private ResourceDataDao resourceDataDao;
	public void createOrder(CreateOrderRequest request) {

	}
}
