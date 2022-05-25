package com.sshop.task.service.model;

import java.util.List;

public record StorageDTO(
		List<Integer> capacities,
		String volumeGroupName,
		String volumeMemo
) implements Resource {
}
