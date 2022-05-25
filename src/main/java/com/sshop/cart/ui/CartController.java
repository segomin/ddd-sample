package com.sshop.cart.ui;

import com.sshop.cart.service.CartQueryService;
import com.sshop.cart.service.CreateCartService;
import com.sshop.cart.service.model.CreateCartComputeRequest;
import com.sshop.cart.service.model.CreateCartStorageRequest;
import com.sshop.task.service.model.Resource;
import com.sshop.cart.domain.CartId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/cmp/v1/work/shop/carts")
public class CartController {
	@Autowired
	CreateCartService createCartService;

	@Autowired
	CartQueryService cartQueryService;


	@GetMapping ("")
	public List<Resource> findCartByMember() {
		Long memberId = 1L; // get from memeberId
		return cartQueryService.findByMemberId(memberId);
	}

	@PostMapping ("/storage")
	public CartId createCartStorage(@RequestBody CreateCartStorageRequest createCartStorageRequest) {
		return createCartService.createStorage(createCartStorageRequest);
	}

	@PostMapping ("/compute")
	public CartId createCartCompute(@RequestBody CreateCartComputeRequest createCartComputeRequest) {
		return createCartService.createCompute(createCartComputeRequest);
	}

	//	public List<OrderBasketData> getOrderBasketDatasByProjectIdxList(@RequestParam (name = "projectIdxList", required = false) Integer[] projectIdxList) {
//		return basketService.getOrderBasketDatasByProjectIdxList(projectIdxList);
//	}

}
