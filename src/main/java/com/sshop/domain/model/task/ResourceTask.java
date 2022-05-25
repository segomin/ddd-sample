package com.sshop.domain.model.task;

import com.sshop.application.model.resource.Resource;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@Getter
public abstract class ResourceTask {
	final TaskId taskId;
	final ResourceType resourceType;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (obj == null || obj.getClass() != this.getClass()) return false;
		var that = (StorageTask) obj;
		return Objects.equals(this.taskId, that.taskId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(taskId);
	}
}
