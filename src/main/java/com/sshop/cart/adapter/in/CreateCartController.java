package com.sshop.cart.adapter.in;

import com.sshop.cart.application.service.create.CreateCartService;
import com.sshop.cart.application.service.create.CreateCartComputeRequest;
import com.sshop.cart.application.service.create.CreateCartStorageRequest;
import com.sshop.cart.domain.Cart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping ("/api/cmp/v1/work/shop/carts")
public class CreateCartController {
	@Autowired
	CreateCartService createCartService;

	static Integer count = 0;

	@PostMapping ("/storage")
	public Cart.CartId createCartStorage(@RequestBody CreateCartStorageRequest createCartStorageRequest) {
		return createCartService.createStorage(createCartStorageRequest);
	}

	@PostMapping ("/compute")
	public Cart.CartId createCartCompute(@RequestBody CreateCartComputeRequest createCartComputeRequest) {
		return createCartService.createCompute(createCartComputeRequest);
	}

	@GetMapping ("/ping/{loop}")
	@Transactional
	public String ping(@PathVariable("loop") Integer loop) throws InterruptedException {
//		final String uri = "http://localhost:8083/rest/hello-world/pong";
		final String uri = "http://localhost:8081/api/cmp/v1/work/shop/carts/pong/" + loop;

		if (count++ < loop) {
			Thread.sleep(500);
			var curCount = count;
			RestTemplate restTemplate = new RestTemplate();
			log.info("in PING: " + curCount);
			String result = restTemplate.getForObject(uri, String.class);
		}
		if (count == loop){
			count = 0;
		}

		return "PING";
	}

	@GetMapping ("/pong/{loop}")
	@Transactional
	public String pong(@PathVariable("loop") Integer loop) {
		final String uri = "http://localhost:8080/api/cmp/v1/work/shop/carts/ping/" + loop;

		RestTemplate restTemplate = new RestTemplate();
		log.info("in PONG: " + count);
		if (count++ < loop) {
			String result = restTemplate.getForObject(uri, String.class);
			log.info("in PONG: " + result);
		}

		if (count == loop){
			count = 0;
		}
		return "PONG";
	}

	@GetMapping ("/start/{loop}")
	public String live(@PathVariable("loop") Integer loop) throws InterruptedException {
		count = 0;
		this.ping(loop);
		return "LIVE";
	}

	//	public List<OrderBasketData> getOrderBasketDatasByProjectIdxList(@RequestParam (name = "projectIdxList", required = false) Integer[] projectIdxList) {
//		return basketService.getOrderBasketDatasByProjectIdxList(projectIdxList);
//	}

}
