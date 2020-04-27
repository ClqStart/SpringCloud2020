package com.atguigu.springcloud.config;

/*
 *@author:C1q
 */

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                r -> r.path("/guoji")
                        .uri("https://news.baidu.com/guoji"))
                .route("path_route_atguigu1",
                        r -> r.path("/guonei")
                                .uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

}



