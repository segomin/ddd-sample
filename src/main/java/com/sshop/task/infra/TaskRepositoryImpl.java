package com.sshop.task.infra;

import com.sshop.task.service.model.ResourceTaskFactory;
import com.sshop.task.service.model.ResourceTaskData;
import com.sshop.task.domain.ComputeTask;
import com.sshop.task.domain.ResourceTask;
import com.sshop.task.domain.ResourceType;
import com.sshop.task.domain.StorageTask;
import com.sshop.task.domain.TaskId;
import com.sshop.task.service.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImpl implements TaskRepository {
	private final TaskJpaRepository taskJpaRepository;

	@Override
	public <T> List<T> findAllByType(ResourceType type, Function<ResourceTaskData, T> convert) {
		return taskJpaRepository.findResourceTasksByType(type).stream().map(convert::apply).toList();
	}

	@Override
	public TaskId saveCompute(ComputeTask task) {
		var resource = ResourceTaskData.from(task);
		taskJpaRepository.save(resource);
		return TaskId.of(resource.getId());
	}

	@Override
	public TaskId saveStorage(StorageTask task) {
		var resource = ResourceTaskData.from(task);
		taskJpaRepository.save(ResourceTaskData.from(task));
		return TaskId.of(resource.getId());
	}

	@Override
	public void saveAll(List<ResourceTask> tasks) {
		taskJpaRepository.saveAll(tasks.stream().map(ResourceTaskFactory::toPersistData).toList());
	}

}
