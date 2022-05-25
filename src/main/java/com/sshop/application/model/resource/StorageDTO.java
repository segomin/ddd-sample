package com.sshop.application.model.resource;

import java.util.List;

public record StorageDTO(
		List<Integer> capacities,
		String volumeGroupName,
		String volumeMemo
) implements Resource {
}
