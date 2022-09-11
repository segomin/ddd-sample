package com.sshop.cart.domain;

import com.google.gson.Gson;
import com.sshop.common.Money;
import com.sshop.common.domain.AggregateRoot;
import com.sshop.common.jpa.MoneyConverter;
import com.sshop.member.domain.MemberId;
import com.sshop.project.domain.ProjectId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Access (AccessType.FIELD)
@Getter
@NoArgsConstructor
@Entity
public class Cart implements AggregateRoot {
	@AttributeOverrides (
			@AttributeOverride (name = "value", column = @Column (name = "id"))
	)
	@EmbeddedId
	private CartId id;

	@Embedded
	private ProjectId projectId;

	@Embedded
	private MemberId memberId;

	@Convert (converter = MoneyConverter.class)
	private Money price;

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

	public String getJsonData() {
		return new Gson().toJson(this);
	}

	public void changeJsonData(String jsonString) {
		this.someJson = jsonString;
	}

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@EqualsAndHashCode
	@Embeddable
	@Access(AccessType.FIELD)
	public static class CartId implements Serializable {
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name = "cart_id")
		private Long value;

		public static CartId of(Long id) {
			return new CartId(id);
		}
	}
}
