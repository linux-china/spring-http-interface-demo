package org.mvnsearch.httpinterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mvnsearch.microservices.annotator.RemoteAccess;
import org.mvnsearch.service.UserHttpService;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

public class UserServiceClientTest {
    @RemoteAccess
    private static UserHttpService userHttpService;

    @Test
    public void testClient() throws Exception {
        final Mono<UserHttpService.User> user = userHttpService.show("linux_china");
    }

    @BeforeAll
    public static void setUp() {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(webClient)).build();
        userHttpService = httpServiceProxyFactory.createClient(UserHttpService.class);
    }

}
