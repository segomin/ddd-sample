package com.sshop.task.infra;

import com.sshop.task.service.model.ResourceTaskJpaEntity;
import com.sshop.task.domain.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskJpaRepository extends JpaRepository<ResourceTaskJpaEntity, Long> {
	@Override
	Optional<ResourceTaskJpaEntity> findById(Long aLong);

	List<ResourceTaskJpaEntity> findResourceTasksByType(ResourceType type);
}
