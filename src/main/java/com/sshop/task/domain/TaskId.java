package com.sshop.task.domain;

public record TaskId(
		Long taskId
) {
	public static TaskId of(Long id) {
		return new TaskId(id);
	}
}
