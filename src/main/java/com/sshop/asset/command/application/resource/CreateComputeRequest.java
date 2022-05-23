package com.sshop.asset.command.application.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateComputeRequest {
	String categoryNo;
	String resourceName;
	String cpu;
}
