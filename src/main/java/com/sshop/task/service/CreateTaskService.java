package com.sshop.task.service;

import com.sshop.order.application.service.OrderQueryService;
import com.sshop.task.service.model.ResourceTaskFactory;
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
						ResourceTaskFactory.toResourceTask(item.getItemType(), item))
		).toList();
		// orders 를 읽어와서 각 task 로 만든다음, 저장할때 다시 jpa entity 로 변경해서 저장..
		taskRepository.saveAll(orderItems);
	}
}
