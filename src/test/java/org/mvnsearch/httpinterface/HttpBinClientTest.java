package org.mvnsearch.httpinterface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class HttpBinClientTest {
    private static HttpBinClient httpBinClient;

    @BeforeAll
    public static void setUp() {
        WebClient webClient = WebClient.builder().baseUrl("https://httpbin.org").filter(new LoggingFilter()).build();
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder().exchangeAdapter(WebClientAdapter.create(webClient)).build();
        httpBinClient = httpServiceProxyFactory.createClient(HttpBinClient.class);
    }

    @Test
    public void testClient() throws Exception {
        System.out.println(httpBinClient.myIp("dabc").block().origin());
    }

    @Test
    public void testPost() throws Exception {
        MultipartFile multipartFile = new MockMultipartFile("demo.txt", "demo.txt", "text/plain", "Hello World!".getBytes());
        final String result = httpBinClient.upload("batch", multipartFile.getResource()).block();
        System.out.println(result);

    }
}
