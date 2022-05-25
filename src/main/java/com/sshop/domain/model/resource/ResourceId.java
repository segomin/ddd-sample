package com.sshop.domain.model.resource;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Access (AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Embeddable
public class ResourceId implements Serializable {
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	public static ResourceId of(Long id) {
		return new ResourceId(id);
	}
}
