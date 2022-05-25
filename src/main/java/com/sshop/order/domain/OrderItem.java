package com.sshop.order.domain;

import com.sshop.common.Money;
import com.sshop.common.jpa.MoneyConverter;
import com.sshop.resource.domain.ResourceId;
import com.sshop.task.domain.ResourceType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@NoArgsConstructor
@Embeddable
public class OrderItem {
	@Embedded
	private ResourceId resourceId;

	@Column (name = "item_type")
	@Enumerated (EnumType.STRING)
	private ResourceType itemType;

	@Convert (converter = MoneyConverter.class)
	private Money price;

	private Integer quantity;

	@Convert(converter = MoneyConverter.class)
	private Money amounts;

	private String someJson;

	public OrderItem(Money price, String someJson) {
		this.price = price;
		this.someJson = someJson;
	}

	private Money calculateAmounts() {
		return price.multiply(quantity);
	}
}
