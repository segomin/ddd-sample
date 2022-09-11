package com.sshop.resource.adapter.in;

import com.sshop.resource.application.service.ResourceSimulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Api (tags = "Resource Simpulation")
@RequestMapping ("/api/cmp/v1/work/resources")
public class ResourceSimulationController {
	@Autowired
	ResourceSimulationService resourceSimulationService;

	@GetMapping ("/simulation")
	@ApiOperation (value = "장바구니 자원 시뮬레이션", notes = "장바구니 자원을 시뮬레이션")
	public void createOrderBasketData() {
		resourceSimulationService.simulateBasketResource(1L);
	}
}
