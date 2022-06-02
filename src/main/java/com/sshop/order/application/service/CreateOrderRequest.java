package com.sshop.order.application.service;

import lombok.Value;

import java.util.List;

@Value
public class CreateOrderRequest {
//	Long projectId;
	List<Long> cartIds;
}
