package com.sshop.cart.application.service.create;

import com.sshop.cart.application.service.create.CreateCartComputeRequest;
import com.sshop.common.ValidationError;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeRequestValidator {
	public List<ValidationError> validate(CreateCartComputeRequest request) {
		var errors = new ArrayList<ValidationError>();
		if (!StringUtils.hasText(request.getCategoryNo())) {
			errors.add(new ValidationError("no category number", "some code"));
		}
		if (!StringUtils.hasText(request.getDiskType())) {
			errors.add(new ValidationError("no disk type", "some code"));
		}
		// add more validation check

		return Collections.unmodifiableList(errors);
	}
}
