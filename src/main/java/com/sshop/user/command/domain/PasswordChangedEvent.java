package com.sshop.user.command.domain;

public class PasswordChangedEvent {
	private String id;
	private String newPassword;

	public PasswordChangedEvent(String id, String newPassword) {this.id = id;
		this.newPassword = newPassword;
	}
}
