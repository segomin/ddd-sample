package com.sshop.cart.command.domain;

import com.sshop.asset.command.domain.category.CategoryNo;
import com.sshop.asset.command.domain.resource.ResourceNo;
import com.sshop.cart.command.application.CreateCartRequest;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity
public class Cart {
	@EmbeddedId
	private CartId id;

	@Embedded
	@Column
	private ResourceNo resourceNo;
	@Embedded
	@Column
	private CategoryNo categoryNo;
	@Column
	private Integer quantity;


	public Cart() {
	}

	public Cart(Long userId, String resourceNo, String categoryNo, Integer quantity) {
		// validation check
		this.id = CartId.of(userId);
		this.resourceNo = ResourceNo.of(resourceNo);
		this.categoryNo = CategoryNo.of(categoryNo);
		this.quantity = quantity;
	}
}
