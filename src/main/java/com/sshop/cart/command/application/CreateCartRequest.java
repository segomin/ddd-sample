package com.sshop.cart.command.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCartRequest {
	Long userId;
	String categoryNo;
	String resourceNo;
	Integer quantity;
}
