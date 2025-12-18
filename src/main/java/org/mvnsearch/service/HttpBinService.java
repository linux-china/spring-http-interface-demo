package org.mvnsearch.service;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url = "https://httpbin.org")
public interface HttpBinService {
    @GetExchange("/ip")
    Mono<MyIp> myIp();

    record MyIp(String origin) {
    }
}
