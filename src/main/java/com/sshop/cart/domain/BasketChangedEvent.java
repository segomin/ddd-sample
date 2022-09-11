package com.sshop.cart.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class BasketChangedEvent {
	Long basketId;
}
