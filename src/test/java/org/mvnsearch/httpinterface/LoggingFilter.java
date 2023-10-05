package org.mvnsearch.httpinterface;

import org.springframework.lang.NonNull;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;


public class LoggingFilter implements ExchangeFilterFunction {

    @Override
    public Mono<ClientResponse> filter(@NonNull ClientRequest request, ExchangeFunction next) {
        System.out.println("request: " + request.url());
        return next.exchange(request);
    }
}
