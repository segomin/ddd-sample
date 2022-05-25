package com.sshop.domain.model.order;

import com.sshop.common.jpa.MoneyConverter;
import com.sshop.domain.model.common.Money;
import com.sshop.domain.model.resource.ResourceId;
import com.sshop.domain.model.task.ResourceType;
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
