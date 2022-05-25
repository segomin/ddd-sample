package com.sshop.adapter.out;

import com.sshop.adapter.out.jpa.TaskJpaRepository;
import com.sshop.application.model.ResourceTaskFactory;
import com.sshop.application.model.resource.ResourceTaskData;
import com.sshop.domain.model.task.ComputeTask;
import com.sshop.domain.model.task.ResourceTask;
import com.sshop.domain.model.task.ResourceType;
import com.sshop.domain.model.task.StorageTask;
import com.sshop.domain.model.task.TaskId;
import com.sshop.domain.model.task.TaskRepository;
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
