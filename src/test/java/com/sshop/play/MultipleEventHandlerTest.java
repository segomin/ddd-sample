package com.sshop.play;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 다중 이벤트 리스너 사용시 순서 보장 필요시 Order(N) 사용
 */
//@Disabled
class MultipleEventHandlerTest {
	private final ApplicationContextRunner runner = new ApplicationContextRunner();

	@Test
	void happyPathSuccess() {
		var sideEffectCausedByEvent = new ArrayList<String>();
		ObservableEffect effectA = () -> sideEffectCausedByEvent.add("A");
		ObservableEffect effectB = () -> sideEffectCausedByEvent.add("B");

		runner.withBean(SomeEventListener.class, effectA, effectB).run(context -> {
			context.publishEvent(new SomeEvent());
			Assertions.assertEquals(sideEffectCausedByEvent, List.of("B", "A"));
		});
	}

	public interface ObservableEffect {
		void effect();
	}

	@Component
	public static class SomeEventListener {

		private final ObservableEffect effectA;
		private ObservableEffect effectB;

		public SomeEventListener(ObservableEffect effectA, ObservableEffect effectB) {
			this.effectA = effectA;
			this.effectB = effectB;
		}

		@Order (2)
		@EventListener (SomeEvent.class)
		public void listenA() {
			effectA.effect();
		}

		@Order (1)
		@EventListener (SomeEvent.class)
		public void listenB() {
			effectB.effect();
		}
	}

	public static class SomeEvent {}

}