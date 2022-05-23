package com.sshop.cart.ui;

import com.sshop.asset.command.application.SimpleRequest;
import com.sshop.asset.command.application.resource.CreateComputeRequest;
import com.sshop.asset.command.application.resource.CreateDatabaseRequest;
import com.sshop.asset.command.application.resource.CreateResourceService;
import com.sshop.asset.command.domain.resource.ResourceNo;
import com.sshop.cart.command.application.CreateCartRequest;
import com.sshop.cart.command.domain.AddCartService;
import com.sshop.cart.command.domain.CartId;
import com.sshop.cart.command.domain.CartNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/cmp/v1/work/carts")
public class AddCartController {
	@Autowired
	AddCartService addCartService;

	@PostMapping (value = "/")
	public CartId createCart(@RequestBody CreateCartRequest request) {
		return addCartService.addToCart(request);
	}

}
