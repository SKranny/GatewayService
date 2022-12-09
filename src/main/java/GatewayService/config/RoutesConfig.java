package GatewayService.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("person_service",
                        route -> route.path("/api/v1/account/**")
                                .uri("lb://person-service"))
                .route("friend_service",
                        route -> route.path("/api/v1/friends/**")
                                .uri("lb://friend-service"))
                .route("post_service",
                        route -> route.path("/api/v1/post/**")
                                .uri("lb://post-service"))
                .route("auth_service",
                        route -> route.path("/api/v1/auth/**")
                                .uri("lb://auth-service"))
                .build();
    }
}
