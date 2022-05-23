package com.sshop.user.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserId implements Serializable {
	@Column(name = "user_id")
	String id;

	protected UserId() {
	}

	public UserId(String id) {this.id = id;}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserId userId = (UserId) o;
		return Objects.equals(id, userId.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public static UserId of(String id) {
		return new UserId(id);
	}
}
