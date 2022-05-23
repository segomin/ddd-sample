package com.sshop.asset.command.application.resource;

import com.sshop.asset.command.domain.resource.CreateComputeRepository;
import com.sshop.asset.command.domain.resource.CreateDatabaseRepository;
import com.sshop.asset.command.domain.resource.ResourceDatabase;
import com.sshop.asset.command.domain.resource.SomeData;
import com.sshop.common.ValidationErrorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateResourceServiceTest {

	@DisplayName("CreateDatabase 필드가 부족한 경우 Validation Error 발생")
	@Test
	void createDataBase_whenMissingField_throwError() {
		var service = new CreateResourceService(null, null);

		var req = new CreateDatabaseRequest("c", "r", null, List.of(), new SomeData(10, "10"));
		Assertions.assertThrows(ValidationErrorException.class, () -> service.createDataBase(req));
	}

	@DisplayName("CreateDatabase 필드가 충분할 경우 정상 저장")
	@Test
	void createDataBase_whenSufficientField_saveOk() {
		AtomicReference<ResourceDatabase> spy = new AtomicReference<>();
		CreateDatabaseRepository repository = database -> spy.set(database);
		var service = new CreateResourceService(repository, null);

		var req = new CreateDatabaseRequest("c", "r", "img", List.of(), new SomeData(10, "10"));
		service.createDataBase(req);

		assertEquals("r", spy.get().getResourceName());
		assertEquals("img", spy.get().getImageName());
	}

	@MethodSource ("provideCreateComputeRequestMissingField")
	@DisplayName("CreateCompute 필드가 부족한 경우 Validation Error 발생")
	@ParameterizedTest
	void createCompute_whenMissingField_throwError(CreateComputeRequest request) {
		var service = new CreateResourceService(null, null);
		Assertions.assertThrows(ValidationErrorException.class, () -> service.createCompute(request));
	}

	private static Stream<CreateComputeRequest> provideCreateComputeRequestMissingField() { // argument source method
		return Stream.of(
				new CreateComputeRequest("c", "r", null),
				new CreateComputeRequest("c", null, "cpu"),
				new CreateComputeRequest(null, "r", "cpu")
		);
	}

}