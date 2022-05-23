package com.sshop.asset.command.domain.resource;

import com.sshop.asset.command.domain.category.CategoryNo;
import lombok.Getter;

import java.util.List;

@Getter
public class ResourceDatabase extends Resource {
	private final String imageName;
	private final List<String> someList;
	private final SomeData someData;

	public ResourceDatabase(ResourceId resourceId, CategoryNo categoryNo, String resourceName, String imageName, List<String> someList, SomeData someData) {
		super(resourceId, categoryNo, resourceName);
		this.imageName = imageName;
		this.someList = someList;
		this.someData = someData;
	}
}
