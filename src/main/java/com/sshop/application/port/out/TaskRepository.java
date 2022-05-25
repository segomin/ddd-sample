package com.sshop.application.port.out;

import com.sshop.application.model.resource.ResourceTaskData;
import com.sshop.domain.model.task.ComputeTask;
import com.sshop.domain.model.task.ResourceType;
import com.sshop.domain.model.task.StorageTask;
import com.sshop.domain.model.task.TaskId;

import java.util.List;
import java.util.function.Function;

public interface TaskRepository {

	<T> List<T> findAllByType(ResourceType type, Function<ResourceTaskData, T> convert);

	TaskId saveCompute(ComputeTask task);

	TaskId saveStorage(StorageTask task);

	void saveAll(List<com.sshop.domain.model.task.ResourceTask> orderItems);
}
