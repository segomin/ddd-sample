package com.sshop.task.domain;

import com.sshop.common.domain.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public abstract class ResourceTask implements AggregateRoot {
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
