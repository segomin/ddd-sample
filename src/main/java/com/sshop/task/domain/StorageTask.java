package com.sshop.task.domain;

import lombok.Getter;

@Getter
public final class StorageTask extends ResourceTask {
	private final String serviceEnv;
	private final String storageType;

	public StorageTask(TaskId taskId, String serviceEnv, String storageType) {
		super(taskId, ResourceType.STORAGE);
		this.serviceEnv = serviceEnv;
		this.storageType = storageType;
	}
}
