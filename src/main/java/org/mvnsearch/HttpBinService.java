package org.mvnsearch;

import com.maciejwalkowiak.spring.http.annotation.HttpClient;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

@HttpClient("httpbin-client")
@Service
public interface HttpBinService {
    @GetExchange("/ip")
    Mono<MyIp> myIp();

    record MyIp(String origin) {
    }
}
