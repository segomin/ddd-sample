package com.sshop.task.service.model;

import com.sshop.task.domain.ComputeTask;
import com.sshop.task.domain.ResourceType;
import com.sshop.task.domain.StorageTask;
import com.sshop.task.domain.TaskId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Access (AccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@Entity
public class ResourceTaskJpaEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (name = "type")
	@Enumerated (EnumType.STRING)
	ResourceType type;

	String someField;

	String someJson;

	public static ResourceTaskJpaEntity from(ComputeTask task) {
		return new ResourceTaskJpaEntity(task.getTaskId().taskId(), task.getResourceType(), task.getServiceEnv(), task.getServiceType());
	}
	public static ResourceTaskJpaEntity from(StorageTask task) {
		return new ResourceTaskJpaEntity(task.getTaskId().taskId(), task.getResourceType(), task.getServiceEnv(), task.getStorageType());
	}

	public ComputeTask toComputeTask() {
		return new ComputeTask(TaskId.of(id), someField, someJson, "diskType");
	}

	public StorageTask toStorageTask() {
		return new StorageTask(TaskId.of(id), someField, someJson);
	}
}
