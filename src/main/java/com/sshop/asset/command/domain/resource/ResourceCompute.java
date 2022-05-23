package com.sshop.asset.command.domain.resource;

import com.sshop.asset.command.domain.category.CategoryNo;
import lombok.Getter;

@Getter
public class ResourceCompute extends Resource {
	private final String cpu;

	public ResourceCompute(ResourceNo resourceNo, CategoryNo categoryNo, String resourceName, String cpu) {
		super(resourceNo, categoryNo, resourceName);
		this.cpu = cpu;
	}
}
