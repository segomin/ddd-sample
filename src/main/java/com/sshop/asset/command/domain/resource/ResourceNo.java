package com.sshop.asset.command.domain.resource;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Access (AccessType.FIELD)
public class ResourceNo implements Serializable {
	private String number;

	protected ResourceNo() {
	}

	public ResourceNo(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResourceNo that = (ResourceNo) o;
		return Objects.equals(number, that.number);
	}

	@Override
	public int hashCode() {
		return number != null ? number.hashCode() : 0;
	}

	public static ResourceNo of(String value) {
		return new ResourceNo(value);
	}
}
