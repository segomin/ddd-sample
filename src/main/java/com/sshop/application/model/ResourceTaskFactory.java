package com.sshop.application.model;

import com.sshop.application.model.resource.ResourceTaskData;
import com.sshop.domain.model.order.OrderItem;
import com.sshop.domain.model.task.ComputeTask;
import com.sshop.domain.model.task.ResourceTask;
import com.sshop.domain.model.task.ResourceType;
import com.sshop.domain.model.task.StorageTask;

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
