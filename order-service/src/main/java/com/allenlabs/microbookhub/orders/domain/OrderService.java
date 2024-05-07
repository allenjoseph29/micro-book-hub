package com.allenlabs.microbookhub.orders.domain;

import com.allenlabs.microbookhub.orders.domain.models.CreateOrderRequest;
import com.allenlabs.microbookhub.orders.domain.models.CreateOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public CreateOrderResponse createOrder(String userName, CreateOrderRequest request) {
        OrderEntity newOrder = OrderMapper.convertToEntity(request);
        newOrder.setUserName(userName);
        orderRepository.save(newOrder);
        log.info("Order created: {}", newOrder.getOrderNumber());
        return new CreateOrderResponse(newOrder.getOrderNumber());
    }
}
