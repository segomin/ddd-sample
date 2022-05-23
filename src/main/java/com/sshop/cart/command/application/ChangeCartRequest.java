package com.sshop.cart.command.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeCartRequest {
	String cartId;
	Integer quantity;
}
