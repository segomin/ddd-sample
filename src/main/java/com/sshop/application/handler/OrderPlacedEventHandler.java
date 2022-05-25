package com.sshop.application.handler;

import com.sshop.domain.model.order.OrderPlacedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// adapter.in 으로 옮겨야 할지 고민..
@Component
public class OrderPlacedEventHandler {
//    @Autowired
//    EditCartService editCartService;

    @EventListener(OrderPlacedEvent.class)
    public void handle(OrderPlacedEvent event) {
        // order 생성관련 event 처리
    }
}
