package com.sshop.task.infra;

import com.sshop.task.service.model.ResourceTaskData;
import com.sshop.task.domain.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskJpaRepository extends JpaRepository<ResourceTaskData, Long> {
	@Override
	Optional<ResourceTaskData> findById(Long aLong);

	List<ResourceTaskData> findResourceTasksByType(ResourceType type);
}
