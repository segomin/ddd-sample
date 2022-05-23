package com.sshop.asset.command.domain.resource;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public interface ResourceRepository {
	default ResourceNo nextResourceNo() {
		int randomNo = ThreadLocalRandom.current().nextInt(900000) + 100000;
		String number = String.format("%tY%<tm%<td%<tH-%d", new Date(), randomNo);
		return new ResourceNo(number);
	}
}