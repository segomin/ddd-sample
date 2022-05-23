package com.sshop.asset.ui;

import com.sshop.asset.command.application.resource.CreateComputeRequest;
import com.sshop.asset.command.application.resource.CreateDatabaseRequest;
import com.sshop.asset.command.application.CreateResourceRequest;
import com.sshop.asset.command.application.SimpleRequest;
import com.sshop.asset.command.application.resource.CreateResourceService;
import com.sshop.asset.command.domain.resource.ResourceId;
import com.sshop.asset.command.domain.resource.ResourceNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/cmp/v1/work/resources")
public class ResourceController {
	@Autowired
	CreateResourceService createResourceService;

	@PostMapping (value = "/db")
	public ResourceId createDatabase(@RequestBody CreateDatabaseRequest request) {
		return createResourceService.createDataBase(request);
	}

	@PostMapping (value = "/compute")
	public ResourceId createCompute(@RequestBody CreateComputeRequest request) {
		return createResourceService.createCompute(request);
	}

	@PostMapping (value = "/simple")
	public SimpleRequest createSimple(@RequestBody SimpleRequest simpleRequest) {
		return simpleRequest;
	}
}
