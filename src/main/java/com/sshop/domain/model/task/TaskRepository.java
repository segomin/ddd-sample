package com.sshop.domain.model.task;

import com.sshop.application.model.resource.ResourceTaskData;

import java.util.List;
import java.util.function.Function;

public interface TaskRepository {

	<T> List<T> findAllByType(ResourceType type, Function<ResourceTaskData, T> convert);

	TaskId saveCompute(ComputeTask task);

	TaskId saveStorage(StorageTask task);

	void saveAll(List<com.sshop.domain.model.task.ResourceTask> orderItems);
}
