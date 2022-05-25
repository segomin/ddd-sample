package com.sshop.application.model.cart;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeCartRequest {
	String cartId;
	Integer quantity;
}
