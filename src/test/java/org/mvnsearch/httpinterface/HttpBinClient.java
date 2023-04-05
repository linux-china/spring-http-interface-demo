package org.mvnsearch.httpinterface;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Mono;

public interface HttpBinClient {
    @GetExchange("/ip")
    Mono<MyIp> myIp();

    record MyIp(String origin) {
    }

}




