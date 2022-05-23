package com.sshop.asset.command.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleRequest {
	String id;
	String name;
	String imageName;
}
