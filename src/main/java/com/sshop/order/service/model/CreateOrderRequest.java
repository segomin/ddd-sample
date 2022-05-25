package com.sshop.order.service.model;

import lombok.Value;

import java.util.List;

@Value
public class CreateOrderRequest {
//	Long projectId;
	List<Long> cartIds;
}
