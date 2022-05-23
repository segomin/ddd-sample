package com.sshop.asset.command.application.resource;

import com.sshop.common.ValidationError;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseRequestValidator {
	public List<ValidationError> validate(CreateDatabaseRequest request) {
		var errors = new ArrayList<ValidationError>();
		if (!StringUtils.hasText(request.getImageName())) {
			errors.add(new ValidationError("no image name", "some code"));
		}
		if (!StringUtils.hasText(request.getResourceName())) {
			errors.add(new ValidationError("no resource name", "some code"));
		}
		// add more validation check

		return Collections.unmodifiableList(errors);
	}
}
