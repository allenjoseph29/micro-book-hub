# micro-book-hub
MicroBookHub is a modern, microservices-based application for managing an online bookstore. Built with cutting-edge technologies and utilizing microservices architecture, MicroBookHub provides a scalable and robust platform for catalog management, order processing, notifications, and customer interaction.

# Modules:

1. catalog-service: Provides REST API for managing the catalog of products (books). Tech Stack: Spring Boot, Spring Data JPA, PostgreSQL.

2. order-service: Manages orders and publishes order events to the message broker. Tech Stack: Spring Boot, Spring Security OAuth2, Keycloak, Spring Data JPA, PostgreSQL, RabbitMQ.

3. notification-service: Listens to order events and sends notifications to users. Tech Stack: Spring Boot, RabbitMQ.

4. api-gateway: Acts as an API Gateway to the internal backend services (catalog-service, order-service). Tech Stack: Spring Boot, Spring Cloud Gateway.

5. bookstore-webapp: Customer-facing web application allowing browsing catalog, placing orders, and viewing order details. Tech Stack: Spring Boot, Spring Security OAuth2, Keycloak, Thymeleaf, Alpine.js, Bootstrap.
