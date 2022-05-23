package com.sshop.asset.command.domain.resource;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public interface CreateDatabaseRepository extends ResourceRepository {

	void save(ResourceDatabase database);
}