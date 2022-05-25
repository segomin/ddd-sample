package com.sshop.application.model.order;

import lombok.Value;

import java.util.List;

@Value
public class CreateOrderRequest {
//	Long projectId;
	List<Long> cartIds;
}
