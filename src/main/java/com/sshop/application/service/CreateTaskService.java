package com.sshop.application.service;

import com.sshop.application.model.ResourceTaskFactory;
import com.sshop.application.model.order.CreateTaskRequest;
import com.sshop.domain.model.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateTaskService {
	@Autowired
	OrderQueryService orderQueryService;

	@Autowired
	TaskRepository taskRepository;

	@Transactional
	public void create(CreateTaskRequest request, Long userId) {
		var orders = orderQueryService.findBySomething();
		var orderItems = orders.stream().flatMap(it ->
				it.getOrderItems().stream().map(item ->
						ResourceTaskFactory.getTask(item.getItemType(), item))
		).toList();

		taskRepository.saveAll(orderItems);
	}
}
