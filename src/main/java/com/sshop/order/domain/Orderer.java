package com.sshop.order.domain;

import com.sshop.member.domain.MemberId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Access (AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class Orderer implements Serializable {
	@AttributeOverrides (
			@AttributeOverride (name = "id", column = @Column(name = "orderer_id"))
	)
	private MemberId memberId;

	@Column(name = "orderer_name")
	private String name;

	public static Orderer of(Long ordererId, String ordererName) {
		return new Orderer(MemberId.of(ordererId), ordererName);
	}
}
