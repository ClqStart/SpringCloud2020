package com.atguigu.springcloud.filter;





import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;


/*
 *@author:C1q
 */
@Component
@Slf4j
@Order(0)
public class MyLogGateWayFilter  implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**********************come in MyLogGateWayFilter"+new Date());

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname==null){
            log.info("%%%%%%%%%%%%%%%%用户名为null,非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return  chain.filter(exchange);

    }

}
