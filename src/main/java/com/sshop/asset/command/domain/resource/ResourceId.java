package com.sshop.asset.command.domain.resource;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
@Access (AccessType.FIELD)
public class ResourceId implements Serializable {
	@Column (name = "resource_id")
	private Long id;

	public Long getId() {
		return id;
	}

	public static ResourceId of(Long value) {
		return new ResourceId(value);
	}
}
