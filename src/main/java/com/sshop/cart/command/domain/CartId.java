package com.sshop.cart.command.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Access (AccessType.FIELD)
@EqualsAndHashCode
@Embeddable
@AllArgsConstructor
@Getter
public class CartId implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id")
	private Long value;

	protected CartId() {
	}

	public static CartId of(Long value) {
		return new CartId(value);
	}
}
