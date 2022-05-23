package com.sshop.asset.query.resource;

import com.sshop.asset.command.domain.resource.ResourceId;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Setter
@Entity
public class ResourceData {
	@EmbeddedId
	private ResourceId id;

	@Column
	private String resourceName;
}
