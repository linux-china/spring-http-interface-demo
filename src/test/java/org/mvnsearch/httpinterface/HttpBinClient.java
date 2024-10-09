package org.mvnsearch.httpinterface;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;


public interface HttpBinClient {
    @GetExchange("/ip")
    Mono<MyIp> myIp(@RequestParam String demo);

    record MyIp(String origin) {
    }

    @PostExchange("/post")
    Mono<String> upload(@RequestPart("purpose") String purpose, @RequestPart("file") Resource file);

}




