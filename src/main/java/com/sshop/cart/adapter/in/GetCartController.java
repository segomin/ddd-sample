package com.sshop.cart.adapter.in;

import com.sshop.cart.application.service.CartQueryService;
import com.sshop.task.service.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/cmp/v1/work/shop/carts")
public class GetCartController {
	@Autowired
	CartQueryService cartQueryService;


	@GetMapping ("")
	public List<Resource> findCartByMember() {
		Long memberId = 1L; // get from session or something
		return cartQueryService.findByMemberId(memberId);
	}
}
