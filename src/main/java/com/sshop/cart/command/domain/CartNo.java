package com.sshop.cart.command.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CartNo {
	private String number;

	protected CartNo(String number) {
		this.number = number;
	}

	public static CartNo of(String value) {
		return new CartNo(value);
	}
}
