package com.sshop.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
	@Column(name = "orderer_id")
	private Long id;

	@Column(name = "orderer_name")
	private String name;

	public static Orderer of(Long ordererId, String ordererName) {
		return new Orderer(ordererId, ordererName);
	}
}
