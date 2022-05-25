package com.sshop.adapter.out.jpa;

import com.sshop.application.model.resource.ResourceTaskData;
import com.sshop.domain.model.task.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskJpaRepository extends JpaRepository<ResourceTaskData, Long> {
	@Override
	Optional<ResourceTaskData> findById(Long aLong);

	List<ResourceTaskData> findResourceTasksByType(ResourceType type);
}
