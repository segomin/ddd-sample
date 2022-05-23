package com.sshop.asset.command.domain.resource;

public interface CreateComputeRepository extends ResourceRepository {

	void save(ResourceCompute compute);
}