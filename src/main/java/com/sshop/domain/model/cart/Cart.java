package com.sshop.domain.model.cart;

import com.sshop.common.jpa.MoneyConverter;
import com.sshop.domain.model.common.Money;
import com.sshop.domain.model.member.MemberId;
import com.sshop.domain.model.project.ProjectId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class Cart {
	@EmbeddedId
	private CartId id;

	private MemberId memberId;

	@Convert (converter = MoneyConverter.class)
	@Column (name = "price")
	private Money price;

	private ProjectId projectId;

	private String someName;

	private String someField;

	private String someJson;

	public Cart(Long memberId, int price, Long projectId, String someName, String someField, String someJson) {
		// domain model 에서 할 수 있는 validation check
		this.memberId = MemberId.of(memberId);
		this.price = Money.of(price);
		this.projectId = ProjectId.of(projectId);
		this.someName = someName;
		this.someField = someField;
		this.someJson = someJson;
	}
}
