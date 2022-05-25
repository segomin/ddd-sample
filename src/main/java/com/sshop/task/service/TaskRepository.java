package com.sshop.task.service;

import com.sshop.task.service.model.ResourceTaskData;
import com.sshop.task.domain.ComputeTask;
import com.sshop.task.domain.ResourceType;
import com.sshop.task.domain.StorageTask;
import com.sshop.task.domain.TaskId;
import com.sshop.task.domain.ResourceTask;

import java.util.List;
import java.util.function.Function;

public interface TaskRepository {

	<T> List<T> findAllByType(ResourceType type, Function<ResourceTaskData, T> convert);

	TaskId saveCompute(ComputeTask task);

	TaskId saveStorage(StorageTask task);

	void saveAll(List<ResourceTask> orderItems);
}
