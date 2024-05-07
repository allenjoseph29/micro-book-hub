package com.allenlabs.microbookhub.orders.web.controllers;

import com.allenlabs.microbookhub.orders.domain.OrderService;
import com.allenlabs.microbookhub.orders.domain.SecurityService;
import com.allenlabs.microbookhub.orders.domain.models.CreateOrderRequest;
import com.allenlabs.microbookhub.orders.domain.models.CreateOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final SecurityService securityService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateOrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        String userName = securityService.getLoginUserName();
        log.info("Creating order for user {}", userName);
        return orderService.createOrder(userName, request);
    }
}
