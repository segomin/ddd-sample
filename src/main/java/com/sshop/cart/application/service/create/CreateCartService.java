package com.sshop.cart.application.service.create;

import com.sshop.cart.application.port.out.CreateCartPort;
import com.sshop.cart.domain.Cart;
import com.sshop.common.ValidationError;
import com.sshop.common.ValidationErrorException;
import com.sshop.common.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateCartService {
	private final CreateCartPort createCartPort;

	public Cart.CartId createStorage(CreateCartStorageRequest request) {
		// domain 데이터에 맞게 변경
		var cart = new Cart(request.getMemberId(),
				request.getPrice(),
				request.getProjectId(),
				request.getVolumeGroupName(),
				request.getVolumeMemo(),
				request.getCapacities().toString());
		createCartPort.saveCart(cart);
		return cart.getId();
	}

	public Cart.CartId createCompute(CreateCartComputeRequest request) {
		List<ValidationError> errors = validateComputeRequest(request);
		if (!errors.isEmpty()) throw new ValidationErrorException(errors);

		var cart = new Cart(request.getMemberId(), request.getPrice(), request.getProjectId(),
				request.getServiceType(),
				request.getServiceEnv(),
				request.getDiskType());
		createCartPort.saveCart(cart);
		return cart.getId();
	}

	private List<ValidationError> validateComputeRequest(CreateCartComputeRequest request) {
		return new ComputeRequestValidator().validate(request);
	}

}
