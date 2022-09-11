package com.sshop.resource.application.service;

import com.google.gson.Gson;
import com.sshop.cart.application.port.out.CreateCartPort;
import com.sshop.cart.domain.Cart;
import com.sshop.cart.application.port.out.ReadCartPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;


interface AwsSimulator {

	CompletableFuture<String> runAwsSimulation(ResourceEC2 ec2);
}

class ResourceEC2 {

	SimulationState simulationState;
	public static ResourceEC2 fromJsonString(String jsonData) {
		return new Gson().fromJson(jsonData, ResourceEC2.class);
	}

	public void setProcessSimulationStatus(SimulationState state) {
		simulationState = state;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	public void setProcessSimulationStart() {
		this.simulationState = Optional
				.ofNullable(this.simulationState)
				.orElse(new SimulationState());
		simulationState.state = "PROCEED";
	}

	public static class SimulationState {
		public String state;
		public String memo;

		public SimulationState(String done, String s) {
			this.state = done;
			this.memo = s;
		}

		public SimulationState() {
			this("", "");
		}
	}
}

@RequiredArgsConstructor
@Service
public class ResourceSimulationService {
	final AwsSimulator awsSimulator = ec2 -> CompletableFuture.failedFuture(new Error("failed to simul"));

	final ReadCartPort readCartPort;
	final CreateCartPort createCartPort;

	@Transactional (propagation = Propagation.REQUIRES_NEW)
	public Cart.CartId simulateBasketResource(Long basketIdx) {
		var basket = readCartPort.findByIdx(basketIdx);
		ResourceEC2 ec2 = setCartSimulationStarted(basket);

		CompletableFuture<String> simulateResult = awsSimulator.runAwsSimulation(ec2);

		simulateResult.handleAsync((result, error) -> setCartSimulationCompleted(basketIdx, result, error));

		return Cart.CartId.of(basketIdx);
	}

	@Transactional (propagation = Propagation.REQUIRES_NEW)
	Cart setCartSimulationCompleted(Long basketIdx, String result, Throwable error) {
		ResourceEC2.SimulationState state;
		if (result != null) {
			state = new ResourceEC2.SimulationState("DONE", "");
		} else {
			state = new ResourceEC2.SimulationState("ERROR", error.getMessage());
		}
		var basketOpt = readCartPort.findByIdxOptional(basketIdx);
		var basket = basketOpt.orElseThrow();
		var ec2 = ResourceEC2.fromJsonString(basket.getJsonData());

		ec2.setProcessSimulationStatus(state);
		basket.changeJsonData(ec2.toJson());
		createCartPort.saveCart(basket);

		return basket;
	}

	private ResourceEC2 setCartSimulationStarted(Cart basket) {
		var ec2 = ResourceEC2.fromJsonString(basket.getJsonData());

		ec2.setProcessSimulationStart();
		basket.changeJsonData(ec2.toJson());
		createCartPort.saveCart(basket);
		return ec2;
	}
}
