package com.sshop.cart.application.service.model;

import lombok.Value;

import java.util.List;

@Value
public class CreateCartComputeRequest extends CreateCartRequest {
	private List<Integer> capacities;
	private String serviceEnv; // 서비스 구분
	private String serviceType; // 서비스 유형
	private String diskType; // 고사양 선택

	public CreateCartComputeRequest(Long memberId, Long projectId, int price, String categoryNo, String resourceNo, Integer quantity, List<Integer> capacities, String serviceEnv, String serviceType, String diskType) {
		super(memberId, projectId, price, categoryNo, resourceNo, quantity);
		this.capacities = capacities;
		this.serviceEnv = serviceEnv;
		this.serviceType = serviceType;
		this.diskType = diskType;
	}
}
