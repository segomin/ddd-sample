package com.sshop.order.domain;

import com.sshop.cart.domain.Cart;
import com.sshop.common.domain.AggregateRoot;
import com.sshop.common.event.Events;
import com.sshop.common.jpa.MoneyConverter;
import com.sshop.common.Money;
import com.sshop.project.domain.ProjectId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table (name = "`order`")
public class Order implements AggregateRoot {
	@EmbeddedId
	private OrderNo no;

	@Embedded
	private Orderer orderer;

	@Embedded
	private ProjectId projectId;

	@ElementCollection (fetch = FetchType.LAZY)
	@CollectionTable (name = "order_item", joinColumns = @JoinColumn (name = "order_no"))
	@OrderColumn (name = "item_idx")
	private List<OrderItem> orderItems;

	@Convert (converter = MoneyConverter.class)
	@Column (name = "total_amounts")
	private Money totalAmounts;

	@Column (name = "state")
	@Enumerated (EnumType.STRING)
	private OrderState state;

	@Column (name = "order_date")
	private LocalDateTime orderDate;


	public Order(OrderNo number, ProjectId projectId, Orderer orderer, List<OrderItem> orderItems, OrderState state) {
		// domain model 에서 할 수 있는 validation check
		setNumber(number);
		setOrderer(orderer);
		setOrderItems(orderItems);
		this.projectId = projectId;
		this.state = state;
		this.orderDate = LocalDateTime.now();
	}

	private void setNumber(OrderNo number) {
		if (number == null) throw new IllegalArgumentException("no number");
		this.no = number;
	}

	private void setOrderer(Orderer orderer) {
		if (orderer == null) throw new IllegalArgumentException("no orderer");
		this.orderer = orderer;
	}

	private void setOrderItems(List<OrderItem> orderItems) {
		verifyAtLeastOneOrMoreOrderItems(orderItems);
		this.orderItems = orderItems;
		calculateTotalAmounts();
	}

	private void verifyAtLeastOneOrMoreOrderItems(List<OrderItem> orderLines) {
		if (orderLines == null || orderLines.isEmpty()) {
			throw new IllegalArgumentException("no OrderItem");
		}
	}

	private void calculateTotalAmounts() {
		this.totalAmounts = new Money(orderItems.stream()
												.mapToInt(x -> x.getAmounts().value()).sum());
	}

}
