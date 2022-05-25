package com.sshop.task.service.model;

import com.sshop.task.service.model.ResourceTaskData;
import com.sshop.order.domain.OrderItem;
import com.sshop.task.domain.ComputeTask;
import com.sshop.task.domain.ResourceTask;
import com.sshop.task.domain.ResourceType;
import com.sshop.task.domain.StorageTask;

public class ResourceTaskFactory {
	public static ResourceTask getTask(ResourceType itemType, OrderItem item) {
		return switch (itemType) {
			case COMPUTE -> new ComputeTask(null, item.getSomeJson(), "some", "some");
			case STORAGE -> new StorageTask(null, item.getSomeJson(), "some");
		};
	}

	public static ResourceTaskData toPersistData(ResourceTask resourceTask) {
		return switch (resourceTask.getResourceType()){
			case COMPUTE -> ResourceTaskData.from((ComputeTask) resourceTask);
			case STORAGE -> ResourceTaskData.from((StorageTask) resourceTask);
		};
	}
}
