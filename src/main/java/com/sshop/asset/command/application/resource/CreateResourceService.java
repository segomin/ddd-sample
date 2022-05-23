package com.sshop.asset.command.application.resource;

import com.sshop.asset.command.domain.category.CategoryNo;
import com.sshop.asset.command.domain.resource.CreateComputeRepository;
import com.sshop.asset.command.domain.resource.CreateDatabaseRepository;
import com.sshop.asset.command.domain.resource.ResourceCompute;
import com.sshop.asset.command.domain.resource.ResourceDatabase;
import com.sshop.asset.command.domain.resource.ResourceId;
import com.sshop.asset.command.domain.resource.ResourceNo;
import com.sshop.common.ValidationError;
import com.sshop.common.ValidationErrorException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateResourceService {
	private final CreateDatabaseRepository createDatabaseRepository;
	private final CreateComputeRepository createComputeRepository;

	public CreateResourceService(CreateDatabaseRepository createDatabaseRepository, CreateComputeRepository createComputeRepository) {
		this.createDatabaseRepository = createDatabaseRepository;
		this.createComputeRepository = createComputeRepository;
	}

	/**
	 * Validation check
	 * Req 를 Model 로 변경
	 */
	public ResourceId createDataBase(CreateDatabaseRequest request) {
		List<ValidationError> errors = validateDatabaseRequest(request);
		if (!errors.isEmpty()) throw new ValidationErrorException(errors);

		var database = new ResourceDatabase(
				null,
				CategoryNo.of(request.getCategoryNo()),
				request.getResourceName(),
				request.getImageName(),
				request.getSomeList(),
				request.getSomeData()
		);

		createDatabaseRepository.save(database);

		return database.getId();
	}

	private List<ValidationError> validateDatabaseRequest(CreateDatabaseRequest request) {
		return new DatabaseRequestValidator().validate(request);
	}

	public ResourceId createCompute(CreateComputeRequest request) {
		List<ValidationError> errors = validateComputeRequest(request);
		if (!errors.isEmpty()) throw new ValidationErrorException(errors);

		var database = new ResourceCompute(
				null,
				CategoryNo.of(request.getCategoryNo()),
				request.getResourceName(),
				request.getCpu()
		);

		createComputeRepository.save(database);
		return database.getId();
	}

	private List<ValidationError> validateComputeRequest(CreateComputeRequest request) {
		return new ComputeRequestValidator().validate(request);
	}
}
