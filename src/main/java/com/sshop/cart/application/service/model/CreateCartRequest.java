package com.sshop.cart.application.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class CreateCartRequest {
	Long memberId;
	Long projectId;
	int price;
	String categoryNo;
	String resourceNo;
	Integer quantity;
}
