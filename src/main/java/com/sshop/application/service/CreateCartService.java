package com.sshop.application.service;

import com.sshop.application.model.cart.CreateCartComputeRequest;
import com.sshop.application.model.cart.CreateCartStorageRequest;
import com.sshop.common.ValidationError;
import com.sshop.common.ValidationErrorException;
import com.sshop.domain.model.cart.Cart;
import com.sshop.domain.model.cart.CartId;
import com.sshop.domain.model.cart.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateCartService {
	@Autowired
	CartRepository cartRepository;
	public CartId createStorage(CreateCartStorageRequest request) {
		// domain 데이터에 맞게 변경
		var cart = new Cart(request.getMemberId(),
				request.getPrice(),
				request.getProjectId(),
				request.getVolumeGroupName(),
				request.getVolumeMemo(),
				request.getCapacities().toString());
		cartRepository.save(cart);
		return cart.getId();
	}

	public CartId createCompute(CreateCartComputeRequest request) {
		List<ValidationError> errors = validateComputeRequest(request);
		if (!errors.isEmpty()) throw new ValidationErrorException(errors);

		var cart = new Cart(request.getMemberId(), request.getPrice(), request.getProjectId(),
				request.getServiceType(),
				request.getServiceEnv(),
				request.getDiskType());
		cartRepository.save(cart);
		return cart.getId();
	}

	private List<ValidationError> validateComputeRequest(CreateCartComputeRequest request) {
		return new ComputeRequestValidator().validate(request);
	}

}
