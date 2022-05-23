package com.sshop.asset.command.application.resource;

import com.sshop.asset.command.domain.resource.SomeData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateDatabaseRequest {
	String categoryNo;
	String resourceName;
	String imageName;
	List<String> someList;
	SomeData someData;
}
