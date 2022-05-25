package com.sshop.application.model.resource;

import java.util.List;

public record ComputeDTO (
		List<Integer> capacities,
		String serviceEnv, // 서비스 구분
		String serviceType, // 서비스 유형
		String diskType // 고사양 선택
) implements Resource {
}
