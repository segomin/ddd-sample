package com.sshop.cart.service;

import com.sshop.cart.service.ComputeRequestValidator;
import com.sshop.cart.service.model.CreateCartComputeRequest;
import com.sshop.cart.service.model.CreateCartStorageRequest;
import com.sshop.common.ValidationError;
import com.sshop.common.ValidationErrorException;
import com.sshop.cart.domain.Cart;
import com.sshop.cart.domain.CartId;
import com.sshop.cart.domain.CartRepository;
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
