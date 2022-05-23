package com.sshop.user.command.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Password {
	@Column(name = "password")
	private String value;

	protected Password() {

	}

	public Password(String value) {
		this.value = value;
	}

	public boolean match(String value) {
		return this.value.equals(value);
	}
}
