package com.sshop.asset.infra.resource;

import com.sshop.asset.command.domain.resource.CreateComputeRepository;
import com.sshop.asset.command.domain.resource.CreateDatabaseRepository;
import com.sshop.asset.command.domain.resource.Resource;
import com.sshop.asset.command.domain.resource.ResourceCompute;
import com.sshop.asset.command.domain.resource.ResourceDatabase;
import com.sshop.asset.command.domain.resource.ResourceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepositoryImpl implements CreateDatabaseRepository, CreateComputeRepository {

	@Autowired
	JpaResourceRepository jpaResourceRepository;

	@Override
	public void save(ResourceDatabase database) {
		jpaResourceRepository.save(database);
		// todo transport to ResourceColumns and save
	}

	@Override
	public void save(ResourceCompute compute) {
		jpaResourceRepository.save(compute);
		// todo transport to ResourceColumns and save
	}
}