package com.sshop.asset.command.domain.category;

public class Category {
	private CategoryNo id;

	private String name;

	public Category(CategoryNo id, String name) {
		this.id = id;
		this.name = name;
	}

	public CategoryNo getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
