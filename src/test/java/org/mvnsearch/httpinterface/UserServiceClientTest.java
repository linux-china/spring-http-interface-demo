package org.mvnsearch.httpinterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mvnsearch.service.UserHttpService;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class UserServiceClientTest {
    private static UserHttpService userHttpService;

    @BeforeAll
    public static void setUp() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.forClient(webClient)).build();
        userHttpService = httpServiceProxyFactory.createClient(UserHttpService.class);
    }

    @Test
    public void testClient() throws Exception {
        System.out.println(userHttpService.show("linux_china").block().email());
    }

}
