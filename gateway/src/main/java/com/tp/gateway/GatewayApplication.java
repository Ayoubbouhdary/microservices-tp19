package com.tp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("clients-route", r -> r
                        .path("/clients/**")
                        .uri("http://localhost:8088"))
                .route("client-route", r -> r
                        .path("/client/**")
                        .uri("http://localhost:8088"))
                .route("voitures-route", r -> r
                        .path("/voitures/**")
                        .uri("http://localhost:8089"))
                .build();
    }
}