package org.mvnsearch.httpinterface;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

public interface HttpBinClient {
    @GetExchange("/ip")
    Mono<MyIp> myIp(@RequestParam String demo);

    record MyIp(String origin) {
    }

}




