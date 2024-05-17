package com.allenlabs.microbookhub.webapp.clients.orders;

public record OrderConfirmationDTO(String orderNumber, OrderStatus status) {}
