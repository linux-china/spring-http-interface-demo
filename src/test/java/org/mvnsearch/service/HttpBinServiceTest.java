package org.mvnsearch.service;

import org.junit.jupiter.api.Test;
import org.mvnsearch.SpringBootBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;


public class HttpBinServiceTest extends SpringBootBaseTest {
    @Autowired
    private HttpBinService httpBinService;

    @Test
    public void testMyIp() {
        StepVerifier.create(httpBinService.myIp())
                .assertNext(myIp -> System.out.println(myIp.origin()))
                .verifyComplete();
    }
}
