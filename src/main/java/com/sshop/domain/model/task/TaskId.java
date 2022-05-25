package com.sshop.domain.model.task;

public record TaskId(
		Long taskId
) {
	public static TaskId of(Long id) {
		return new TaskId(id);
	}
}
