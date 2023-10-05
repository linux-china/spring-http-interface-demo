package org.mvnsearch.httpinterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class HttpBinClientTest {
    private static HttpBinClient httpBinClient;

    @BeforeAll
    public static void setUp() {
        WebClient webClient = WebClient.builder().baseUrl("https://httpbin.org").filter(new LoggingFilter()).build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.forClient(webClient)).build();
        httpBinClient = httpServiceProxyFactory.createClient(HttpBinClient.class);
    }

    @Test
    public void testClient() throws Exception {
        System.out.println(httpBinClient.myIp("dabc").block().origin());
    }

}
