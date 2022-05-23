package com.sshop.asset.command.application.resource;

import com.sshop.common.ValidationError;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeRequestValidator {
	public List<ValidationError> validate(CreateComputeRequest request) {
		var errors = new ArrayList<ValidationError>();
		if (!StringUtils.hasText(request.getCategoryNo())) {
			errors.add(new ValidationError("no category number", "some code"));
		}
		if (!StringUtils.hasText(request.getResourceName())) {
			errors.add(new ValidationError("no resource name", "some code"));
		}
		if (!StringUtils.hasText(request.getCpu())) {
			errors.add(new ValidationError("no cpu info", "some code"));
		}
		// add more validation check

		return Collections.unmodifiableList(errors);
	}
}
