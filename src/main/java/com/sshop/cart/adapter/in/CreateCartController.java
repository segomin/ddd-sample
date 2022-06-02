package com.sshop.cart.adapter.in;

import com.sshop.cart.application.service.CreateCartService;
import com.sshop.cart.application.service.model.CreateCartComputeRequest;
import com.sshop.cart.application.service.model.CreateCartStorageRequest;
import com.sshop.cart.domain.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/cmp/v1/work/shop/carts")
public class CreateCartController {
	@Autowired
	CreateCartService createCartService;

	@PostMapping ("/storage")
	public Cart.CartId createCartStorage(@RequestBody CreateCartStorageRequest createCartStorageRequest) {
		return createCartService.createStorage(createCartStorageRequest);
	}

	@PostMapping ("/compute")
	public Cart.CartId createCartCompute(@RequestBody CreateCartComputeRequest createCartComputeRequest) {
		return createCartService.createCompute(createCartComputeRequest);
	}

	//	public List<OrderBasketData> getOrderBasketDatasByProjectIdxList(@RequestParam (name = "projectIdxList", required = false) Integer[] projectIdxList) {
//		return basketService.getOrderBasketDatasByProjectIdxList(projectIdxList);
//	}

}
