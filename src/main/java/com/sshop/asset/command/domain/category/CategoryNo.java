package com.sshop.asset.command.domain.category;

import java.io.Serializable;
import java.util.Objects;

public class CategoryNo implements Serializable {
	private String number;

	protected CategoryNo() {
	}

	public CategoryNo(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CategoryNo that = (CategoryNo) o;
		return Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return number != null ? number.hashCode() : 0;
	}

	public static CategoryNo of(String value) {
		return new CategoryNo(value);
	}
}
