package com.sshop.cart.command.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResource {
	String resourceNo;
	Integer quantity;
}
