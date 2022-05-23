package com.sshop.asset.command.application;

import com.sshop.asset.command.domain.category.CategoryNo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class CreateResourceRequest {
	CategoryNo id;
	String name;

	Map<String, Object> data;
}
