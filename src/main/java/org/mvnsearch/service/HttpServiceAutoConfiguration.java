package org.mvnsearch.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class HttpServiceAutoConfiguration {

    @Bean
    public HttpBinService httpBinService() {
        WebClient webClient = WebClient.builder().baseUrl("https://httpbin.org").build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(webClient)).build();
        return httpServiceProxyFactory.createClient(HttpBinService.class);
    }
}
