package com.sshop.cart.application.service.create;

import com.sshop.cart.application.service.create.CreateCartRequest;
import lombok.Value;

import java.util.List;

@Value
public class CreateCartStorageRequest extends CreateCartRequest {
	private List<Integer> capacities;
	private String volumeGroupName;
	private String volumeMemo;

	public CreateCartStorageRequest(Long userId, Long projectId, int price, String categoryNo, String resourceNo, Integer quantity, List<Integer> capacities, String volumeGroupName, String volumeMemo) {
		super(userId, projectId, price, categoryNo, resourceNo, quantity);
		this.capacities = capacities;
		this.volumeGroupName = volumeGroupName;
		this.volumeMemo = volumeMemo;
	}
}
