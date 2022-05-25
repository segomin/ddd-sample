package com.sshop.task.domain;

import lombok.Getter;

@Getter
public final class ComputeTask extends ResourceTask {
	private final String serviceEnv;
	private final String serviceType;
	private final String diskType;

	public ComputeTask(TaskId taskId, String serviceEnv, String serviceType, String diskType) {
		super(taskId, ResourceType.COMPUTE);
		this.serviceEnv = serviceEnv;
		this.serviceType = serviceType;
		this.diskType = diskType;

		// create event
	}
}
