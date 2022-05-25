package com.sshop.application.model.cart;

import com.sshop.application.model.resource.Resource;
import com.sshop.domain.model.cart.Cart;
import lombok.Value;

@Value
public class CartResponse {
	public static Resource of(Cart it) {
		return null; // type 에 따라 ComputeDTO, StorageDTO resource 구상클래스로 변환
	}
}
