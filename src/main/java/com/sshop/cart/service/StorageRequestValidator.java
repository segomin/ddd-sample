package com.sshop.cart.service;

import com.sshop.cart.service.model.CreateCartStorageRequest;
import com.sshop.common.ValidationError;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StorageRequestValidator {
	public List<ValidationError> validate(CreateCartStorageRequest request) {
		var errors = new ArrayList<ValidationError>();
		if (!StringUtils.hasText(request.getVolumeMemo())) {
			errors.add(new ValidationError("no volume memo", "some code"));
		}
		if (!StringUtils.hasText(request.getVolumeGroupName())) {
			errors.add(new ValidationError("no volume group name", "some code"));
		}
		// add more validation check

		return Collections.unmodifiableList(errors);
	}
}
