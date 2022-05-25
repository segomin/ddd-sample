package com.sshop.cart.service.model;

import com.sshop.task.service.model.Resource;
import com.sshop.cart.domain.Cart;
import lombok.Value;

@Value
public class CartResponse {
	public static Resource of(Cart it) {
		return null; // type 에 따라 ComputeDTO, StorageDTO resource 구상클래스로 변환
	}
}
