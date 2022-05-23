package com.sshop.asset.command.domain.resource;

import com.sshop.asset.command.domain.category.CategoryNo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Resource {
	private final ResourceId id;
	private final CategoryNo categoryNo;
	private final String resourceName;
}
