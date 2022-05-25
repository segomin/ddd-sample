package com.sshop.application.model.resource;

import com.sshop.domain.model.task.ComputeTask;
import com.sshop.domain.model.task.ResourceType;
import com.sshop.domain.model.task.StorageTask;
import com.sshop.domain.model.task.TaskId;
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
public class ResourceTaskData {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@Column (name = "type")
	@Enumerated (EnumType.STRING)
	ResourceType type;

	String someField;

	String someJson;

	public static ResourceTaskData from(ComputeTask task) {
		return new ResourceTaskData(task.getTaskId().taskId(), task.getResourceType(), task.getServiceEnv(), task.getServiceType());
	}
	public static ResourceTaskData from(StorageTask task) {
		return new ResourceTaskData(task.getTaskId().taskId(), task.getResourceType(), task.getServiceEnv(), task.getStorageType());
	}

	public ComputeTask toComputeTask() {
		return new ComputeTask(TaskId.of(id), someField, someJson, "diskType");
	}

	public StorageTask toStorageTask() {
		return new StorageTask(TaskId.of(id), someField, someJson);
	}
}
