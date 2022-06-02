package com.sshop.cart.application.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeCartRequest {
	String cartId;
	Integer quantity;
}
